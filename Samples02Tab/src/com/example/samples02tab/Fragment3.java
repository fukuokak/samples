package com.example.samples02tab;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample02tab.R;

public class Fragment3 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.v(this.getClass().getName(), "STARTTAB3");

		return inflater.inflate(R.layout.fragment3, container, false);
	}
}
