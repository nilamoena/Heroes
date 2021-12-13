package com.nilatilmoena.marvelapp.ui.details.Series

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nilatilmoena.marvelapp.R
import com.nilatilmoena.marvelapp.api.SeriesAPI
import com.nilatilmoena.marvelapp.models.series.Series
import com.nilatilmoena.marvelapp.ui.SeriesActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Series1 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : SeriesAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivSerResponseDet1 : ImageView
    private val evImgDet1 = "https://i.annihil.us/u/prod/marvel/i/mg/9/d0/51926fde9c18a/standard_fantastic.jpg"
    lateinit var tvSerResponseSerName1 : TextView
    lateinit var tvSerResponseSerDesc1 : TextView
    lateinit var tvSerResponseAttribution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series1)

        ivIntentBackDetail = findViewById(R.id.btnBackSerDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivSerResponseDet1 = findViewById(R.id.ivSerDet1)
        tvSerResponseSerName1 = findViewById(R.id.tvSerName1)
        tvSerResponseSerDesc1 = findViewById(R.id.tvSerDesc1)
        tvSerResponseAttribution = findViewById(R.id.tvAttribution)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(SeriesAPI::class.java)

        getSer()

        // Glide
        Glide.with(this)
            .load(evImgDet1)
            .fitCenter()
            .into(ivSerResponseDet1)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackSerDetail -> {
                val intentBackDetail = Intent(this@Series1, SeriesActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getSer() {
        val call: Call<Series> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Series> {
            override fun onResponse(call: Call<Series>, response: Response<Series>) {
                if (response.body() != null) {
                    tvSerResponseSerName1.text = response.body()!!.data.results[5].title
                    tvSerResponseSerDesc1.text = response.body()!!.data.results[5].description
                    tvSerResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Series>, t: Throwable) {
                tvSerResponseSerName1.setText("Error occured: " + t)
            }

        })
    }
}