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

class Character1 : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackDetail : ImageView

    lateinit var MarvelAPI : CharactersAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var ivCharResponseDet1 : ImageView
    private val charImgDet1 = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16/landscape_incredible.jpg"
    lateinit var tvCharResponseCharName1 : TextView
    lateinit var tvCharResponseCharDesc1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character1)

        ivIntentBackDetail = findViewById(R.id.btnBackCharDetail)
        ivIntentBackDetail.setOnClickListener(this)

        ivCharResponseDet1 = findViewById(R.id.ivCharDet1)
        tvCharResponseCharName1 = findViewById(R.id.tvCharName1)
        tvCharResponseCharDesc1 = findViewById(R.id.tvCharDesc1)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(CharactersAPI::class.java)

        getChar()

        // Glide
        Glide.with(this)
            .load(charImgDet1)
            .fitCenter()
            .into(ivCharResponseDet1)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackCharDetail -> {
                val intentBackDetail = Intent(this@Character1, CharactersActivity::class.java)
                startActivity(intentBackDetail)
            }
        }
    }

    fun getChar() {
        val call: Call<Characters> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.body() != null) {
                    tvCharResponseCharName1.text = response.body()!!.data.results[1].name
                    tvCharResponseCharDesc1.text = response.body()!!.data.results[1].description
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                tvCharResponseCharName1.setText("Error occured: " + t)
            }

        })
    }
}