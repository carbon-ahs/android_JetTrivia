package com.axiagroups.jettrivia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.axiagroups.jettrivia.presentation.ui.theme.JetTriviaTheme
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
                    NewScreen(
                        modifier = Modifier.padding(innerPadding),

                    )
                }
            }
        }
    }


}
@Composable
fun NewScreen(modifier: Modifier) {
    Box(modifier = modifier) {
      Text(text = "hgitio")
    }
}
