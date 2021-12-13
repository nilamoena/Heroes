package com.nilatilmoena.marvelapp.ui

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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SeriesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackSeries : ImageView

    lateinit var MarvelAPI : SeriesAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var tvSerResponse : TextView
    lateinit var tvSerResponse2 : TextView
    lateinit var tvSerResponse3 : TextView
    lateinit var tvSerResponse4 : TextView
    lateinit var tvSerResponse5 : TextView
    lateinit var tvSerResponse6 : TextView
    lateinit var tvSerResponse7 : TextView
    lateinit var tvSerResponse8 : TextView
    lateinit var tvSerResponse9 : TextView
    lateinit var tvSerResponse10 : TextView
    lateinit var tvSerResponse11 : TextView

    lateinit var ivSerResponse : ImageView
    private val serImg = "https://i.annihil.us/u/prod/marvel/i/mg/4/b0/5d939e25a9787/portrait_uncanny.jpg"
    lateinit var ivSerResponse2 : ImageView
    private val serImg2 = "https://i.annihil.us/u/prod/marvel/i/mg/1/00/51644d6b47668/portrait_uncanny.jpg"
    lateinit var ivSerResponse3 : ImageView
    private val serImg3 = "https://i.annihil.us/u/prod/marvel/i/mg/9/d0/51926fde9c18a/portrait_uncanny.jpg"
    lateinit var ivSerResponse4 : ImageView
    private val serImg4 = "https://i.annihil.us/u/prod/marvel/i/mg/6/60/553a60a66f2f6/portrait_uncanny.jpg"
    lateinit var ivSerResponse5 : ImageView
    private val serImg5 = "https://i.annihil.us/u/prod/marvel/i/mg/9/40/553a60e7ab48d/portrait_uncanny.jpg"
    lateinit var ivSerResponse6 : ImageView
    private val serImg6 = "https://i.annihil.us/u/prod/marvel/i/mg/a/d0/4bb4eafadecaf/portrait_uncanny.jpg"
    lateinit var ivSerResponse7 : ImageView
    private val serImg7 = "https://i.annihil.us/u/prod/marvel/i/mg/a/90/5f5fc799434fe/portrait_uncanny.jpg"
    lateinit var ivSerResponse8 : ImageView
    private val serImg8 = "https://i.annihil.us/u/prod/marvel/i/mg/d/30/5f5fc6f0df496/portrait_uncanny.jpg"
    lateinit var ivSerResponse9 : ImageView
    private val serImg9 = "https://i.annihil.us/u/prod/marvel/i/mg/9/20/5f4037d30efa5/portrait_uncanny.jpg"
    lateinit var ivSerResponse10 : ImageView
    private val serImg10 = "https://i.annihil.us/u/prod/marvel/i/mg/5/70/5f5bef0fafd3e/portrait_uncanny.jpg"
    lateinit var ivSerResponse11 : ImageView
    private val serImg11 = "https://i.annihil.us/u/prod/marvel/i/mg/1/40/5e558a8495066/portrait_uncanny.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series)

        ivIntentBackSeries = findViewById(R.id.btnBackSeries)
        ivIntentBackSeries.setOnClickListener(this)

        tvSerResponse = findViewById(R.id.tvSerie1)
        tvSerResponse2 = findViewById(R.id.tvSerie2)
        tvSerResponse3 = findViewById(R.id.tvSerie3)
        tvSerResponse4 = findViewById(R.id.tvSerie4)
        tvSerResponse5 = findViewById(R.id.tvSerie5)
        tvSerResponse6 = findViewById(R.id.tvSerie6)
        tvSerResponse7 = findViewById(R.id.tvSerie7)
        tvSerResponse8 = findViewById(R.id.tvSerie8)
        tvSerResponse9 = findViewById(R.id.tvSerie9)
        tvSerResponse10 = findViewById(R.id.tvSerie10)
        tvSerResponse11 = findViewById(R.id.tvSerie11)

        ivSerResponse = findViewById(R.id.ivSerie1)
        ivSerResponse2 = findViewById(R.id.ivSerie2)
        ivSerResponse3 = findViewById(R.id.ivSerie3)
        ivSerResponse4 = findViewById(R.id.ivSerie4)
        ivSerResponse5 = findViewById(R.id.ivSerie5)
        ivSerResponse6 = findViewById(R.id.ivSerie6)
        ivSerResponse7 = findViewById(R.id.ivSerie7)
        ivSerResponse8 = findViewById(R.id.ivSerie8)
        ivSerResponse9 = findViewById(R.id.ivSerie9)
        ivSerResponse10 = findViewById(R.id.ivSerie10)
        ivSerResponse11 = findViewById(R.id.ivSerie11)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(SeriesAPI::class.java)

        getSeries()

        // Glide
        Glide.with(this)
            .load(serImg)
            .fitCenter()
            .into(ivSerResponse)

        Glide.with(this)
            .load(serImg2)
            .fitCenter()
            .into(ivSerResponse2)

        Glide.with(this)
            .load(serImg3)
            .fitCenter()
            .into(ivSerResponse3)

        Glide.with(this)
            .load(serImg4)
            .fitCenter()
            .into(ivSerResponse4)

        Glide.with(this)
            .load(serImg5)
            .fitCenter()
            .into(ivSerResponse5)

        Glide.with(this)
            .load(serImg6)
            .fitCenter()
            .into(ivSerResponse6)

        Glide.with(this)
            .load(serImg7)
            .fitCenter()
            .into(ivSerResponse7)

        Glide.with(this)
            .load(serImg8)
            .fitCenter()
            .into(ivSerResponse8)

        Glide.with(this)
            .load(serImg9)
            .fitCenter()
            .into(ivSerResponse9)

        Glide.with(this)
            .load(serImg10)
            .fitCenter()
            .into(ivSerResponse10)

        Glide.with(this)
            .load(serImg11)
            .fitCenter()
            .into(ivSerResponse11)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackSeries -> {
                val intentBackSeries = Intent(this@SeriesActivity, MainActivity::class.java)
                startActivity(intentBackSeries)
            }
        }
    }

    fun getSeries() {
        val call: Call<Series> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Series> {
            override fun onResponse(call: Call<Series>, response: Response<Series>) {
                if (response.body() != null) {
                    tvSerResponse.text = response.body()!!.data.results[2].title
                    tvSerResponse2.text = response.body()!!.data.results[3].title
                    tvSerResponse3.text = response.body()!!.data.results[5].title
                    tvSerResponse4.text = response.body()!!.data.results[7].title
                    tvSerResponse5.text = response.body()!!.data.results[8].title
                    tvSerResponse6.text = response.body()!!.data.results[9].title
                    tvSerResponse7.text = response.body()!!.data.results[11].title
                    tvSerResponse8.text = response.body()!!.data.results[14].title
                    tvSerResponse9.text = response.body()!!.data.results[15].title
                    tvSerResponse10.text = response.body()!!.data.results[16].title
                    tvSerResponse11.text = response.body()!!.data.results[17].title
                }
            }

            override fun onFailure(call: Call<Series>, t: Throwable) {
                tvSerResponse.setText("Error occured: " + t)
            }

        })
    }
}