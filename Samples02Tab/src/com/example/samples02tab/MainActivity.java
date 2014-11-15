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

        actionBar.addTab(actionBar.newTab()
                .setText("Google")
                .setTabListener(new MainTabListener<Fragment1>(
                        this, "tag1", Fragment1.class)));
        actionBar.addTab(actionBar.newTab()
                .setText("Y! News")
                .setTabListener(new MainTabListener<Fragment2>(
                        this, "tag2", Fragment2.class)));
        actionBar.addTab(actionBar.newTab()
                .setText("Naver")
                .setTabListener(new MainTabListener<Fragment3>(
                        this, "tag‚R", Fragment3.class)));
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
}
