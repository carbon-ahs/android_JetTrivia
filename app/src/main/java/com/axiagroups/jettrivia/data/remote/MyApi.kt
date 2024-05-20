package com.axiagroups.jettrivia.data.remote

import retrofit2.http.GET


/**
 * Created by Ahsan Habib on 5/19/2024.
 * shehanuk.ahsan@gmail.com
 */
interface MyApi {
    @GET("topstories.json")
    suspend fun doNetworkCall()

}