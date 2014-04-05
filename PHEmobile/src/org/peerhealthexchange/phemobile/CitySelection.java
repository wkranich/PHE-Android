package org.peerhealthexchange.phemobile;

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
		setContentView(R.layout.city_selection);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed Portrait orientation
		
		
		getActionBar().setTitle("Locations");
		
		int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
		
		TextView yourTextView = (TextView) findViewById(titleId);
		Typeface myTypeface = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeue-Light.otf");
		yourTextView.setTypeface(myTypeface);
		
		ListView listview = (ListView) findViewById(R.id.listview);
		HotlinesAdapter adapter = new HotlinesAdapter(getApplicationContext(), globalVars.cityNames, "cities");
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
				Intent intent = new Intent(getApplicationContext(), StartUp.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);
				
			}
		});
		
		
		
		
	}

	
	
}
