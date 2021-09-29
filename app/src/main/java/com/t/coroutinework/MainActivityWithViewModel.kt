package com.t.coroutinework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider

class MainActivityWithViewModel : AppCompatActivity() {
    lateinit var viewModel: ViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_with_view_model)
        initView()
        defineObserver()
    }


    private fun initView() {
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

    }


    private fun defineObserver() {
        var liveData: LiveData<UserUperModel> = viewModel.getResponse()
        liveData.observe(this) {
            if (it != null) {
                // Use your data
            }

        }
    }

}