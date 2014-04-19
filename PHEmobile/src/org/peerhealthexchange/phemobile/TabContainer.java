package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.adapters.TabsPagerAdapter;
import org.peerhealthexchange.phemobile.objects.globalVars;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TabContainer extends FragmentActivity implements
		ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab Titles
	private String[] tabs = { "Clinics", "Hotlines" };
	TextView tab;
	LayoutParams lp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_up_page);
		if (savedInstanceState != null) {
			Log.d("bundler", "I'm restoring tab container");
			PHEdatabase db = new PHEdatabase(getApplicationContext());

			// we grab the values we saved
			globalVars.city_id = savedInstanceState.getString("city_id");
			globalVars.city_name = savedInstanceState.getString("city_name");

			// now we have to redo the setup
			globalVars.lCities.clear();
			globalVars.lCategories.clear();
			globalVars.lClinics.clear();
			globalVars.lCities.addAll(db.getCities());
			globalVars.lCategories.addAll(db.getHotlineCategories());
			globalVars.lClinics.addAll(db.getCityClinics(globalVars.city_id));

			globalVars.cityNamesInflater();
			globalVars.categoryNamesInflater();
			globalVars.hospitalNamesInflater();
			db.close();
			savedInstanceState.clear();
		}
		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		// Parse.initialize(this, "DYgXFCYiB9j2MTxqL4FvNscHYhFs4r9TkRZbCi35",
		// "H8on7fpB4BcFlYvcQqQ7yjsqhSFQcPUjdqO4SYnu");

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		getActionBar().setTitle(globalVars.city_name + " : Resources");
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");

		TextView textView = (TextView) findViewById(titleId);
		textView.setTypeface(typeface);
		actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources()
				.getColor(R.color.pheblue)));
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		for (String tab_name : tabs) {
			tab = new TextView(this);
			tab.setTextSize(getResources().getDimension(R.dimen.textsize));
			tab.setText(tab_name);
			tab.setTypeface(typeface);
			tab.setGravity(Gravity.CENTER);
			tab.setPadding(0, 25, 0, 0);
			actionBar.addTab(actionBar.newTab().setCustomView(tab)
					.setTabListener(this));
		}

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);

			}

		});
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed
																			// Portrait
																			// orientation
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Log.d("bundler", "I'm saving tab container");
		savedInstanceState.putString("city_name", globalVars.city_name);
		savedInstanceState.putString("city_id", globalVars.city_id);
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.tab_container, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.newCity:
			Intent intent = new Intent(getApplicationContext(),
					CitySelection.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent);
			finish();
			return true;
		default:
			return false;

		}
	}

}
