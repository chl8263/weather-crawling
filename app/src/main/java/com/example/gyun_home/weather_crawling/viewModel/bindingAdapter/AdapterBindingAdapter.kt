package com.example.gyun_home.weather_crawling.viewModel.bindingAdapter

import android.databinding.BindingAdapter
import android.widget.ImageView

object AdapterBindingAdapter {

    @JvmStatic
    @BindingAdapter("setweeklyAdapter")
    fun setweeklyAdapter(view : ImageView, itemid : Int){
        view.setImageResource(itemid)
    }
}