package com.example.gyun_home.weather_crawling.viewModel

import android.databinding.BindingAdapter
import android.widget.ImageView

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("setimage")
    fun setImageView(view : ImageView , itemid : Int){
        view.setImageResource(itemid)
    }


}