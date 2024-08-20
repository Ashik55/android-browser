package com.news.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.Visibility
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView.OnEditorActionListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var editText: EditText
    private lateinit var loading: ProgressBar


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        webView = findViewById(R.id.webView)
        editText = findViewById(R.id.editText)
        loading = findViewById(R.id.loading)

        // this will enable the javascript.
        webView.getSettings().javaScriptEnabled = true

        editText.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                loading.visibility = View.GONE

                val url = editText.text.toString()
                webView.loadUrl(url)

                return@OnEditorActionListener true
            }
            false
        })




    }

}