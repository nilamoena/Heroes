package com.nilatilmoena.marvelapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import com.nilatilmoena.marvelapp.R

class VideosActivity : AppCompatActivity(), View.OnClickListener {

    // Back Button
    private lateinit var ivIntentBackVid : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        // Back Button
        ivIntentBackVid = findViewById(R.id.btnBackVid)
        ivIntentBackVid.setOnClickListener(this)

        // WebView
        val mWebView = findViewById<View>(R.id.wvVideo) as WebView
        mWebView.loadUrl("https://www.youtube.com/c/marvel")

        val webSetting = mWebView.settings
        webSetting.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()

        mWebView.canGoBack()
        mWebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK

                && event.action == MotionEvent.ACTION_UP
                && mWebView.canGoBack()) {
                mWebView.goBack()
                return@OnKeyListener true
            }
            false
        })

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBackVid -> {
                val intentBackVid = Intent(this@VideosActivity, MainActivity::class.java)
                startActivity(intentBackVid)
            }
        }
    }
}