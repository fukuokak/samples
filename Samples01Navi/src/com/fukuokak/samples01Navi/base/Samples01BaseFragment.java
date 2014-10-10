package com.fukuokak.samples01Navi.base;

import android.app.Fragment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Samples01BaseFragment extends Fragment {

	public Properties msgconfiguration = new Properties();

	public void loadMessage() {

		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File("message.properties"));
			msgconfiguration.load(inputStream);

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			Log.v("", "", e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			Log.v("", "", e);
			e.printStackTrace();
		}

	}
}
