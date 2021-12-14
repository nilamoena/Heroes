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

class InfoActivity : AppCompatActivity(), View.OnClickListener {

    // Back Button
    private lateinit var ivIntentBackInfo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        // Back Button
        ivIntentBackInfo = findViewById(R.id.btnBackInfo)
        ivIntentBackInfo.setOnClickListener(this)

        // WebView
        val mWebView = findViewById<View>(R.id.wvInfo) as WebView
        mWebView.loadUrl("https://www.marvel.com/")

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
            R.id.btnBackInfo -> {
                val intentBackInfo = Intent(this@InfoActivity, MainActivity::class.java)
                startActivity(intentBackInfo)
            }
        }
    }
}