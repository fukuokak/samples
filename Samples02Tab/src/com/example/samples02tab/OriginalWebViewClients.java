package com.example.samples02tab;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OriginalWebViewClients extends WebViewClient {


	 @Override
     public boolean shouldOverrideUrlLoading(WebView view, String url) {
       // �O���u���E�U�łȂ������u���E�U�𗘗p
       return false;
     }
     // �G���[���ɌĂ΂��
     @Override
     public void onReceivedError(WebView view, int errorCode,
         String description, String failingUrl) {
     }


}
