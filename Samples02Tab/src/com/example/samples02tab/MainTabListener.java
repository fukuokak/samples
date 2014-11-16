package com.example.samples02tab;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View.OnLongClickListener;

public class MainTabListener<T extends Fragment> implements TabListener {

	private Fragment fragment;
	private final Activity activity;
	private final String tag;
	private final Class<T> cls;
	private final String uri;

	public MainTabListener(Activity activity, String tag, Class<T> cls , String uri) {
		this.activity = activity;
		this.tag = tag;
		this.cls = cls;
		this.uri = uri;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		Bundle bundle = new Bundle();
		bundle.putString("URI", uri);
		if (fragment == null) {
			fragment = Fragment.instantiate(activity, cls.getName());
			fragment.setArguments(bundle);
			ft.add(android.R.id.content, fragment, tag);
		} else {
			ft.attach(fragment);
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO 自動生成されたメソッド・スタブ
		if (fragment != null) {
			ft.detach(fragment);
		}

	}
}