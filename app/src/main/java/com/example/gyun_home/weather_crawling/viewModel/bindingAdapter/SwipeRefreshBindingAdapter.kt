package com.example.gyun_home.weather_crawling.viewModel.bindingAdapter

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout

object SwipeRefreshBindingAdapter {
    @JvmStatic
    @BindingAdapter("setOnRefreshListener")
    fun setOnRefreshListener(view : SwipeRefreshLayout , onRefreshListener: SwipeRefreshLayout.OnRefreshListener){
        view.setOnRefreshListener(onRefreshListener)
    }

    @JvmStatic
    @BindingAdapter("setSwipeLoading")
    fun setSwipeLoading(view : SwipeRefreshLayout , isLoading : Boolean){
        view.isRefreshing = isLoading
    }

}