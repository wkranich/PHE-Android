package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.adapters.ListAdapter;
import org.peerhealthexchange.phemobile.dialogbox.RememberCity;
import org.peerhealthexchange.phemobile.objects.globalVars;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CitySelection extends Activity implements
		RememberCity.RememberCityListener {

	PHEdatabase db;
	Button bayOak, baySF, bostonMain, bostonOuter, chicago, laNorte, laNorth,
			laSouth, laSur, bronx, brooklyn, manhattan, queens, dc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		
		if (savedInstanceState != null) {
			Log.d("bundler", "I'm restoring city selection");
			db = new PHEdatabase(getApplicationContext());

			// redoing the setup
			globalVars.lCities.clear();
			globalVars.lCategories.clear();

			globalVars.lCities.addAll(db.getCities());
			globalVars.lCategories.addAll(db.getHotlineCategories());
			db.close();
			globalVars.cityNamesInflater();
			globalVars.categoryNamesInflater();
			savedInstanceState.clear();
		}
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed
																			// Portrait
																			// orientation

		// set the page name
		getActionBar().setTitle("Locations");

		// we need to find textview that is responsible for filling the title of
		// the page
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView textView = (TextView) findViewById(titleId);
		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		textView.setTypeface(typeface);

		// filling our listview with the city string array
		ListView listView = (ListView) findViewById(R.id.listview);
		ListAdapter adapter = new ListAdapter(getApplicationContext(),
				globalVars.cityNames, "cities");
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onItemClick(AdapterView<?> parent, View arg1,
					int position, long id) {
				db = new PHEdatabase(getApplicationContext());
				globalVars.lClinics.clear();
				globalVars.hospitalNames = null;
				globalVars.city_id = globalVars.lCities.get(position).getId();
				globalVars.city_name = globalVars.lCities.get(position)
						.getName();

				globalVars.lClinics.addAll(db
						.getCityClinics(globalVars.city_id));

				db.close();
				showDialog(5);
				// DialogFragment newFragment = RememberCity.newInstance();
				// newFragment.show(getFragmentManager(),"remember");
				globalVars.hospitalNamesInflater();

			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 5:
			Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Remember City?");
			builder.setPositiveButton("Yes", new OkOnClickListener());
			builder.setNegativeButton("No", new CancelOnClickListener());
			AlertDialog dialog = builder.create();
			dialog.show();
			TextView message = (TextView) dialog.findViewById(android.R.id.message);
			Button yes = (Button) dialog.findViewById(android.R.id.button1);
			Button no = (Button) dialog.findViewById(android.R.id.button2);
			Typeface typeface = Typeface.createFromAsset(this.getAssets(),
					"fonts/HelveticaNeue-Light.otf");
			message.setTypeface(typeface);
			yes.setTypeface(typeface);
			no.setTypeface(typeface);
		}
		return super.onCreateDialog(id);
	}

	private final class CancelOnClickListener implements
			DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int which) {
			Intent intent = new Intent(getApplicationContext(),
					TabContainer.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent);
		}
	}

	private final class OkOnClickListener implements
			DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int which) {
			db = new PHEdatabase(getApplicationContext());
			db.createRememberCity(globalVars.city_name);
			db.close();
			Intent intent = new Intent(getApplicationContext(), TabContainer.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent);
			finish();
		}
	}

	public void onChoiceClick(int which) {
		Intent intent = new Intent(getApplicationContext(), TabContainer.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
	}

}
