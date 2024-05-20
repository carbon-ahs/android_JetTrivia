package com.axiagroups.jettrivia.data.mapper

import com.axiagroups.jettrivia.data.remote.dto.QuestionDto
import com.axiagroups.jettrivia.data.remote.dto.QuestionItemDto
import com.axiagroups.jettrivia.domain.model.Question
import com.axiagroups.jettrivia.domain.model.QuestionItem


/**
 * Created by Ahsan Habib on 5/20/2024.
 * shehanuk.ahsan@gmail.com
 */

fun QuestionDto.toQuestion(): Question {
    return Question()
}

fun QuestionItemDto.toQuestionItem(): QuestionItem {
    return QuestionItem(
        answer = answer,
        category = category,
        choices = choices,
        question = question
    )
}