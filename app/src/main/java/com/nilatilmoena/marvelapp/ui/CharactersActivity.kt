package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.nilatilmoena.marvelapp.R

class CharactersActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ibIntentBackChar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        ibIntentBackChar = findViewById(R.id.btnBackChar)
        ibIntentBackChar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackChar -> {
                val intentBackChar = Intent(this@CharactersActivity, MainActivity::class.java)
                startActivity(intentBackChar)
            }
        }
    }

}