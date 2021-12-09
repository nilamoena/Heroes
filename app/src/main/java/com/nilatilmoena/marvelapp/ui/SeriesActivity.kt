package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.nilatilmoena.marvelapp.R

class SeriesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackSeries : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series)

        ivIntentBackSeries = findViewById(R.id.btnBackSeries)
        ivIntentBackSeries.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackSeries -> {
                val intentBackSeries = Intent(this@SeriesActivity, MainActivity::class.java)
                startActivity(intentBackSeries)
            }
        }
    }
}