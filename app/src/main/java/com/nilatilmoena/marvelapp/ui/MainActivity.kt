package com.nilatilmoena.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nilatilmoena.marvelapp.R
import android.content.Intent
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var cvIntentChar : CardView
    private lateinit var cvIntentComic : CardView
    private lateinit var cvIntentEvent : CardView
    private lateinit var cvIntentSeries : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cvIntentChar = findViewById(R.id.cvCharacters)
        cvIntentChar.setOnClickListener(this)

        cvIntentComic = findViewById(R.id.cvComics)
        cvIntentComic.setOnClickListener(this)

        cvIntentEvent = findViewById(R.id.cvEvents)
        cvIntentEvent.setOnClickListener(this)

        cvIntentSeries = findViewById(R.id.cvSeries)
        cvIntentSeries.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.cvCharacters -> {
                val intentCharacters = Intent(this@MainActivity, CharactersActivity::class.java)
                startActivity(intentCharacters)
            }
            R.id.cvComics -> {
                val intentComics = Intent(this@MainActivity, ComicsActivity::class.java)
                startActivity(intentComics)
            }
            R.id.cvEvents -> {
                val intentEvents = Intent(this@MainActivity, EventsActivity::class.java)
                startActivity(intentEvents)
            }
            R.id.cvSeries -> {
                val intentSeries = Intent(this@MainActivity, SeriesActivity::class.java)
                startActivity(intentSeries)
            }
        }
    }
}