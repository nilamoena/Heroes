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

class Event12 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : EventsAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivEvResponseDet12 : ImageView
    private val evImgDet12 = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5109a1f93b543/standard_fantastic.jpg"
    lateinit var tvEvResponseEvName12 : TextView
    lateinit var tvEvResponseEvDesc12 : TextView
    lateinit var tvEvResponseAttribution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event12)

        ivIntentBackDetail = findViewById(R.id.btnBackEvDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivEvResponseDet12 = findViewById(R.id.ivEvDet12)
        tvEvResponseEvName12 = findViewById(R.id.tvEvName12)
        tvEvResponseEvDesc12 = findViewById(R.id.tvEvDesc12)
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
            .load(evImgDet12)
            .fitCenter()
            .into(ivEvResponseDet12)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackEvDetail -> {
                val intentBackDetail = Intent(this@Event12, EventsActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getEv() {
        val call: Call<Events> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                if (response.body() != null) {
                    tvEvResponseEvName12.text = response.body()!!.data.results[11].title
                    tvEvResponseEvDesc12.text = response.body()!!.data.results[11].description
                    tvEvResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                tvEvResponseEvName12.setText("Error occured: " + t)
            }

        })
    }
}