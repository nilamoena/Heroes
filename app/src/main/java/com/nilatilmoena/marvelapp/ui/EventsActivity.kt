package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.nilatilmoena.marvelapp.R

class EventsActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var ivIntentBackEvent : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        ivIntentBackEvent = findViewById(R.id.btnBackEvent)
        ivIntentBackEvent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackEvent -> {
                val intentBackEvent = Intent(this@EventsActivity, MainActivity::class.java)
                startActivity(intentBackEvent)
            }
        }
    }
}