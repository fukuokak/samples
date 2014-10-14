package com.example.inrequeststructure;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inrequeststructure.bean.MargineBean;
import com.example.inrequeststructure.listener.InputButtonListener;

public class InputActivity extends ActionBarActivity {

	private MargineBean mb ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mb = new MargineBean(((EditText)findViewById(R.id.editText1)).toString());

		View button1 = findViewById(R.id.button1);
		button1.setOnClickListener(new InputButtonListener(this , mb));

		ListView lv = (ListView) findViewById(R.id.listView);
		lv.setEmptyView(null);

		Intent recieveIntent = getIntent();
		Boolean returnCode = recieveIntent.getBooleanExtra("ReturnCode", false);
		Toast.makeText(getApplicationContext(), returnCode + " on InputActivity", Toast.LENGTH_SHORT).show();


	}

}
