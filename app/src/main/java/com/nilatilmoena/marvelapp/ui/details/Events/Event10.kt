package com.nilatilmoena.marvelapp.ui.details.Events

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nilatilmoena.marvelapp.R
import com.nilatilmoena.marvelapp.api.EventsAPI
import com.nilatilmoena.marvelapp.models.events.Events
import com.nilatilmoena.marvelapp.ui.EventsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Event10 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : EventsAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivEvResponseDet10 : ImageView
    private val evImgDet10 = "https://i.annihil.us/u/prod/marvel/i/mg/1/03/52127e32d3671/standard_fantastic.jpg"
    lateinit var tvEvResponseEvName10 : TextView
    lateinit var tvEvResponseEvDesc10 : TextView
    lateinit var tvEvResponseAttribution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event10)

        ivIntentBackDetail = findViewById(R.id.btnBackEvDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivEvResponseDet10 = findViewById(R.id.ivEvDet10)
        tvEvResponseEvName10 = findViewById(R.id.tvEvName10)
        tvEvResponseEvDesc10 = findViewById(R.id.tvEvDesc10)
        tvEvResponseAttribution = findViewById(R.id.tvAttribution)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(EventsAPI::class.java)

        getEv()

        // Glide
        Glide.with(this)
            .load(evImgDet10)
            .fitCenter()
            .into(ivEvResponseDet10)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackEvDetail -> {
                val intentBackDetail = Intent(this@Event10, EventsActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getEv() {
        val call: Call<Events> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                if (response.body() != null) {
                    tvEvResponseEvName10.text = response.body()!!.data.results[9].title
                    tvEvResponseEvDesc10.text = response.body()!!.data.results[9].description
                    tvEvResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                tvEvResponseEvName10.setText("Error occured: " + t)
            }

        })
    }
}