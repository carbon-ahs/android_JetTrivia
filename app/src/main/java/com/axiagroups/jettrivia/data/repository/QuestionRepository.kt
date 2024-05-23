package com.axiagroups.jettrivia.data.repository

import com.axiagroups.jettrivia.data.remote.QuestionsApi
import com.axiagroups.jettrivia.data.remote.response.DataOrException
import com.axiagroups.jettrivia.domain.model.QuestionItem
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/20/2024.
 * shehanuk.ahsan@gmail.com
 */
class QuestionRepository @Inject constructor(
    private val api: QuestionsApi
) {
    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (e: Exception) {
            dataOrException.e = e
        }

        return dataOrException
    }
}