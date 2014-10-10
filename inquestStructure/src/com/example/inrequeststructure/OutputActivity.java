package com.example.inrequeststructure;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.inrequeststructure.bean.MargineBean;

public class OutputActivity extends Activity {
	private MargineBean mb = new MargineBean();

	public OutputActivity(MargineBean mb) {
		this.mb = mb;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText editText = (EditText) findViewById(R.id.editText1);
		editText.setText(mb.getEditText().toString());

	}
}
