package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.nilatilmoena.marvelapp.R
import com.nilatilmoena.marvelapp.api.EventsAPI
import com.nilatilmoena.marvelapp.models.events.Events
import com.nilatilmoena.marvelapp.ui.details.Events.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsActivity : AppCompatActivity(), View.OnClickListener  {

    lateinit var MarvelAPI : EventsAPI
    private var BASE_URL = "https://gateway.marvel.com/"

    // Back Button
    private lateinit var ivIntentBackEvent : ImageView

    // Inisialisasi CardView
    private lateinit var cardVeng : CardView
    private lateinit var cardApo : CardView
    private lateinit var cardUlt : CardView
    private lateinit var cardX : CardView
    private lateinit var cardDiff : CardView

    // Inisialisasi TextView
    lateinit var tvEvResponse : TextView
    lateinit var tvEvResponse2 : TextView
    lateinit var tvEvResponse3 : TextView
    lateinit var tvEvResponse4 : TextView
    lateinit var tvEvResponse5 : TextView
    lateinit var tvEvResponse6 : TextView
    lateinit var tvEvResponse7 : TextView
    lateinit var tvEvResponse8 : TextView
    lateinit var tvEvResponse9 : TextView
    lateinit var tvEvResponse10 : TextView
    lateinit var tvEvResponse11 : TextView
    lateinit var tvEvResponse12 : TextView
    lateinit var tvEvResponse13 : TextView
    lateinit var tvEvResponse14 : TextView
    lateinit var tvEvResponse15 : TextView
    lateinit var tvEvResponse16 : TextView
    lateinit var tvEvResponse17 : TextView
    lateinit var tvEvResponse18 : TextView
    lateinit var tvEvResponse19 : TextView
    lateinit var tvEvResponse20 : TextView
    lateinit var tvEvResponseAttribution : TextView

    // Inisialisasi ImageView
    lateinit var ivEvResponse : ImageView
    private val evImg = "https://i.annihil.us/u/prod/marvel/i/mg/9/40/51ca10d996b8b/standard_amazing.jpg"
    lateinit var ivEvResponse2 : ImageView
    private val evImg2 = "https://i.annihil.us/u/prod/marvel/i/mg/5/e0/51ca0e08a6546/standard_amazing.jpg"
    lateinit var ivEvResponse3 : ImageView
    private val evImg3 = "https://i.annihil.us/u/prod/marvel/i/mg/c/10/51ca0fc4c83c8/standard_amazing.jpg"
    lateinit var ivEvResponse4 : ImageView
    private val evImg4 = "https://i.annihil.us/u/prod/marvel/i/mg/5/40/51ca12a34615b/standard_amazing.jpg"
    lateinit var ivEvResponse5 : ImageView
    private val evImg5 = "https://i.annihil.us/u/prod/marvel/i/mg/b/f0/55bfa91b34ac4/standard_amazing.jpg"
    lateinit var ivEvResponse6 : ImageView
    private val evImg6 = "https://i.annihil.us/u/prod/marvel/i/mg/c/80/51c9ec5e90de1/standard_amazing.jpg"
    lateinit var ivEvResponse7 : ImageView
    private val evImg7 = "https://i.annihil.us/u/prod/marvel/i/mg/8/f0/51c9ed1304bb7/standard_amazing.jpg"
    lateinit var ivEvResponse8 : ImageView
    private val evImg8 = "https://i.annihil.us/u/prod/marvel/i/mg/8/d0/51ca13895b3ab/standard_amazing.jpg"
    lateinit var ivEvResponse9 : ImageView
    private val evImg9 = "https://i.annihil.us/u/prod/marvel/i/mg/9/60/51c9d7f42a0c8/standard_amazing.jpg"
    lateinit var ivEvResponse10 : ImageView
    private val evImg10 = "https://i.annihil.us/u/prod/marvel/i/mg/1/03/52127e32d3671/standard_amazing.jpg"
    lateinit var ivEvResponse11 : ImageView
    private val evImg11 = "https://i.annihil.us/u/prod/marvel/i/mg/5/c0/53fe0732c1f02/standard_amazing.jpg"
    lateinit var ivEvResponse12 : ImageView
    private val evImg12 = "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5109a1f93b543/standard_amazing.jpg"
    lateinit var ivEvResponse13 : ImageView
    private val evImg13 = "https://i.annihil.us/u/prod/marvel/i/mg/9/d0/53f77ba25db97/standard_amazing.jpg"
    lateinit var ivEvResponse14 : ImageView
    private val evImg14 = "https://i.annihil.us/u/prod/marvel/i/mg/3/d0/51c9e9945b152/standard_amazing.jpg"
    lateinit var ivEvResponse15 : ImageView
    private val evImg15 = "https://i.annihil.us/u/prod/marvel/i/mg/f/20/5109a003a9112/standard_amazing.jpg"
    lateinit var ivEvResponse16 : ImageView
    private val evImg16 = "https://i.annihil.us/u/prod/marvel/i/mg/2/d0/51cb5356c2063/standard_amazing.jpg"
    lateinit var ivEvResponse17 : ImageView
    private val evImg17 = "https://i.annihil.us/u/prod/marvel/i/mg/3/c0/56d082ff38722/standard_amazing.jpg"
    lateinit var ivEvResponse18 : ImageView
    private val evImg18 = "https://i.annihil.us/u/prod/marvel/i/mg/5/60/51cb2d77a0410/standard_amazing.jpg"
    lateinit var ivEvResponse19 : ImageView
    private val evImg19 = "https://i.annihil.us/u/prod/marvel/i/mg/c/60/528cf4ac6c15f/standard_amazing.jpg"
    lateinit var ivEvResponse20 : ImageView
    private val evImg20 = "https://i.annihil.us/u/prod/marvel/i/mg/6/00/51cb2ea890038/standard_amazing.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        // Back Button
        ivIntentBackEvent = findViewById(R.id.btnBackEvent)
        ivIntentBackEvent.setOnClickListener(this)

        // CardView
        cardVeng = findViewById(R.id.cvEvent1)
        cardVeng.setOnClickListener(this)

        cardApo = findViewById(R.id.cvEvent2)
        cardApo.setOnClickListener(this)

        cardUlt = findViewById(R.id.cvEvent3)
        cardUlt.setOnClickListener(this)

        cardX = findViewById(R.id.cvEvent4)
        cardX.setOnClickListener(this)

        cardDiff = findViewById(R.id.cvEvent5)
        cardDiff.setOnClickListener(this)

        // TextView
        tvEvResponse = findViewById(R.id.tvEvent1)
        tvEvResponse2 = findViewById(R.id.tvEvent2)
        tvEvResponse3 = findViewById(R.id.tvEvent3)
        tvEvResponse4 = findViewById(R.id.tvEvent4)
        tvEvResponse5 = findViewById(R.id.tvEvent5)
        tvEvResponse6 = findViewById(R.id.tvEvent6)
        tvEvResponse7 = findViewById(R.id.tvEvent7)
        tvEvResponse8 = findViewById(R.id.tvEvent8)
        tvEvResponse9 = findViewById(R.id.tvEvent9)
        tvEvResponse10 = findViewById(R.id.tvEvent10)
        tvEvResponse11 = findViewById(R.id.tvEvent11)
        tvEvResponse12 = findViewById(R.id.tvEvent12)
        tvEvResponse13 = findViewById(R.id.tvEvent13)
        tvEvResponse14 = findViewById(R.id.tvEvent14)
        tvEvResponse15 = findViewById(R.id.tvEvent15)
        tvEvResponse16 = findViewById(R.id.tvEvent16)
        tvEvResponse17 = findViewById(R.id.tvEvent17)
        tvEvResponse18 = findViewById(R.id.tvEvent18)
        tvEvResponse19 = findViewById(R.id.tvEvent19)
        tvEvResponse20 = findViewById(R.id.tvEvent20)
        tvEvResponseAttribution = findViewById(R.id.tvAttribution)

        // ImageView
        ivEvResponse = findViewById(R.id.ivEvent1)
        ivEvResponse2 = findViewById(R.id.ivEvent2)
        ivEvResponse3 = findViewById(R.id.ivEvent3)
        ivEvResponse4 = findViewById(R.id.ivEvent4)
        ivEvResponse5 = findViewById(R.id.ivEvent5)
        ivEvResponse6 = findViewById(R.id.ivEvent6)
        ivEvResponse7 = findViewById(R.id.ivEvent7)
        ivEvResponse8 = findViewById(R.id.ivEvent8)
        ivEvResponse9 = findViewById(R.id.ivEvent9)
        ivEvResponse10 = findViewById(R.id.ivEvent10)
        ivEvResponse11 = findViewById(R.id.ivEvent11)
        ivEvResponse12 = findViewById(R.id.ivEvent12)
        ivEvResponse13 = findViewById(R.id.ivEvent13)
        ivEvResponse14 = findViewById(R.id.ivEvent14)
        ivEvResponse15 = findViewById(R.id.ivEvent15)
        ivEvResponse16 = findViewById(R.id.ivEvent16)
        ivEvResponse17 = findViewById(R.id.ivEvent17)
        ivEvResponse18 = findViewById(R.id.ivEvent18)
        ivEvResponse19 = findViewById(R.id.ivEvent19)
        ivEvResponse20 = findViewById(R.id.ivEvent20)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        MarvelAPI = retrofit.create(EventsAPI::class.java)

        getEvents()

        // Glide
        Glide.with(this)
            .load(evImg)
            .fitCenter()
            .into(ivEvResponse)

        Glide.with(this)
            .load(evImg2)
            .fitCenter()
            .into(ivEvResponse2)

        Glide.with(this)
            .load(evImg3)
            .fitCenter()
            .into(ivEvResponse3)

        Glide.with(this)
            .load(evImg4)
            .fitCenter()
            .into(ivEvResponse4)

        Glide.with(this)
            .load(evImg5)
            .fitCenter()
            .into(ivEvResponse5)

        Glide.with(this)
            .load(evImg6)
            .fitCenter()
            .into(ivEvResponse6)

        Glide.with(this)
            .load(evImg7)
            .fitCenter()
            .into(ivEvResponse7)

        Glide.with(this)
            .load(evImg8)
            .fitCenter()
            .into(ivEvResponse8)

        Glide.with(this)
            .load(evImg9)
            .fitCenter()
            .into(ivEvResponse9)

        Glide.with(this)
            .load(evImg10)
            .fitCenter()
            .into(ivEvResponse10)

        Glide.with(this)
            .load(evImg11)
            .fitCenter()
            .into(ivEvResponse11)

        Glide.with(this)
            .load(evImg12)
            .fitCenter()
            .into(ivEvResponse12)

        Glide.with(this)
            .load(evImg13)
            .fitCenter()
            .into(ivEvResponse13)

        Glide.with(this)
            .load(evImg14)
            .fitCenter()
            .into(ivEvResponse14)

        Glide.with(this)
            .load(evImg15)
            .fitCenter()
            .into(ivEvResponse15)

        Glide.with(this)
            .load(evImg16)
            .fitCenter()
            .into(ivEvResponse16)

        Glide.with(this)
            .load(evImg17)
            .fitCenter()
            .into(ivEvResponse17)

        Glide.with(this)
            .load(evImg18)
            .fitCenter()
            .into(ivEvResponse18)

        Glide.with(this)
            .load(evImg19)
            .fitCenter()
            .into(ivEvResponse19)

        Glide.with(this)
            .load(evImg20)
            .fitCenter()
            .into(ivEvResponse20)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackEvent -> {
                val intentBackEvent = Intent(this@EventsActivity, MainActivity::class.java)
                startActivity(intentBackEvent)
            }
            R.id.cvEvent1 -> {
                val intentCardVeng = Intent(this@EventsActivity, Event1::class.java)
                startActivity(intentCardVeng)
            }
            R.id.cvEvent2 -> {
                val intentCardAvo = Intent(this@EventsActivity, Event2::class.java)
                startActivity(intentCardAvo)
            }
            R.id.cvEvent3 -> {
                val intentCardUlt = Intent(this@EventsActivity, Event3::class.java)
                startActivity(intentCardUlt)
            }
            R.id.cvEvent4 -> {
                val intentCardX = Intent(this@EventsActivity, Event4::class.java)
                startActivity(intentCardX)
            }
            R.id.cvEvent5 -> {
                val intentCardDiff = Intent(this@EventsActivity, Event5::class.java)
                startActivity(intentCardDiff)
            }
        }
    }

    fun getEvents() {
        val call: Call<Events> = MarvelAPI.getResponse()

        call.enqueue(object: Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                if (response.body() != null) {
                    tvEvResponse.text = response.body()!!.data.results[0].title
                    tvEvResponse2.text = response.body()!!.data.results[1].title
                    tvEvResponse3.text = response.body()!!.data.results[2].title
                    tvEvResponse4.text = response.body()!!.data.results[3].title
                    tvEvResponse5.text = response.body()!!.data.results[4].title
                    tvEvResponse6.text = response.body()!!.data.results[5].title
                    tvEvResponse7.text = response.body()!!.data.results[6].title
                    tvEvResponse8.text = response.body()!!.data.results[7].title
                    tvEvResponse9.text = response.body()!!.data.results[8].title
                    tvEvResponse10.text = response.body()!!.data.results[9].title
                    tvEvResponse11.text = response.body()!!.data.results[10].title
                    tvEvResponse12.text = response.body()!!.data.results[11].title
                    tvEvResponse13.text = response.body()!!.data.results[12].title
                    tvEvResponse14.text = response.body()!!.data.results[13].title
                    tvEvResponse15.text = response.body()!!.data.results[14].title
                    tvEvResponse16.text = response.body()!!.data.results[15].title
                    tvEvResponse17.text = response.body()!!.data.results[16].title
                    tvEvResponse18.text = response.body()!!.data.results[17].title
                    tvEvResponse19.text = response.body()!!.data.results[18].title
                    tvEvResponse20.text = response.body()!!.data.results[19].title
                    tvEvResponseAttribution.text = response.body()!!.attributionText
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                tvEvResponse.setText("Error occured: " + t)
            }

        })
    }
}