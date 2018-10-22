package com.example.gyun_home.weather_crawling

import android.database.Observable
import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gyun_home.weather_crawling.databinding.MainBinding
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

    inner class getData : AsyncTask<Unit,Unit,String>(){
        override fun doInBackground(vararg p0: Unit?): String {
            var a : String = ""
            var doc= Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%84%9C%EC%9A%B8+%EB%82%A0%EC%94%A8").get()
            var address = doc.select(".btn_select")
            a += address.text()
            return a
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            temperature.text = result
        }
    }

}
