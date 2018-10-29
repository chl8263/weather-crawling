package com.example.gyun_home.weather_crawling

import android.database.Observable
import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gyun_home.weather_crawling.databinding.MainBinding
import com.example.gyun_home.weather_crawling.model.TextData
import com.example.gyun_home.weather_crawling.viewModel.MainViewModel
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.util.*


class MainActivity : BaseActivity() {

    var binding: MainBinding? = null
    var model: MainViewModel? = null

    var document : Document? = null
    var contents: Element? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        model = getMainViewmodel()

        binding!!.model = model

        temperature.setText("aaa")
        getData().execute()
    }

    inner class getData : AsyncTask<Unit,Unit,TextData>(){
        override fun doInBackground(vararg p0: Unit?): TextData {
            var textData = TextData()

            var doc= Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%84%9C%EC%9A%B8+%EB%82%A0%EC%94%A8").get()

            var address = doc.select(".btn_select").first()
            var temperature = doc.select(".todaytemp").first()
            /*var temperaturemark =  doc.select(".tempmark")
            textData.temperature += temperaturemark.text()*/
            var mainsub1 = doc.select(".cast_txt").first()
            var mainsub2_1 = doc.select(".merge")
            var mainsub2_2 = doc.select(".sensible")


            var mid_temp = doc.select(".weather_item")
            var mid_time = doc.select(".item_time")

            for((i,value) in mid_temp.withIndex()){
                if(i == 8){
                    break
                }
                model!!.midtemp.add(value.text())
            }
            for((i,value) in mid_time.withIndex()){
                if(i == 8){
                    break
                }
                model!!.midtime.add(value.text())
            }


            var mid_time1 = doc.select(".dday")

            model!!.address.set(address.text())
            model!!.temperature.set(temperature.text())
            model!!.mainSub1.set(mainsub1.text())
            model!!.mainWetherImgLogic(mainsub1.text())
            model!!.mainSub2.set(mainsub2_1.text() + " | " + mainsub2_2.text())

            model!!.mid_temp1.set(model!!.midtemp.get(0))
            model!!.mid_temp2.set(model!!.midtemp.get(1))
            model!!.mid_temp3.set(model!!.midtemp.get(2))
            model!!.mid_temp4.set(model!!.midtemp.get(3))
            model!!.mid_temp5.set(model!!.midtemp.get(4))
            model!!.mid_temp6.set(model!!.midtemp.get(5))
            model!!.mid_temp7.set(model!!.midtemp.get(6))
            model!!.mid_temp8.set(model!!.midtemp.get(7))

            model!!.mid_time1.set(model!!.midtime.get(0))
            model!!.mid_time2.set(model!!.midtime.get(1))
            model!!.mid_time3.set(model!!.midtime.get(2))
            model!!.mid_time4.set(model!!.midtime.get(3))
            model!!.mid_time5.set(model!!.midtime.get(4))
            model!!.mid_time6.set(model!!.midtime.get(5))
            model!!.mid_time7.set(model!!.midtime.get(6))
            model!!.mid_time8.set(model!!.midtime.get(7))

            model!!.midtemp.clear()
            model!!.midtime.clear()

            return textData
        }

        override fun onPostExecute(result: TextData?) {
            super.onPostExecute(result)
           /* address.text= result!!.address
            temperature.text = result!!.temperature
            mainSub1.text = result!!.mainSub1
            mainSub2.text = result!!.mainSub2*/
        }
    }

}
