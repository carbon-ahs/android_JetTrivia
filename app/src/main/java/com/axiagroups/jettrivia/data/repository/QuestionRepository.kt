package com.axiagroups.jettrivia.data.repository

import com.axiagroups.jettrivia.data.remote.QuestionsApi
import com.axiagroups.jettrivia.data.remote.dto.QuestionItemDto
import com.axiagroups.jettrivia.data.remote.response.DataOrException
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/20/2024.
 * shehanuk.ahsan@gmail.com
 */
class QuestionRepository @Inject constructor(
    private val api: QuestionsApi
) {
    private val listOfQuestion =
        DataOrException<ArrayList<QuestionItemDto>,
                Boolean,
                Exception>()


}