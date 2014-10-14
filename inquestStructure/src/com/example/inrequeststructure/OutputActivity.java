package com.example.inrequeststructure;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inrequeststructure.bean.MargineBean;
import com.example.inrequeststructure.listener.OutputButtonListener;

@SuppressLint("ShowToast")
public class OutputActivity extends Activity {
	private MargineBean mb = new MargineBean();

	public OutputActivity() {

	}

	public OutputActivity(MargineBean mb) {
		this.mb = mb;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Intent recieveIntent = getIntent();
		Boolean returnCode = recieveIntent.getBooleanExtra("ReturnCode", false);

		Toast.makeText(this.getApplicationContext(), returnCode
				+ " on OutputActivity", Toast.LENGTH_SHORT).show();

		EditText editText = (EditText) findViewById(R.id.editText1);
		if (returnCode == true) {
			editText.setText("True");
		} else {
			editText.setText("false");
		}

		ListView lv = (ListView) findViewById(R.id.listView);
		String[] members = { "mhidaka", "rongon_xp", "kacchi0516", "kobashinG",
				"seit", "kei_i_t", "furusin_oriver" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, members);
		lv.setAdapter(adapter);


		View toInputButton = findViewById(R.id.button2);
		toInputButton.setOnClickListener(new OutputButtonListener(this));


	}
}
