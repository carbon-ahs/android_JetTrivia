package com.axiagroups.jettrivia.data.repository

import com.axiagroups.jettrivia.data.remote.MyApi
import com.axiagroups.jettrivia.domain.repository.MyRepository


/**
 * Created by Ahsan Habib on 5/19/2024.
 * shehanuk.ahsan@gmail.com
 */
class MyRepositoryImpl(
    private val api: MyApi
) : MyRepository {
    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")

    }
}