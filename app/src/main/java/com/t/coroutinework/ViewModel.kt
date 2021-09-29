package com.t.coroutinework

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    var liveData: MutableLiveData<UserUperModel> = MutableLiveData();

    init {
        viewModelExample()
    }

    private fun viewModelExample() {
        viewModelScope.launch {
            getDataFromApi()
        }
    }


    private suspend fun getDataFromApi() {
        val response = ApiRetrofit.getApiService().getUsers()
        if (response.isSuccessful) {
            liveData.value = response.body()
        } else {
            liveData.value = null
        }

    }

    fun getResponse(): LiveData<UserUperModel> {
        return liveData
    }
}