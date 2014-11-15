package com.example.samples02tab;

import android.webkit.WebSettings;
import android.webkit.WebView;

public class OriginalWebSettings {

	WebView web ;

	public OriginalWebSettings(WebView web){

		web.canZoomIn();
		web.canZoomOut();



		WebSettings webSet = web.getSettings();
		webSet.setJavaScriptEnabled(true);
		webSet.setSavePassword(false);
		webSet.setSaveFormData(false);
		webSet.setSupportZoom(false);

		webSet.setAppCacheEnabled(true);
		webSet.setAppCacheMaxSize(8 * 1024 * 1024);

	    webSet.setCacheMode(WebSettings.LOAD_DEFAULT);
		this.web = web;
	}

	public WebView getSettedWebView(){
		return this.web;
	}

}
