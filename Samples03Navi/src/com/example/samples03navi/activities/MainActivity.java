package com.example.samples03navi.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.example.samples03navi.R;
import com.example.samples03navi.utilities.CommonUtilities;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		FragmentManager fragmentmanager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();

		FragmentWeekly fragment = new FragmentWeekly() ;

		fragmentTransaction.add(R.id.fragment_container, fragment);
		fragmentTransaction.commit();


//		setContextView(new FragmentWeekly());

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
					(DrawerLayout) findViewById(R.id.drawer_layout));

		// ファイルの読み込み書き込みを行うためのメソッド
		filetest();

	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	// 画面トップに表示するタイトルを設定する
	public void onSectionAttached(int number) {
		mTitle = getString(R.string.app_name);

	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
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

	// ファイルの登録／読み込みのテストを行うメソッド
	public void filetest() {

		try {
			OutputStream out = openFileOutput("a.txt", MODE_PRIVATE);
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
			writer.append("hello world0");
			writer.append("\n");
			writer.append("hello world1");
			writer.append("\n");
			writer.append("hello world2");
			writer.append("\n");
			writer.close();
			String dirstring = getFilesDir().toString();
			Toast.makeText(this, dirstring, Toast.LENGTH_SHORT).show();

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			InputStream in = openFileInput("a.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, "UTF-8"));
			String s;
			while ((s = reader.readLine()) != null) {
				Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		private static String tTitle = "";

		Integer screenNo = null;
		String screenName = "";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		// 画面に表示する内容を設定する。
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View screenView;

			ScreenInfomationGenerator sig = new ScreenInfomationGenerator();


/*TODO ここの処理をうまくやるひつようがある。
*ユーザがタップした際にこのonCreateViewが実行される。
*ここで実行したいことはメニューを切り替えた時に切り替える必要のある情報をすべてスイッチすること
*・スイッチする際にはScrennInfomationSelectorクラスから情報を取得すること
*・メニューのリストは当日日付によって月日、曜日が切り替わるため対応した情報をセットすること
*
*/

			//			sig.screenInfomationSelector(getArguments().getInt(ARG_SECTION_NUMBER));


			screenSelector(getArguments().getInt(ARG_SECTION_NUMBER));
			TextView topTitle = null;

			CommonUtilities util = new CommonUtilities(getActivity());


			switch (screenName) {
			case "Analysis":
				util.debugToast(getClass().getMethods().toString(), "TEST");
				screenView = inflater.inflate(R.layout.fragment_analysis,
						container, false);
				topTitle = (TextView) screenView.findViewById(R.id.toptitle);
				topTitle.setText(tTitle);
				break;
			case "StockTaking Task":
				screenView = inflater.inflate(R.layout.fragment_analysis,
						container, false);
				topTitle = (TextView) screenView.findViewById(R.id.toptitle);
				topTitle.setText(tTitle);
				break;
			default:

				screenView = inflater.inflate(R.layout.fragment_weekly,
						container, false);
				topTitle = (TextView) screenView.findViewById(R.id.toptitle);
				topTitle.setText(tTitle);
				break;
			}
			return screenView;

		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}


		public void screenSelector(Integer num) {

			switch (num) {
			case 1:
				screenName = getString(R.string.today);
				tTitle = getString(R.string.today_title);
				screenNo = num;
				break;
			case 2:
				screenName = getString(R.string.mon);
				tTitle = getString(R.string.mon_title);
				screenNo = num;
				break;
			case 3:
				screenName = getString(R.string.tue);
				tTitle = getString(R.string.tue_title);
				screenNo = num;
				break;
			case 4:
				screenName = getString(R.string.wed);
				tTitle = getString(R.string.wed_title);
				screenNo = num;
				break;
			case 5:
				screenName = getString(R.string.thu);
				tTitle = getString(R.string.thu_title);
				screenNo = num;
				break;
			case 6:
				screenName = getString(R.string.fri);
				tTitle = getString(R.string.fri_title);
				screenNo = num;
				break;
			case 7:
				screenName = getString(R.string.sat);
				tTitle = getString(R.string.sat_title);
				screenNo = num;
				break;
			case 8:
				screenName = getString(R.string.sun);
				tTitle = getString(R.string.sun_title);
				screenNo = num;
				break;
			case 9:
				screenName = getString(R.string.analysis);
				tTitle = getString(R.string.analysis_title);
				screenNo = num;
				break;
			case 10:
				screenName = getString(R.string.stocktaking);
				tTitle = getString(R.string.stocktaking_title);
				screenNo = num;
				break;
			}

		}

	}

}
