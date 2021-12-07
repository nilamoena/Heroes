package com.nilatilmoena.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nilatilmoena.marvelapp.R
import android.content.Intent
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var cvIntentChar : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cvIntentChar = findViewById(R.id.cvCharacters)
        cvIntentChar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.cvCharacters -> {
                val intentCharacters = Intent(this@MainActivity, CharactersActivity::class.java)
                startActivity(intentCharacters)
            }
        }
    }
}