package com.axiagroups.jettrivia.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.axiagroups.jettrivia.domain.model.Question
import com.axiagroups.jettrivia.domain.model.QuestionItem
import com.axiagroups.jettrivia.presentation.component.DrawDottedLine
import com.axiagroups.jettrivia.presentation.component.QuestionTracker
import com.axiagroups.jettrivia.presentation.ui.theme.mDarkPurple
import com.axiagroups.jettrivia.presentation.ui.theme.mOffWhite
import com.axiagroups.jettrivia.presentation.viewModel.QuestionsViewModel


/**
 * Created by Ahsan Habib on 5/23/2024.
 */
@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    viewModel: QuestionsViewModel = hiltViewModel(),
    question: QuestionItem = QuestionItem("jgre", "frenf", listOf("jf", "sdfhgur"), "kg"),
//    questionIndex: MutableState<Int>,
    onNextClick: (Int) -> Unit = {}
) {
    val questions = viewModel.data.value.data?.toMutableList()
    val loadStat = viewModel.data.value.loading



    val choicesState = remember(question) {
        question.choices.toMutableList()
    }
    val answerState = remember(question) {
        mutableStateOf<Int?>(null)
    }
    val correctAnswerState = remember {
        mutableStateOf<Boolean?>(null)
    }
    val updateAnswer: (Int) -> Unit = remember(question) {
        {
            answerState.value = it
            correctAnswerState.value = choicesState[it] == question.answer
        }

    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (loadStat == true) {
            CircularProgressIndicator(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        } else {

            questions?.size?.let { QuestionTracker(outOf = it) }
            DrawDottedLine()

            if (questions != null ) {
                Column {
                    Text(
                        text = "dgklfxnklfxhggrdlkfhxmffduftgkl",
                        modifier = Modifier
                            .padding(6.dp)
                            .fillMaxWidth(0.3f)
                            .align(alignment = Alignment.Start),
                        color = mOffWhite,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 22.sp
                    )
                    choicesState.forEachIndexed { index, answerText ->
                        Row(
                            modifier = Modifier
                                .padding(3.dp)
                                .fillMaxWidth()
                                .height(45.dp)
                                .border(
                                    width = 4.dp,
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            mDarkPurple,
                                            mDarkPurple
                                        )
                                    ),
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .clip(RoundedCornerShape(50))
                                .background(color = Color.Transparent),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (answerState.value == index),
                                onClick = { updateAnswer(index) },
                                modifier = Modifier.padding(start = 16.dp),
                                colors = RadioButtonDefaults.colors(
                                    selectedColor =
                                    if (correctAnswerState.value == true && index == answerState.value) {
                                        Color.Green.copy(alpha = 0.2f)
                                    } else {
                                        Color.Red.copy(alpha = 0.2f)
                                    }

                                )
                            )
                            Text(text = answerText)
                        }

                    }
                }
            }
        }

    }
}
