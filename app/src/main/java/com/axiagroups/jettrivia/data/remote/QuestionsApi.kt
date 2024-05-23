package com.axiagroups.jettrivia.data.remote

import com.axiagroups.jettrivia.domain.model.Question
import retrofit2.http.GET


/**
 * Created by Ahsan Habib on 5/20/2024.
 * shehanuk.ahsan@gmail.com
 */
interface QuestionsApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}