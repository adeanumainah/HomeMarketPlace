package com.dean.homemarketplace.network

import com.dean.homemarketplace.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("data")
    fun getData():Call<ResponseModel>
}