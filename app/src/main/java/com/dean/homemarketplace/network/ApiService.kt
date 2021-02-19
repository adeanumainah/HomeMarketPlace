package com.dean.homemarketplace.network

import com.dean.homemarketplace.modelrumah.RumahItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("person/get/")
    fun getDataRumah(
        @Query("api") apikey: String?
    ): Call<RumahItem>
}