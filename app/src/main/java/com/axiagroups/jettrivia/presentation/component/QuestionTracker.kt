package com.axiagroups.jettrivia.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axiagroups.jettrivia.presentation.ui.theme.mLightGray


/**
 * Created by Ahsan Habib on 5/23/2024.
 */

@Composable
fun QuestionTracker(
    modifier: Modifier = Modifier,
    counter: Int = 10,
    outOf: Int = 2156,
) {
    Text(
        text = buildAnnotatedString {
        withStyle(
            style = ParagraphStyle(textIndent = TextIndent.None)
        ) {
            withStyle(
                style = SpanStyle(
                    color = mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
            ) {
                append("Question $counter / ")

                withStyle(
                    style = SpanStyle(
                        color = mLightGray,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )) {
                    append("$outOf")

                }
            }
        }

    },
        modifier = modifier.padding(20.dp)
    )

}