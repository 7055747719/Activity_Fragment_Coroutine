package com.t.coroutinework

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {

    companion object {

        fun getApiService(): ApiService {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://reqres.in/api/").build().create(ApiService::class.java)
        }
    }
}