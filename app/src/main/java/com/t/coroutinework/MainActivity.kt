package com.t.coroutinework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            getDataFromApi()
        }

    }


    private suspend fun getDataFromApi() {
        val response = ApiRetrofit.getApiService().getUsers()
        if (response.isSuccessful) {
            Log.e("Success", response.body()!!.data[0].first_name)
        }

    }
}