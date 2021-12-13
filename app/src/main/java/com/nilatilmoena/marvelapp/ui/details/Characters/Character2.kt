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

class Character2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : CharactersAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivCharResponseDet2 : ImageView
    private val charImgDet2 = "https://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec/landscape_incredible.jpg"
    lateinit var tvCharResponseCharName2 : TextView
    lateinit var tvCharResponseCharDesc2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character2)

        ivIntentBackDetail = findViewById(R.id.btnBackCharDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivCharResponseDet2 = findViewById(R.id.ivCharDet2)
        tvCharResponseCharName2 = findViewById(R.id.tvCharName2)
        tvCharResponseCharDesc2 = findViewById(R.id.tvCharDesc2)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(CharactersAPI::class.java)

        getChar()

        // Glide
        Glide.with(this)
            .load(charImgDet2)
            .fitCenter()
            .into(ivCharResponseDet2)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackCharDetail -> {
                val intentBackDetail = Intent(this@Character2, CharactersActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getChar() {
        val call: Call<Characters> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.body() != null) {
                    tvCharResponseCharName2.text = response.body()!!.data.results[2].name
                    tvCharResponseCharDesc2.text = response.body()!!.data.results[2].description
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                tvCharResponseCharName2.setText("Error occured: " + t)
            }

        })
    }
}