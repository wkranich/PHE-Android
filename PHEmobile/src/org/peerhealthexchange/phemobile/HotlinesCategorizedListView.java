package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.adapters.ListAdapter;
import org.peerhealthexchange.phemobile.objects.globalVars;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class HotlinesCategorizedListView extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		if (savedInstanceState != null) {
			Log.d("bundler", "I'm restoring hotlines categorized");
			PHEdatabase db = new PHEdatabase(getApplicationContext());

			// we grab the values we saved
			globalVars.city_id = savedInstanceState.getString("city_id");
			globalVars.city_name = savedInstanceState.getString("city_name");
			globalVars.category_name = savedInstanceState
					.getString("category_name");

			// now we have to redo the setup
			globalVars.lCities.clear();
			globalVars.lCategories.clear();
			globalVars.lClinics.clear();
			globalVars.lHotlines.clear();

			globalVars.lCities.addAll(db.getCities());
			globalVars.lCategories.addAll(db.getHotlineCategories());
			globalVars.lClinics.addAll(db.getCityClinics(globalVars.city_id));
			globalVars.lHotlines.addAll(db.getHotlines(globalVars.city_id,
					globalVars.category_name));

			globalVars.cityNamesInflater();
			globalVars.categoryNamesInflater();
			globalVars.hospitalNamesInflater();
			globalVars.hotlineNamesInflater();
			db.close();
			savedInstanceState.clear();
		}
		// set the page name from the category that was selected
		getActionBar().setTitle(getIntent().getStringExtra("category"));
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// we need to find textview that is responsible for filling the title of
		// the page
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView textView = (TextView) findViewById(titleId);
		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		textView.setTypeface(typeface);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed
																			// Portrait
																			// orientation
		ListView listView = (ListView) findViewById(R.id.listview);
		ListAdapter adapter = new ListAdapter(getApplicationContext(),
				globalVars.hotlineNames, "hotlines");
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1,
					int position, long id) {
				// check if the user pressed on a phone line or a website
				if (position < globalVars.lHotlines.size()) {
					Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
							+ globalVars.lHotlines.get(position).getPhoneNumber()));
					startActivity(callIntent);
				} // if it's not a phone it's gotta be a website
				else {
					Intent website = new Intent(Intent.ACTION_VIEW, Uri
							.parse(globalVars.lWebsites.get(
									position - globalVars.lHotlines.size())
									.getWebsite()));
					startActivity(website);
				}
			}

		});
	}

	public void onChoiceClick(int which) {
		Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
				+ globalVars.lHotlines.get(which).getPhoneNumber()));
		startActivity(callIntent);
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Log.d("bundler", "I'm saving hotline categorized");
		savedInstanceState.putString("city_name", globalVars.city_name);
		savedInstanceState.putString("city_id", globalVars.city_id);
		savedInstanceState.putString("category_name", globalVars.category_name);
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
