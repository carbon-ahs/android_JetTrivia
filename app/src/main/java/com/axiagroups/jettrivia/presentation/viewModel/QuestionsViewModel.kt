package com.axiagroups.jettrivia.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axiagroups.jettrivia.data.remote.response.DataOrException
import com.axiagroups.jettrivia.data.repository.QuestionRepository
import com.axiagroups.jettrivia.domain.model.QuestionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/23/2024.
 */
@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    private val apiData: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )

    public val data = apiData

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            apiData.value.loading = true
            apiData.value = repository.getAllQuestions()
            if (apiData.value.data.toString().isNotEmpty()) {
                apiData.value.loading = false
            }
        }

    }
}