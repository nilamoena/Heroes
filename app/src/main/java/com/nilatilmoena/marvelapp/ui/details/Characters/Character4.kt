package com.nilatilmoena.marvelapp.ui.details.Characters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nilatilmoena.marvelapp.R
import com.nilatilmoena.marvelapp.api.CharactersAPI
import com.nilatilmoena.marvelapp.models.characters.Characters
import com.nilatilmoena.marvelapp.ui.CharactersActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Character4 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : CharactersAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivCharResponseDet4 : ImageView
    private val charImgDet4 = "https://i.annihil.us/u/prod/marvel/i/mg/a/f0/5202887448860/landscape_incredible.jpg"
    lateinit var tvCharResponseCharName4 : TextView
    lateinit var tvCharResponseCharDesc4 : TextView
    lateinit var tvCharResponseAttribution : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character4)

        ivIntentBackDetail = findViewById(R.id.btnBackCharDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivCharResponseDet4 = findViewById(R.id.ivCharDet4)
        tvCharResponseCharName4 = findViewById(R.id.tvCharName4)
        tvCharResponseCharDesc4 = findViewById(R.id.tvCharDesc4)
        tvCharResponseAttribution = findViewById(R.id.tvAttribution)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(CharactersAPI::class.java)

        getChar()

        // Glide
        Glide.with(this)
            .load(charImgDet4)
            .fitCenter()
            .into(ivCharResponseDet4)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackCharDetail -> {
                val intentBackDetail = Intent(this@Character4, CharactersActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getChar() {
        val call: Call<Characters> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.body() != null) {
                    tvCharResponseCharName4.text = response.body()!!.data.results[10].name
                    tvCharResponseCharDesc4.text = response.body()!!.data.results[10].description
                    tvCharResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                tvCharResponseCharName4.setText("Error occured: " + t)
            }

        })
    }
}