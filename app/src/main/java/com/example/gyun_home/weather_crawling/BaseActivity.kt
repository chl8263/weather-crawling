package com.example.gyun_home.weather_crawling

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.example.gyun_home.weather_crawling.util.ToastMake
import com.example.gyun_home.weather_crawling.viewModel.MainViewModel

open class BaseActivity : AppCompatActivity() {

    var inputMethodManager:InputMethodManager? = null

    val TIME_INTERVAL: Int = 2000
    var mBackpressed : Long? = 0L

    var mainViewModel:MainViewModel? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    }

    fun hidekeyBoard(){
        if(inputMethodManager != null && currentFocus != null)
            inputMethodManager!!.hideSoftInputFromWindow(currentFocus.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)

    }

    fun getMainViewmodel(): MainViewModel {
        if(mainViewModel == null){
            mainViewModel = MainViewModel()
        }
        return mainViewModel as MainViewModel

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBackPressed() {
        if(mBackpressed!! + TIME_INTERVAL > System.currentTimeMillis()){
            super.onBackPressed()
            return
        }else {
            ToastMake.make(this,getString(R.string.msg_quit))
        }
        mBackpressed = System.currentTimeMillis()
    }
}