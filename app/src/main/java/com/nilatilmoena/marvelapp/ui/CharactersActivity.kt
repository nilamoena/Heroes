package com.nilatilmoena.marvelapp.ui

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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackChar : ImageView

    lateinit var MarvelAPI : CharactersAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    lateinit var tvCharResponse : TextView
    lateinit var tvCharResponse2 : TextView
    lateinit var tvCharResponse3 : TextView
    lateinit var tvCharResponse4 : TextView
    lateinit var tvCharResponse5 : TextView
    lateinit var tvCharResponse6 : TextView
    lateinit var tvCharResponse7 : TextView
    lateinit var tvCharResponse8 : TextView
    lateinit var tvCharResponse9 : TextView
    lateinit var tvCharResponse10 : TextView
    lateinit var tvCharResponse11 : TextView
    lateinit var tvCharResponse12 : TextView
    lateinit var tvCharResponse13 : TextView
    lateinit var tvCharResponse14 : TextView
    lateinit var tvCharResponse15 : TextView
    lateinit var tvCharResponse16 : TextView
    lateinit var tvCharResponse17 : TextView
    lateinit var tvCharResponse18 : TextView
    lateinit var tvCharResponse19 : TextView
    lateinit var tvCharResponse20 : TextView

    lateinit var ivCharResponse : ImageView
    private val charImg = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/standard_medium.jpg"
    lateinit var ivCharResponse2 : ImageView
    private val charImg2 = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16/standard_medium.jpg"
    lateinit var ivCharResponse3 : ImageView
    private val charImg3 = "https://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec/standard_medium.jpg"
    lateinit var ivCharResponse5 : ImageView
    private val charImg5 = "https://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04/standard_medium.jpg"
    lateinit var ivCharResponse7 : ImageView
    private val charImg7 = "https://i.annihil.us/u/prod/marvel/i/mg/1/b0/5269678709fb7/standard_medium.jpg"
    lateinit var ivCharResponse8 : ImageView
    private val charImg8 = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64/standard_medium.jpg"
    lateinit var ivCharResponse9 : ImageView
    private val charImg9 = "https://i.annihil.us/u/prod/marvel/i/mg/3/80/4c00358ec7548/standard_medium.jpg"
    lateinit var ivCharResponse11 : ImageView
    private val charImg11 = "https://i.annihil.us/u/prod/marvel/i/mg/a/f0/5202887448860/standard_medium.jpg"
    lateinit var ivCharResponse12 : ImageView
    private val charImg12 = "https://i.annihil.us/u/prod/marvel/i/mg/5/e0/4c0035c9c425d/standard_medium.gif"
    lateinit var ivCharResponse14 : ImageView
    private val charImg14 = "https://i.annihil.us/u/prod/marvel/i/mg/c/a0/4ce5a9bf70e19/standard_medium.jpg"
    lateinit var ivCharResponse15 : ImageView
    private val charImg15 = "https://i.annihil.us/u/prod/marvel/i/mg/4/60/52695285d6e7e/standard_medium.jpg"
    lateinit var ivCharResponse17 : ImageView
    private val charImg17 = "https://i.annihil.us/u/prod/marvel/i/mg/f/60/4c0042121d790/standard_medium.jpg"
    lateinit var ivCharResponse18 : ImageView
    private val charImg18 = "https://i.annihil.us/u/prod/marvel/i/mg/9/a0/4ce18a834b7f5/standard_medium.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        ivIntentBackChar = findViewById(R.id.btnBackChar)
        ivIntentBackChar.setOnClickListener(this)

        tvCharResponse = findViewById(R.id.tvCharacter1)
        tvCharResponse2 = findViewById(R.id.tvCharacter2)
        tvCharResponse3 = findViewById(R.id.tvCharacter3)
        tvCharResponse4 = findViewById(R.id.tvCharacter4)
        tvCharResponse5 = findViewById(R.id.tvCharacter5)
        tvCharResponse6 = findViewById(R.id.tvCharacter6)
        tvCharResponse7 = findViewById(R.id.tvCharacter7)
        tvCharResponse8 = findViewById(R.id.tvCharacter8)
        tvCharResponse9 = findViewById(R.id.tvCharacter9)
        tvCharResponse10 = findViewById(R.id.tvCharacter10)
        tvCharResponse11 = findViewById(R.id.tvCharacter11)
        tvCharResponse12 = findViewById(R.id.tvCharacter12)
        tvCharResponse13 = findViewById(R.id.tvCharacter13)
        tvCharResponse14 = findViewById(R.id.tvCharacter14)
        tvCharResponse15 = findViewById(R.id.tvCharacter15)
        tvCharResponse16 = findViewById(R.id.tvCharacter16)
        tvCharResponse17 = findViewById(R.id.tvCharacter17)
        tvCharResponse18 = findViewById(R.id.tvCharacter18)
        tvCharResponse19 = findViewById(R.id.tvCharacter19)
        tvCharResponse20 = findViewById(R.id.tvCharacter20)

        ivCharResponse = findViewById(R.id.ivCharacter1)
        ivCharResponse2 = findViewById(R.id.ivCharacter2)
        ivCharResponse3 = findViewById(R.id.ivCharacter3)
        ivCharResponse5 = findViewById(R.id.ivCharacter5)
        ivCharResponse7 = findViewById(R.id.ivCharacter7)
        ivCharResponse8 = findViewById(R.id.ivCharacter8)
        ivCharResponse9 = findViewById(R.id.ivCharacter9)
        ivCharResponse11= findViewById(R.id.ivCharacter11)
        ivCharResponse12 = findViewById(R.id.ivCharacter12)
        ivCharResponse14 = findViewById(R.id.ivCharacter14)
        ivCharResponse15 = findViewById(R.id.ivCharacter15)
        ivCharResponse17 = findViewById(R.id.ivCharacter17)
        ivCharResponse18 = findViewById(R.id.ivCharacter18)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(CharactersAPI::class.java)

        getCharacters()

        // Glide
        Glide.with(this)
            .load(charImg)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse)

        Glide.with(this)
            .load(charImg2)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse2)

        Glide.with(this)
            .load(charImg3)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse3)

        Glide.with(this)
            .load(charImg5)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse5)

        Glide.with(this)
            .load(charImg7)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse7)

        Glide.with(this)
            .load(charImg8)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse8)

        Glide.with(this)
            .load(charImg9)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse9)

        Glide.with(this)
            .load(charImg11)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse11)

        Glide.with(this)
            .load(charImg12)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse12)

        Glide.with(this)
            .load(charImg14)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse14)

        Glide.with(this)
            .load(charImg15)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse15)

        Glide.with(this)
            .load(charImg17)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse17)

        Glide.with(this)
            .load(charImg18)
            .fitCenter()
            .circleCrop()
            .into(ivCharResponse18)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackChar -> {
                val intentBackChar = Intent(this@CharactersActivity, MainActivity::class.java)
                startActivity(intentBackChar)
            }
        }
    }

    fun getCharacters() {
        val call: Call<Characters> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.body() != null) {
                    tvCharResponse.text = response.body()!!.data.results[0].name
                    tvCharResponse2.text = response.body()!!.data.results[1].name
                    tvCharResponse3.text = response.body()!!.data.results[2].name
                    tvCharResponse4.text = response.body()!!.data.results[3].name
                    tvCharResponse5.text = response.body()!!.data.results[4].name
                    tvCharResponse6.text = response.body()!!.data.results[5].name
                    tvCharResponse7.text = response.body()!!.data.results[6].name
                    tvCharResponse8.text = response.body()!!.data.results[7].name
                    tvCharResponse9.text = response.body()!!.data.results[8].name
                    tvCharResponse10.text = response.body()!!.data.results[9].name
                    tvCharResponse11.text = response.body()!!.data.results[10].name
                    tvCharResponse12.text = response.body()!!.data.results[11].name
                    tvCharResponse13.text = response.body()!!.data.results[12].name
                    tvCharResponse14.text = response.body()!!.data.results[13].name
                    tvCharResponse15.text = response.body()!!.data.results[14].name
                    tvCharResponse16.text = response.body()!!.data.results[15].name
                    tvCharResponse17.text = response.body()!!.data.results[16].name
                    tvCharResponse18.text = response.body()!!.data.results[17].name
                    tvCharResponse19.text = response.body()!!.data.results[18].name
                    tvCharResponse20.text = response.body()!!.data.results[19].name
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                tvCharResponse.setText("Error occured: " + t)
            }

        })
    }
}