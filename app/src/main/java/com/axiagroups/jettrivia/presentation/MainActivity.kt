package com.axiagroups.jettrivia.presentation

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.axiagroups.jettrivia.domain.model.QuestionItem
import com.axiagroups.jettrivia.presentation.screen.QuestionScreen
import com.axiagroups.jettrivia.presentation.ui.theme.JetTriviaTheme
import com.axiagroups.jettrivia.presentation.ui.theme.mDarkPurple
import com.axiagroups.jettrivia.presentation.viewModel.QuestionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetTriviaTheme {
//                val viewModel = hiltViewModel<MyViewModel>()


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuestionScreen(
                        modifier = Modifier.padding(innerPadding)
                            .background(color = mDarkPurple)
                    )
                }
            }
        }
    }
}
@Composable
fun NewScreen(
    modifier: Modifier,
    viewModel: QuestionsViewModel = hiltViewModel(),
) {
    val questions = viewModel.data.value.data?.toMutableList()
    val loadStat = viewModel.data.value.loading

    Box(modifier = modifier) {
        if (loadStat == true) Text(text = "Loding...") else Text(text = questions.toString())
    }
}
