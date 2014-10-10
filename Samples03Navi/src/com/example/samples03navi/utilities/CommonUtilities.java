package com.example.samples03navi.utilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CommonUtilities extends Activity {

	Context context = null;
	Boolean debugFlag = true;

	public CommonUtilities() {
	}

	public CommonUtilities(Context context) {
		this.context = context;
	}

	public void debugToast(String tags, String Message) {
		if (debugFlag == true) {
			Log.d(tags, Message);
			Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
		} else {

		}

	}
}
