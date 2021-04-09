package com.example.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // first add internet permission in manifest
        val webview=findViewById<WebView>(R.id.web)
        if(webview!=null){
        val webSettings=webview!!.settings
            webSettings.javaScriptEnabled=true
            webview!!.webViewClient= WebViewClient()
            webview!!.webChromeClient= WebChromeClient()
            webview.loadUrl("www.google.com")
            webview!!.webViewClient=object: WebViewClient(){
                //setting page start and page finish functions
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    val prog=findViewById<ProgressBar>(R.id.progressBar1)
                prog.visibility= View.VISIBLE

                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    val prog=findViewById<ProgressBar>(R.id.progressBar1)
                    prog.visibility= View.GONE
                    super.onPageFinished(view, url)
                }
                }

            }
        }

    override fun onBackPressed() {
        val webview=findViewById<WebView>(R.id.web)
        if (webview!!.canGoBack()){
            webview!!.goBack()
        }else{
            super.onBackPressed()
        }

    }
    }
