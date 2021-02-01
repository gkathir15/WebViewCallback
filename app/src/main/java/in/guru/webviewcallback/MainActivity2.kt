package `in`.guru.webviewcallback

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

   private val url ="https://h9ehj.csb.app"
   private val url1 ="https://www.google.com"
   private var webView:WebView?=null
    private var frame:FrameLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        webView = (application as Appstate).chartWebView
        frame = findViewById(R.id.root)

        if (webView?.parent != null) {
            (webView?.parent as ViewGroup).removeView(webView)
        }

        frame?.addView(webView)
        webView?.settings?.also {
            it.allowFileAccess = true
            it.javaScriptEnabled = true
            it.domStorageEnabled = true

            //it.allowContentAccess = true
        }
        webView?.addJavascriptInterface(WebInterface(), "Android")
        webView?.setLayerType(View.LAYER_TYPE_NONE, null)
        WebView.setWebContentsDebuggingEnabled(true)

        webView?.loadUrl(url)



    }

    inner  class WebInterface {



        @JavascriptInterface
        public fun sendAlert(alert: String)
        {
            showAlertBox(alert)
        }

        @JavascriptInterface
        fun a()
        {
            print("method a")
            showAlertBox("fun a called")
        }

        @JavascriptInterface
        fun b()
        {
            print("method b")
           showAlertBox("fun b called")
        }

    }

    fun showAlertBox(message: String)
    {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }
}