package com.example.samples02tab;

import android.webkit.WebSettings;
import android.webkit.WebView;

public class OriginalWebSettings {

	WebView web ;

	public OriginalWebSettings(WebView web){


		WebSettings webSet = web.getSettings();


	    webSet.setCacheMode(WebSettings.LOAD_DEFAULT);
	    webSet.setAppCacheEnabled(true);
		webSet.setAppCacheMaxSize(16 * 1024 * 1024);

		webSet.setDefaultTextEncodingName("UTF-8");
		webSet.setSupportZoom(true);
		webSet.setSaveFormData(false);
		webSet.setSavePassword(false);


		webSet.setJavaScriptEnabled(true);


		this.web = web;
	}

	public WebView getSettedWebView(){
		return this.web;
	}

}
