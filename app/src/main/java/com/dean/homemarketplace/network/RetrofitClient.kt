package com.dean.homemarketplace.network

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient{
    val BASE_URLRUMAH = "http://172.24.10.41/houseapp/"

    const val KEYRUMAH = "data"
    val interceptor = okhttp3.logging.HttpLoggingInterceptor().
    setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .retryOnConnectionFailure(true)
            .connectTimeout(15,TimeUnit.SECONDS)
            .build()
    val gson = GsonBuilder().setLenient().create()
    //api berita
    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URLRUMAH)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getInstance() : ApiService = retrofit.create(ApiService::class.java)

    //api makanan
    val retrofitMakanan = Retrofit.Builder()
            .baseUrl(BASE_URLRUMAH)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getInstanceRumah() : ApiService = retrofitMakanan.create(ApiService::class.java)

    val retrofitAuth = Retrofit.Builder()
            .baseUrl(BASE_URLRUMAH)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getInstanceAuth() : ApiService = retrofitAuth.create(ApiService::class.java)

}

//
//    private var retrofit: Retrofit? = null
//    fun getClient(url: String?): Retrofit? {
//        if (retrofit == null) {
//            retrofit = Retrofit.Builder().baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//        }
//        return retrofit
//    }
//}

