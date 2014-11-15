package com.example.samples02tab;

import com.example.sample02tab.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("NewApi")
public class Fragment2 extends Fragment implements OnClickListener {

	private WebView web ;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(this.getClass().getName(),"StartTab2");


		View v = inflater.inflate(R.layout.fragment1, container,false);
		web = (WebView)v.findViewById(R.id.webView1);

		OriginalWebSettings ows = new OriginalWebSettings(web);
		web = ows.getSettedWebView();
		web.setWebViewClient(new OriginalWebViewClients());

        Button buttonBack = (Button)v.findViewById(R.id.backButton);
        buttonBack.setOnClickListener(this);
        Button buttonForward = (Button)v.findViewById(R.id.forwardButton);
        buttonForward.setOnClickListener(this);



		web.loadUrl("http://news.mobile.yahoo.co.jp/");
		return v;
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backButton:
			historyBack(web);
			break;
		case R.id.forwardButton:
			historyForward(web);
			break;
		default:
			break;
		}
	}


	public void historyBack(WebView web){
		web.goBack();
	}


	public void historyForward(WebView web){
		web.goForward();
	}


	@Override
	public void onDestroy(){
		super.onDestroy();
		web.clearHistory();
		web.clearCache(Boolean.FALSE);
	}
}
