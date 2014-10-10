package com.example.samples03navi.models;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;


public class WeekDaySchedule extends ContextWrapper{
	public WeekDaySchedule(Context base) {
		super(base);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	private String filename;
	private Integer writemode;
	private String writetext ;

	public WeekDaySchedule(String filename , Integer writemode , String writetext, Context base){
		super(base);
		this.filename = filename;
		this.writemode = writemode;
		this.writetext = writetext;
	}


	String getFilename(){
		return this.filename;
	}
	Integer getWritemode(){
		return this.writemode;
	}
	String getWriteText(){
		return this.writetext;
	}

	public void saveWeekdaySchedule() throws UnsupportedEncodingException{
		try{
			OutputStream out = getBaseContext().openFileOutput(filename, writemode);
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
			writer.append(writetext);
			writer.close();
		}catch (FileNotFoundException e){
		Log.d("Aaa", "aaa",e);
		}

	}
}
