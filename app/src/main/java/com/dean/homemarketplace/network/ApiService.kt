package com.dean.homemarketplace.network

import com.dean.homemarketplace.model.Home
import com.dean.homemarketplace.model.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @get:GET("person/get/")
    val product: Call<List<ResponseItem>>
}