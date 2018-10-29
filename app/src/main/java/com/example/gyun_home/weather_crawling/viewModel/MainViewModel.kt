package com.example.gyun_home.weather_crawling.viewModel

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.util.Log
import com.example.gyun_home.weather_crawling.R

class MainViewModel {

    var midtemp : ArrayList<String> = ArrayList()
    var midtime : ArrayList<String> = ArrayList()

    var address : ObservableField<String> = ObservableField()
    var temperature : ObservableField<String> = ObservableField()
    var mainSub1 : ObservableField<String> = ObservableField()
    var mainSub2 : ObservableField<String> = ObservableField()

    var mid_temp1 : ObservableField<String> = ObservableField()
    var mid_temp2 : ObservableField<String> = ObservableField()
    var mid_temp3 : ObservableField<String> = ObservableField()
    var mid_temp4 : ObservableField<String> = ObservableField()
    var mid_temp5 : ObservableField<String> = ObservableField()
    var mid_temp6 : ObservableField<String> = ObservableField()
    var mid_temp7 : ObservableField<String> = ObservableField()
    var mid_temp8 : ObservableField<String> = ObservableField()

    var mid_time1 : ObservableField<String> = ObservableField()
    var mid_time2 : ObservableField<String> = ObservableField()
    var mid_time3 : ObservableField<String> = ObservableField()
    var mid_time4 : ObservableField<String> = ObservableField()
    var mid_time5 : ObservableField<String> = ObservableField()
    var mid_time6 : ObservableField<String> = ObservableField()
    var mid_time7 : ObservableField<String> = ObservableField()
    var mid_time8 : ObservableField<String> = ObservableField()

    var mainImage : ObservableInt = ObservableInt()

    fun mainWetherImgLogic (msg : String){
        var splite  = msg.split(",")
        var img = drawimage(splite[0])
        mainImage.set(img)
    }
    fun drawimage(msg:String) : Int{
        when(msg) {
            "맑음" -> return R.drawable.ic_sun
        }
        return R.mipmap.ic_launcher
    }

}