package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nilatilmoena.marvelapp.R
import com.nilatilmoena.marvelapp.api.ComicsAPI
import com.nilatilmoena.marvelapp.models.comics.Comics
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComicsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackComic : ImageView

    lateinit var MarvelAPI : ComicsAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var tvComResponse : TextView
    lateinit var tvComResponse2 : TextView
    lateinit var tvComResponse3 : TextView
    lateinit var tvComResponse4 : TextView
    lateinit var tvComResponse5 : TextView
    lateinit var tvComResponse6 : TextView
    lateinit var tvComResponse7 : TextView
    lateinit var tvComResponse8 : TextView
    lateinit var tvComResponse9 : TextView
    lateinit var tvComResponse10 : TextView
    lateinit var tvComResponse11 : TextView
    lateinit var tvComResponse12 : TextView
    lateinit var tvComResponse13 : TextView
    lateinit var tvComResponse14 : TextView
    lateinit var tvComResponse15 : TextView
    lateinit var tvComResponse16 : TextView

    lateinit var ivComResponse : ImageView
    private val comImg = "https://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada/portrait_uncanny.jpg"
    lateinit var ivComResponse2 : ImageView
    private val comImg2 = "https://i.annihil.us/u/prod/marvel/i/mg/9/20/4bc665483c3aa/portrait_uncanny.jpg"
    lateinit var ivComResponse3 : ImageView
    private val comImg3 = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/4bc64df4105b9/portrait_uncanny.jpg"
    lateinit var ivComResponse4 : ImageView
    private val comImg4 = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75/portrait_uncanny.jpg"
    lateinit var ivComResponse5 : ImageView
    private val comImg5 = "https://i.annihil.us/u/prod/marvel/i/mg/4/20/4bc697c680890/portrait_uncanny.jpg"
    lateinit var ivComResponse6 : ImageView
    private val comImg6 = "https://i.annihil.us/u/prod/marvel/i/mg/c/80/4bc5fe7a308d7/portrait_uncanny.jpg"
    lateinit var ivComResponse7 : ImageView
    private val comImg7 = "https://i.annihil.us/u/prod/marvel/i/mg/6/e0/4bc6a2497684e/portrait_uncanny.jpg"
    lateinit var ivComResponse8 : ImageView
    private val comImg8 = "https://i.annihil.us/u/prod/marvel/i/mg/d/70/4bc69c7e9b9d7/portrait_uncanny.jpg"
    lateinit var ivComResponse9 : ImageView
    private val comImg9 = "https://i.annihil.us/u/prod/marvel/i/mg/f/20/4bc63a47b8dcb/portrait_uncanny.jpg"
    lateinit var ivComResponse10 : ImageView
    private val comImg10 = "https://i.annihil.us/u/prod/marvel/i/mg/2/f0/4bc6670c80007/portrait_uncanny.jpg"
    lateinit var ivComResponse11 : ImageView
    private val comImg11 = "https://i.annihil.us/u/prod/marvel/i/mg/f/c0/4bc66d78f1bee/portrait_uncanny.jpg"
    lateinit var ivComResponse12 : ImageView
    private val comImg12 = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75/portrait_uncanny.jpg"
    lateinit var ivComResponse13 : ImageView
    private val comImg13 = "https://i.annihil.us/u/prod/marvel/i/mg/b/40/4bc64020a4ccc/portrait_uncanny.jpg"
    lateinit var ivComResponse14 : ImageView
    private val comImg14 = "https://i.annihil.us/u/prod/marvel/i/mg/9/d0/58b5cfb6d5239/portrait_uncanny.jpg"
    lateinit var ivComResponse15 : ImageView
    private val comImg15 = "https://i.annihil.us/u/prod/marvel/i/mg/c/b0/4bc6494ed6eb4/portrait_uncanny.jpg"
    lateinit var ivComResponse16 : ImageView
    private val comImg16 = "https://i.annihil.us/u/prod/marvel/i/mg/f/20/4bc69f33cafc0/portrait_uncanny.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)

        ivIntentBackComic = findViewById(R.id.btnBackComic)
        ivIntentBackComic.setOnClickListener(this)

        tvComResponse = findViewById(R.id.tvComic1)
        tvComResponse2 = findViewById(R.id.tvComic2)
        tvComResponse3 = findViewById(R.id.tvComic3)
        tvComResponse4 = findViewById(R.id.tvComic4)
        tvComResponse5 = findViewById(R.id.tvComic5)
        tvComResponse6 = findViewById(R.id.tvComic6)
        tvComResponse7 = findViewById(R.id.tvComic7)
        tvComResponse8 = findViewById(R.id.tvComic8)
        tvComResponse9 = findViewById(R.id.tvComic9)
        tvComResponse10 = findViewById(R.id.tvComic10)
        tvComResponse11 = findViewById(R.id.tvComic11)
        tvComResponse12 = findViewById(R.id.tvComic12)
        tvComResponse13 = findViewById(R.id.tvComic13)
        tvComResponse14 = findViewById(R.id.tvComic14)
        tvComResponse15 = findViewById(R.id.tvComic15)
        tvComResponse16 = findViewById(R.id.tvComic16)

        ivComResponse = findViewById(R.id.ivComic1)
        ivComResponse2 = findViewById(R.id.ivComic2)
        ivComResponse3 = findViewById(R.id.ivComic3)
        ivComResponse4 = findViewById(R.id.ivComic4)
        ivComResponse5 = findViewById(R.id.ivComic5)
        ivComResponse6 = findViewById(R.id.ivComic6)
        ivComResponse7 = findViewById(R.id.ivComic7)
        ivComResponse8 = findViewById(R.id.ivComic8)
        ivComResponse9 = findViewById(R.id.ivComic9)
        ivComResponse10 = findViewById(R.id.ivComic10)
        ivComResponse11 = findViewById(R.id.ivComic11)
        ivComResponse12 = findViewById(R.id.ivComic12)
        ivComResponse13 = findViewById(R.id.ivComic13)
        ivComResponse14 = findViewById(R.id.ivComic14)
        ivComResponse15 = findViewById(R.id.ivComic15)
        ivComResponse16 = findViewById(R.id.ivComic16)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(ComicsAPI::class.java)

        getComics()

        // Glide
        Glide.with(this)
            .load(comImg)
            .fitCenter()
            .into(ivComResponse)

        Glide.with(this)
            .load(comImg2)
            .fitCenter()
            .into(ivComResponse2)

        Glide.with(this)
            .load(comImg3)
            .fitCenter()
            .into(ivComResponse3)

        Glide.with(this)
            .load(comImg4)
            .fitCenter()
            .into(ivComResponse4)

        Glide.with(this)
            .load(comImg5)
            .fitCenter()
            .into(ivComResponse5)

        Glide.with(this)
            .load(comImg6)
            .fitCenter()
            .into(ivComResponse6)

        Glide.with(this)
            .load(comImg7)
            .fitCenter()
            .into(ivComResponse7)

        Glide.with(this)
            .load(comImg8)
            .fitCenter()
            .into(ivComResponse8)

        Glide.with(this)
            .load(comImg9)
            .fitCenter()
            .into(ivComResponse9)

        Glide.with(this)
            .load(comImg10)
            .fitCenter()
            .into(ivComResponse10)

        Glide.with(this)
            .load(comImg11)
            .fitCenter()
            .into(ivComResponse11)

        Glide.with(this)
            .load(comImg12)
            .fitCenter()
            .into(ivComResponse12)

        Glide.with(this)
            .load(comImg13)
            .fitCenter()
            .into(ivComResponse13)

        Glide.with(this)
            .load(comImg14)
            .fitCenter()
            .into(ivComResponse14)

        Glide.with(this)
            .load(comImg15)
            .fitCenter()
            .into(ivComResponse15)

        Glide.with(this)
            .load(comImg16)
            .fitCenter()
            .into(ivComResponse16)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackComic -> {
                val intentBackComic = Intent(this@ComicsActivity, MainActivity::class.java)
                startActivity(intentBackComic)
            }
        }
    }

    fun getComics() {
        val call: Call<Comics> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Comics> {
            override fun onResponse(call: Call<Comics>, response: Response<Comics>) {
                if (response.body() != null) {
                    tvComResponse.text = response.body()!!.data.results[2].title
                    tvComResponse2.text = response.body()!!.data.results[3].title
                    tvComResponse3.text = response.body()!!.data.results[4].title
                    tvComResponse4.text = response.body()!!.data.results[5].title
                    tvComResponse5.text = response.body()!!.data.results[6].title
                    tvComResponse6.text = response.body()!!.data.results[7].title
                    tvComResponse7.text = response.body()!!.data.results[8].title
                    tvComResponse8.text = response.body()!!.data.results[9].title
                    tvComResponse9.text = response.body()!!.data.results[10].title
                    tvComResponse10.text = response.body()!!.data.results[11].title
                    tvComResponse11.text = response.body()!!.data.results[13].title
                    tvComResponse12.text = response.body()!!.data.results[14].title
                    tvComResponse13.text = response.body()!!.data.results[15].title
                    tvComResponse14.text = response.body()!!.data.results[17].title
                    tvComResponse15.text = response.body()!!.data.results[18].title
                    tvComResponse16.text = response.body()!!.data.results[19].title
                }
            }

            override fun onFailure(call: Call<Comics>, t: Throwable) {
                tvComResponse.setText("Error occured: " + t)
            }

        })
    }
}