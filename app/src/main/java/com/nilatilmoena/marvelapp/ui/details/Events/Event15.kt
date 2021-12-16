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

class Event15 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : EventsAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivEvResponseDet15 : ImageView
    private val evImgDet15 = "https://i.annihil.us/u/prod/marvel/i/mg/f/20/5109a003a9112/standard_fantastic.jpg"
    lateinit var tvEvResponseEvName15 : TextView
    lateinit var tvEvResponseEvDesc15 : TextView
    lateinit var tvEvResponseAttribution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event15)

        ivIntentBackDetail = findViewById(R.id.btnBackEvDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivEvResponseDet15 = findViewById(R.id.ivEvDet15)
        tvEvResponseEvName15 = findViewById(R.id.tvEvName15)
        tvEvResponseEvDesc15 = findViewById(R.id.tvEvDesc15)
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
            .load(evImgDet15)
            .fitCenter()
            .into(ivEvResponseDet15)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackEvDetail -> {
                val intentBackDetail = Intent(this@Event15, EventsActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getEv() {
        val call: Call<Events> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                if (response.body() != null) {
                    tvEvResponseEvName15.text = response.body()!!.data.results[14].title
                    tvEvResponseEvDesc15.text = response.body()!!.data.results[14].description
                    tvEvResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                tvEvResponseEvName15.setText("Error occured: " + t)
            }

        })
    }
}