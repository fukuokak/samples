package com.example.samples03navi.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.samples03navi.models.WeekDaySchedule;

public class UseFiles {

	private Context context;

	public void UseFile(Context context) {
		this.context = context;

	}

	public void createUtf8File(OutputStream out, String[] text) {
		// 引数：String filename ;
		PrintWriter writer = null;
		try {

			// OutputStream out = openFileOutput(filename,
			// Context.MODE_PRIVATE);

			writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));

			writer.append("hello world0");
			writer.append("\n");

			for (String appendtext : text) {
				writer.append(appendtext);
			}
		} catch (IOException e) {

			e.printStackTrace();
			Log.d(this.getClass().toString(), e.toString());

		} finally {

			writer.close();
			Log.v(this.getClass().toString(), "Complete wrote UTF-8 Files "
					+ text.toString());

		}

	}

	public void readUtf8File(InputStream in) {
		try {
			/*
			 * InputStream in = openFileInput(filename);
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, "UTF-8"));
			String s;

			while ((s = reader.readLine()) != null) {
				Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateUtf8File(WeekDaySchedule filename) {
		WeekDaySchedule wds = new WeekDaySchedule("aaa", 123, "bbb",
				context);
		try {
			wds.saveWeekdaySchedule();
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public void deleteUtf8File(String filename) {

	}

}
