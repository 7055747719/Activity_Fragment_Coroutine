package com.t.coroutinework

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {

    companion object {
        val url: String = "https://reqres.in/api/"
        fun getApiService(): ApiService {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url).build().create(ApiService::class.java)
        }
    }
}