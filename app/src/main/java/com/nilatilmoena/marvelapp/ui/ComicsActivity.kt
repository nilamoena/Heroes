package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.nilatilmoena.marvelapp.R

class ComicsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ivIntentBackComic : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)

        ivIntentBackComic = findViewById(R.id.btnBackComic)
        ivIntentBackComic.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackComic -> {
                val intentBackComic = Intent(this@ComicsActivity, MainActivity::class.java)
                startActivity(intentBackComic)
            }
        }
    }
}