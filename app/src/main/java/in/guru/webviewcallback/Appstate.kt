package `in`.guru.webviewcallback

import android.app.Application
import android.webkit.WebView

class Appstate: Application() {

    var chartWebView:WebView?=null


    override fun onCreate() {
        super.onCreate()

        chartWebView = WebView(this)
    }
}