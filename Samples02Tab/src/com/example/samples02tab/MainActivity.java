package com.example.samples02tab;

import com.example.sample02tab.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        String[] uri = {"http://www.google.co.jp","http://news.mobile.yahoo.co.jp/","http://matome.naver.jp/"};

        actionBar.addTab(actionBar.newTab()
                .setText("Google")
                .setTabListener(new MainTabListener<WebViewFragment>(
                        this, "tag1", WebViewFragment.class,uri[0])));
        actionBar.addTab(actionBar.newTab()
                .setText("Y! News")
                .setTabListener(new MainTabListener<WebViewFragment>(
                        this, "tag2", WebViewFragment.class,uri[1])));
        actionBar.addTab(actionBar.newTab()
                .setText("Naver")
                .setTabListener(new MainTabListener<WebViewFragment>(
                        this, "tag3", WebViewFragment.class,uri[2])));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }




}
