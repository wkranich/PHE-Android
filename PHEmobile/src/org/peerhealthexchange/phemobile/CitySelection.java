package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.adapters.ListAdapter;
import org.peerhealthexchange.phemobile.objects.globalVars;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CitySelection extends Activity{
	
	PHEdatabase db;
	Button bayOak,baySF,bostonMain,bostonOuter,chicago,laNorte,laNorth,laSouth,laSur,bronx,brooklyn,manhattan,queens,dc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed Portrait orientation
		
		// set the page name
		getActionBar().setTitle("Locations");
		
		// we need to find textview that is responsible for filling the title of the page
		int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
		TextView yourTextView = (TextView) findViewById(titleId);
		Typeface myTypeface = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeue-Light.otf");
		yourTextView.setTypeface(myTypeface);
		
		// filling our listview with the city string array
		ListView listview = (ListView) findViewById(R.id.listview);
		ListAdapter adapter = new ListAdapter(getApplicationContext(), globalVars.cityNames, "cities");
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long id) {
				db = new PHEdatabase(getApplicationContext());
				globalVars.lHospitals.clear();
				globalVars.hospitalNames = null;
				globalVars.city_id = globalVars.lCities.get(position).getId();
				globalVars.city_name = globalVars.lCities.get(position).getName();
				
				globalVars.lHospitals.addAll(db.getCityClinics(globalVars.city_id));
				
				db.close();
				globalVars.hospitalNamesInflater();
				Intent intent = new Intent(getApplicationContext(), TabContainer.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);
				
			}
		});
		
		
		
		
	}

	
	
}
