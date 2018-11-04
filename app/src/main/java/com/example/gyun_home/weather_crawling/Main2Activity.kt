package com.example.gyun_home.weather_crawling

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gyun_home.weather_crawling.databinding.SubBinding
import com.example.gyun_home.weather_crawling.viewModel.SubViewModel

class Main2Activity : AppCompatActivity() {

    var binding : SubBinding? = null

    var model : SubViewModel? = SubViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        binding!!.model =model


    }
}
