package com.example.inrequeststructure.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.inrequeststructure.InputActivity;
import com.example.inrequeststructure.bean.MargineBean;

public class OutputButtonListener implements OnClickListener {
	private Activity listenActivity;
	private Activity postActivity;
	private View onClickView;
	private MargineBean mb;
	private Intent intent;

	public OutputButtonListener(Activity activity) {
		this.postActivity = activity;
	}

	@Override
	public void onClick(View v) {
		this.onClickView = v;

		// Viewとして入力から与えられた情報をBeanに格納する。
		setOutputInfomationFromInputView();

		// 次のActivityへのIntentを生成
		generateNextIntent();

		//次Activityを開始する
		postActivity.startActivity(intent);

	}

	private void setOutputInfomationFromInputView() {


	}

	private Intent generateNextIntent() {
		this.intent = new Intent();
		intent.setClass(postActivity, InputActivity.class);
		return intent;
	}

}
