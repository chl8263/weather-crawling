package com.example.gyun_home.weather_crawling

import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gyun_home.weather_crawling.databinding.MainBinding
import com.example.gyun_home.weather_crawling.viewModel.MainViewModel


class MainActivity : BaseActivity() {

    var binding : MainBinding? = null
    var model : MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        model = getMainViewmodel()

        binding!!.model = model;
    }
}
