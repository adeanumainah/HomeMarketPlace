package com.dean.homemarketplace.network

import com.dean.homemarketplace.utils.RetrofitClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val API_URL = "http://192.168.42.11/houseapp/index.php/"
    val productService: ApiService
        get() = RetrofitClient.getClient(API_URL)?.create(ApiService::class.java)!!
}