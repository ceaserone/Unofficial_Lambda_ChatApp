package com.synackdevnet.webcheck;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        // Debugging (chrome://inspect)
        WebView.setWebContentsDebuggingEnabled(true);

        // Settings
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);     // critical for SPAs
        s.setDatabaseEnabled(true);
        s.setLoadsImagesAutomatically(true);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        // Cookies
        android.webkit.CookieManager cm = android.webkit.CookieManager.getInstance();
        cm.setAcceptCookie(true);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            cm.setAcceptThirdPartyCookies(webView, true);
        }

        // Handle errors / keep links in-app / (debug) SSL proceed
        webView.setWebViewClient(new WebViewClient() {
            @Override public void onPageFinished(WebView v, String url) {
                super.onPageFinished(v, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView v, String url) {
                // keep http/https inside the WebView
                return !(url.startsWith("http://") || url.startsWith("https://"));
            }

            @Override
            public void onReceivedSslError(WebView v,
                                           android.webkit.SslErrorHandler handler,
                                           android.net.http.SslError error) {
                // DEBUG ONLY — ignore cert issues (remove for production)
                handler.proceed();
            }

            @Override
            public void onReceivedError(WebView v, int code, String desc, String failingUrl) {
                v.loadData(
                    "<html><body style='background:#000;color:#fff;font:14px monospace'>"
                    + "Error " + code + ": " + desc + "<br/>" + failingUrl
                    + "</body></html>", "text/html", "UTF-8");
            }
        });

        webView.loadUrl("https://lambda.chat");
    }
}
