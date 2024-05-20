package com.axiagroups.jettrivia.data.remote.dto

data class QuestionItemDto(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)
