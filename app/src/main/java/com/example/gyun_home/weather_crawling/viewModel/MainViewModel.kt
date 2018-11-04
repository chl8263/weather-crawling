package com.example.gyun_home.weather_crawling.viewModel

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.os.AsyncTask
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import com.example.gyun_home.weather_crawling.R
import com.example.gyun_home.weather_crawling.model.TextData
import com.example.gyun_home.weather_crawling.model.WeeklyItem
import org.jsoup.Jsoup
import java.util.*

class MainViewModel : SwipeRefreshLayout.OnRefreshListener{

    var weeklyList : ObservableArrayList<WeeklyItem> = ObservableArrayList()

    var showLoading = ObservableBoolean(false)

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


    inner class getData : AsyncTask<Unit, Unit, TextData>(){
        override fun doInBackground(vararg p0: Unit?): TextData {
            showLoading.set(true)

            var textData = TextData()

            var doc= Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%84%9C%EC%9A%B8+%EB%82%A0%EC%94%A8").get()

            var addressA = doc.select(".btn_select").first()
            var temperatureA = doc.select(".todaytemp").first()
            var temperaturemarkA =  doc.select(".tempmark").first()

            textData.temperature += temperaturemarkA.text()
            var mainsub1 = doc.select(".cast_txt").first()
            var mainsub2_1 = doc.select(".merge")
            var mainsub2_2 = doc.select(".sensible")


            var mid_temp = doc.select(".weather_item")
            var mid_time = doc.select(".item_time")
            var mid_img = doc.select(".list_area").first().children()

            var weekly = doc.select(".weekly").first().children()
            var weekName = weekly.select(".day_info")
            var weekuptext = weekly.select(".num")

            for( (i,value) in weekName.withIndex()){
                weeklyList.add(WeeklyItem(value.text(),null,null,null,null,null))
            }



            for( (i,value) in weekuptext.withIndex()){
                Log.e("down Name ", value.text())
            }



            for((i,value) in mid_temp.withIndex()){
                if(i == 8){
                    break
                }
                midtemp.add(value.text())
            }
            for((i,value) in mid_time.withIndex()){
                if(i == 8){
                    break
                }
                midtime.add(value.text())
            }
            for((i,value) in mid_img.withIndex()){
                midimg.add(value.text())
            }
            subWetherImgLogic()

            address.set(addressA.text())
            temperature.set(temperatureA.text())
            mainSub1.set(mainsub1.text())
            mainWetherImgLogic(mainsub1.text())
            mainSub2.set(mainsub2_1.text() + " | " + mainsub2_2.text())

            mid_temp1.set(midtemp.get(0))
            mid_temp2.set(midtemp.get(1))
            mid_temp3.set(midtemp.get(2))
            mid_temp4.set(midtemp.get(3))
            mid_temp5.set(midtemp.get(4))
            mid_temp6.set(midtemp.get(5))
            mid_temp7.set(midtemp.get(6))
            mid_temp8.set(midtemp.get(7))

            mid_time1.set(midtime.get(0))
            mid_time2.set(midtime.get(1))
            mid_time3.set(midtime.get(2))
            mid_time4.set(midtime.get(3))
            mid_time5.set(midtime.get(4))
            mid_time6.set(midtime.get(5))
            mid_time7.set(midtime.get(6))
            mid_time8.set(midtime.get(7))

            midtemp.clear()
            midtime.clear()
            midimg.clear()



            return textData
        }

        override fun onPostExecute(result: TextData?) {
            super.onPostExecute(result)
            /*address.text= result!!.address
            temperature.text = result!!.temperature
            mainSub1.text = result!!.mainSub1
            mainSub2.text = result!!.mainSub2*/
            showLoading.set(false)
        }
    }
    override fun onRefresh() {
        Log.e("aaaaaaa","wewewewewe")
        getData().execute()

    }

}