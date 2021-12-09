package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nilatilmoena.marvelapp.R
import com.nilatilmoena.marvelapp.api.marvel
import com.nilatilmoena.marvelapp.models.characters.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackChar : ImageView

    lateinit var MarvelAPI : marvel
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

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(marvel::class.java)

        getCharacters()
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
                    var charContent1 = ""
                    charContent1 += response.body()!!.data.results[0].name
                    tvCharResponse.setText((charContent1))
                }
                if (response.body() != null) {
                    var charContent2 = ""
                    charContent2 += response.body()!!.data.results[1].name
                    tvCharResponse2.setText((charContent2))
                }
                if (response.body() != null) {
                    var charContent3 = ""
                    charContent3 += response.body()!!.data.results[2].name
                    tvCharResponse3.setText((charContent3))
                }
                if (response.body() != null) {
                    var charContent4 = ""
                    charContent4 += response.body()!!.data.results[3].name
                    tvCharResponse4.setText((charContent4))
                }
                if (response.body() != null) {
                    var charContent5 = ""
                    charContent5 += response.body()!!.data.results[4].name
                    tvCharResponse5.setText((charContent5))
                }
                if (response.body() != null) {
                    var charContent6 = ""
                    charContent6 += response.body()!!.data.results[5].name
                    tvCharResponse6.setText((charContent6))
                }
                if (response.body() != null) {
                    var charContent7 = ""
                    charContent7 += response.body()!!.data.results[6].name
                    tvCharResponse7.setText((charContent7))
                }
                if (response.body() != null) {
                    var charContent8 = ""
                    charContent8 += response.body()!!.data.results[7].name
                    tvCharResponse8.setText((charContent8))
                }
                if (response.body() != null) {
                    var charContent9 = ""
                    charContent9 += response.body()!!.data.results[8].name
                    tvCharResponse9.setText((charContent9))
                }
                if (response.body() != null) {
                    var charContent10 = ""
                    charContent10 += response.body()!!.data.results[9].name
                    tvCharResponse10.setText((charContent10))
                }
                if (response.body() != null) {
                    var charContent11 = ""
                    charContent11 += response.body()!!.data.results[10].name
                    tvCharResponse11.setText((charContent11))
                }
                if (response.body() != null) {
                    var charContent12 = ""
                    charContent12 += response.body()!!.data.results[11].name
                    tvCharResponse12.setText((charContent12))
                }
                if (response.body() != null) {
                    var charContent13 = ""
                    charContent13 += response.body()!!.data.results[12].name
                    tvCharResponse13.setText((charContent13))
                }
                if (response.body() != null) {
                    var charContent14 = ""
                    charContent14 += response.body()!!.data.results[13].name
                    tvCharResponse14.setText((charContent14))
                }
                if (response.body() != null) {
                    var charContent15 = ""
                    charContent15 += response.body()!!.data.results[14].name
                    tvCharResponse15.setText((charContent15))
                }
                if (response.body() != null) {
                    var charContent16 = ""
                    charContent16 += response.body()!!.data.results[15].name
                    tvCharResponse16.setText((charContent16))
                }
                if (response.body() != null) {
                    var charContent17 = ""
                    charContent17 += response.body()!!.data.results[16].name
                    tvCharResponse17.setText((charContent17))
                }
                if (response.body() != null) {
                    var charContent18 = ""
                    charContent18 += response.body()!!.data.results[17].name
                    tvCharResponse18.setText((charContent18))
                }
                if (response.body() != null) {
                    var charContent19 = ""
                    charContent19 += response.body()!!.data.results[18].name
                    tvCharResponse19.setText((charContent19))
                }
                if (response.body() != null) {
                    var charContent20 = ""
                    charContent20 += response.body()!!.data.results[19].name
                    tvCharResponse20.setText((charContent20))
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                tvCharResponse.setText("Error occured: " + t)
            }

        })
    }

}