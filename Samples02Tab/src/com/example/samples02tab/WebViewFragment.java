package com.example.samples02tab;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sample02tab.R;

@SuppressLint("NewApi")
public class WebViewFragment extends Fragment implements OnClickListener{


	private WebView web;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		String uri = this.getArguments().getString("URI");

		Log.v(this.getClass().getName(),"Open "+ uri);

		View v = inflater.inflate(R.layout.webview_fragment, container,false);

		v.setDrawingCacheEnabled(Boolean.TRUE);
		web = (WebView)v.findViewById(R.id.webView1);

		OriginalWebSettings ows = new OriginalWebSettings(web);
		web = ows.getSettedWebView();
		web.setWebViewClient(new OriginalWebViewClients());


		ImageButton iBack = (ImageButton)v.findViewById(R.id.iBackButton);
		ImageButton iForward = (ImageButton)v.findViewById(R.id.iForwardButton);
		iBack.setOnClickListener(this);
		iForward.setOnClickListener(this);

		web.loadUrl(uri);
		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iBackButton:
			historyBack(web);
			break;
		case R.id.iForwardButton:
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
	public void onSaveInstanceState(Bundle outState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onSaveInstanceState(outState);
		web.saveState(outState);
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		web.clearHistory();
		web.clearCache(Boolean.FALSE);
	}


}
