package com.caseapp.ui.activities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.caseapp.R
import kotlinx.android.synthetic.main.activity_webview.swipe

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView // Initialize WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        // Start - Assign Open New URL
        val wBS = intent
        val webSite = wBS.getStringExtra("btnURLMainTabFragment1")

        // End - Assign Open New URL

        // Start - full screen
        val window = window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) // End - full screen

        // Start - WebView
        webView = findViewById(R.id.wv)
        webView.setWebViewClient(object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view?.visibility = View.INVISIBLE

                if (Build.VERSION.SDK_INT >= 19) {
                    webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                } else {
                    webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                swipe?.isRefreshing = false
                super.onPageFinished(view, url)
                view?.visibility = View.VISIBLE
            }

            // Start - Fix Whatsapp Acces
            override fun shouldOverrideUrlLoading(wv: WebView, url: String): Boolean {
                if (url.startsWith("tel:") || url.startsWith("whatsapp:")) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                    webView.goBack()
                    return true
                }
                return false
            } // End - Fix Whatsapp Acces

        }) // End - WebView

        refreshApp() // SetUp SwipeRefresh

        // Start - WebView Setting
        if (webSite != null) {
            webView.loadUrl(webSite)
        }

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true // js active
        webSettings.domStorageEnabled = true // componenet load
        webSettings.allowContentAccess = true
        webSettings.loadsImagesAutomatically = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webSettings.setEnableSmoothTransition(true)
        // End - WebView Setting

    }// End -OnCreate

    // Start - BackPressed CurrentView
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else
            super.onBackPressed()
    } // End - BackPressed CurrentView

    // Start - SwipeRefresh
    private fun refreshApp() {
        swipe.setOnRefreshListener {
            webView?.reload()
            Toast.makeText(this, "Refresh!", Toast.LENGTH_SHORT).show()
        }
    } // End- SwipeRefresh


} // finish MainActivity