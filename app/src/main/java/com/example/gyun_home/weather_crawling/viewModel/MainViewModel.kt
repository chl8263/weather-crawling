package com.example.gyun_home.weather_crawling.viewModel

import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.util.Log
import com.example.gyun_home.weather_crawling.R
import java.util.*

class MainViewModel {

    var midtemp: ArrayList<String> = ArrayList()
    var midtime: ArrayList<String> = ArrayList()
    var midimg: ArrayList<String> = ArrayList()


    var address: ObservableField<String> = ObservableField()
    var temperature: ObservableField<String> = ObservableField()
    var mainSub1: ObservableField<String> = ObservableField()
    var mainSub2: ObservableField<String> = ObservableField()

    var mid_temp1: ObservableField<String> = ObservableField()
    var mid_temp2: ObservableField<String> = ObservableField()
    var mid_temp3: ObservableField<String> = ObservableField()
    var mid_temp4: ObservableField<String> = ObservableField()
    var mid_temp5: ObservableField<String> = ObservableField()
    var mid_temp6: ObservableField<String> = ObservableField()
    var mid_temp7: ObservableField<String> = ObservableField()
    var mid_temp8: ObservableField<String> = ObservableField()

    var mid_time1: ObservableField<String> = ObservableField()
    var mid_time2: ObservableField<String> = ObservableField()
    var mid_time3: ObservableField<String> = ObservableField()
    var mid_time4: ObservableField<String> = ObservableField()
    var mid_time5: ObservableField<String> = ObservableField()
    var mid_time6: ObservableField<String> = ObservableField()
    var mid_time7: ObservableField<String> = ObservableField()
    var mid_time8: ObservableField<String> = ObservableField()

    var mainImage: ObservableInt = ObservableInt()

    var midImage1: ObservableInt = ObservableInt()
    var midImage2: ObservableInt = ObservableInt()
    var midImage3: ObservableInt = ObservableInt()
    var midImage4: ObservableInt = ObservableInt()
    var midImage5: ObservableInt = ObservableInt()
    var midImage6: ObservableInt = ObservableInt()
    var midImage7: ObservableInt = ObservableInt()
    var midImage8: ObservableInt = ObservableInt()

    fun mainWetherImgLogic(msg: String) {
        var splite = msg.split(",")
        var img = drawimage(splite[0])
        mainImage.set(img)
    }

    fun subWetherImgLogic() {
        for ((i ,value) in this.midimg.withIndex()) {
            var splite = value.split(" ")
            midimg.set(i,splite[4])
        }
        setMidimage()
    }
    fun setMidimage(){
        midImage1.set(drawimage(midimg.get(0)))
        midImage2.set(drawimage(midimg.get(1)))
        midImage3.set(drawimage(midimg.get(2)))
        midImage4.set(drawimage(midimg.get(3)))
        midImage5.set(drawimage(midimg.get(4)))
        midImage6.set(drawimage(midimg.get(5)))
        midImage7.set(drawimage(midimg.get(6)))
        midImage8.set(drawimage(midimg.get(7)))
    }

    fun drawimage(msg: String): Int {
        when (msg) {
            "맑음" -> return getTimeClean()
            "비" -> return R.drawable.rain
            "흐림" -> return R.drawable.clouds
            "구름조금","구름많음" -> return R.drawable.suncloud
        }
        return R.mipmap.ic_launcher
    }
    fun getTimeClean() : Int{
        val tz = TimeZone.getTimeZone("Asia/Seoul")
        val gc = GregorianCalendar(tz)
        var hour= gc.get(GregorianCalendar.HOUR)
        if(hour < 6)
            return R.drawable.ic_sun
        else return R.drawable.ic_moon
    }


}