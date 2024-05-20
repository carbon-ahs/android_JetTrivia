package com.axiagroups.jettrivia.data.remote.response


/**
 * Created by Ahsan Habib on 5/20/2024.
 * shehanuk.ahsan@gmail.com
 */
data class DataOrException<T, Boolean, E: Exception> (
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)
