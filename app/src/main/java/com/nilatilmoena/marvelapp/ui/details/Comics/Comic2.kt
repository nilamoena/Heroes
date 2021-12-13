package com.nilatilmoena.marvelapp.ui.details.Comics

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
import com.nilatilmoena.marvelapp.ui.ComicsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Comic2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : ComicsAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivComResponseDet2 : ImageView
    private val comImgDet2 = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75/portrait_incredible.jpg"
    lateinit var tvComResponseComName2 : TextView
    lateinit var tvComResponseComDesc2 : TextView
    lateinit var tvComResponseAttribution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic2)

        ivIntentBackDetail = findViewById(R.id.btnBackComDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivComResponseDet2 = findViewById(R.id.ivComDet2)
        tvComResponseComName2 = findViewById(R.id.tvComName2)
        tvComResponseComDesc2 = findViewById(R.id.tvComDesc2)
        tvComResponseAttribution = findViewById(R.id.tvAttribution)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(ComicsAPI::class.java)

        getCom()

        // Glide
        Glide.with(this)
            .load(comImgDet2)
            .fitCenter()
            .into(ivComResponseDet2)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackComDetail -> {
                val intentBackDetail = Intent(this@Comic2, ComicsActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getCom() {
        val call: Call<Comics> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Comics> {
            override fun onResponse(call: Call<Comics>, response: Response<Comics>) {
                if (response.body() != null) {
                    tvComResponseComName2.text = response.body()!!.data.results[14].title
                    tvComResponseComDesc2.text = response.body()!!.data.results[14].description
                    tvComResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Comics>, t: Throwable) {
                tvComResponseComName2.setText("Error occured: " + t)
            }

        })
    }
}