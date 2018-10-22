package com.example.gyun_home.weather_crawling.viewModel

import android.databinding.ObservableField
import android.databinding.ObservableInt

class MainViewModel {

    var count : ObservableField<String> = ObservableField()

    constructor(){
        count.set("1")
    }

}