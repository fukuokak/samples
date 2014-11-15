package com.example.samples02tab;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OriginalWebViewClients extends WebViewClient {


	 @Override
     public boolean shouldOverrideUrlLoading(WebView view, String url) {
       // 外部ブラウザでなく内部ブラウザを利用
       return false;
     }
     // エラー時に呼ばれる
     @Override
     public void onReceivedError(WebView view, int errorCode,
         String description, String failingUrl) {
     }


}
