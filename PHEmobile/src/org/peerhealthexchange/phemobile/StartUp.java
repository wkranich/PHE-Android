package org.peerhealthexchange.phemobile;

import java.util.ArrayList;

import org.peerhealthexchange.phemobile.slidingmenu.adapter.TabsPagerAdapter;
import org.peerhealthexchange.phemobile.slidingmenu.model.NavDrawerItem;

import com.parse.Parse;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class StartUp extends FragmentActivity implements ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab Titles
	private String[] tabs = { "Hospitals", "Hotlines" };
	TextView tab;
	LayoutParams lp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_up_page);
		Typeface myTypeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		// Parse.initialize(this, "DYgXFCYiB9j2MTxqL4FvNscHYhFs4r9TkRZbCi35",
		// "H8on7fpB4BcFlYvcQqQ7yjsqhSFQcPUjdqO4SYnu");

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		getActionBar().setTitle(globalVars.city_name + " : Resources");
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");

		TextView yourTextView = (TextView) findViewById(titleId);
		yourTextView.setTypeface(myTypeface);
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
			tab.setTypeface(myTypeface);
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

}
