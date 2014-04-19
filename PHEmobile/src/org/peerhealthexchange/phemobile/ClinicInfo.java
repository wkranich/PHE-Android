package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.objects.Clinic;
import org.peerhealthexchange.phemobile.objects.globalVars;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClinicInfo extends Activity {

	private TextView clinicName, hourDetails, address, extraDetails;
	private Button directions, call;
	private GoogleMap map;
	private LatLng point;
	private ImageView lowCost, confidential, reproductive;
	private final static String delim = "[,]";
	private Clinic selectedClinic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Typeface typefaceTitle = Typeface.createFromAsset(this.getAssets(),
				"fonts/Helvetica.otf");
		Typeface typeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		if (savedInstanceState != null) {
			Log.d("bundler", "I'm restoring clinic info");
			PHEdatabase db = new PHEdatabase(getApplicationContext());

			// we grab the values we saved
			globalVars.city_id = savedInstanceState.getString("city_id");
			globalVars.city_name = savedInstanceState.getString("city_name");
			globalVars.category_name = savedInstanceState
					.getString("category_name");
			globalVars.clinic_number = savedInstanceState
					.getInt("clinic_number");

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
			selectedClinic = globalVars.lClinics.get(globalVars.clinic_number);
			savedInstanceState.clear();
		} else {
			selectedClinic = globalVars.lClinics.get(getIntent().getIntExtra(
					"clinic", 0));
		}

		setContentView(R.layout.clinic_info);
		getActionBar().setTitle(selectedClinic.getName());
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// we need to find textview that is responsible for filling the title of
		// the page
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView textView = (TextView) findViewById(titleId);
		textView.setTypeface(typeface);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed
																			// Portrait
																			// orientation

		clinicName = (TextView) findViewById(R.id.clinicName);
		hourDetails = (TextView) findViewById(R.id.hourDetails);
		address = (TextView) findViewById(R.id.address);
		extraDetails = (TextView) findViewById(R.id.extraDetails);

		lowCost = (ImageView) findViewById(R.id.lowCost);
		confidential = (ImageView) findViewById(R.id.confidential);
		reproductive = (ImageView) findViewById(R.id.reproductive);

		directions = (Button) findViewById(R.id.directions);
		call = (Button) findViewById(R.id.call);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.getUiSettings().setZoomControlsEnabled(false);
		if (selectedClinic.getGeoPoint() != null) {
			String[] geopoint = selectedClinic.getGeoPoint().split(delim);
			point = new LatLng(Float.parseFloat(geopoint[0]),
					Float.parseFloat(geopoint[1]));

			Marker clinic = map.addMarker(new MarkerOptions().position(point)
					.title(selectedClinic.getName()));

			map.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
		}

		clinicName.setTypeface(typefaceTitle);
		clinicName.setText(selectedClinic.getName());

		hourDetails.setTypeface(typeface);
		hourDetails.setText(selectedClinic.getHours());

		address.setTypeface(typefaceTitle);
		address.setText(selectedClinic.getAddress());

		extraDetails.setTypeface(typeface);
		extraDetails.setText(selectedClinic.getDetails());

		directions.setTypeface(typeface);

		call.setTypeface(typeface);
		call.setText("Call: " + selectedClinic.getPhone());

		lowCost.setImageResource(selectedClinic.getLowCost() ? R.drawable.ic_nonexpensive
				: R.drawable.ic_isexpensive);
		confidential
				.setImageResource(selectedClinic.getConfidential() ? R.drawable.ic_confidential
						: android.R.color.transparent);
		reproductive
				.setImageResource(selectedClinic.getReproductive() ? R.drawable.ic_reproductive
						: android.R.color.transparent);

		call.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri
						.parse("tel:" + selectedClinic.getPhone()));
				startActivity(callIntent);

			}

		});

		directions.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (selectedClinic.getGeoPoint() != null) {
					Intent navIntent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("http://maps.google.com/maps?" + "&daddr="
									+ selectedClinic.getGeoPoint()));
					startActivity(navIntent);
				} else {
					Toast.makeText(getApplicationContext(),
							"Cannot Find Directions", Toast.LENGTH_SHORT)
							.show();
				}
			}

		});

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

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		Log.d("bundler", "I'm saving clinic info page");
		savedInstanceState.putString("city_name", globalVars.city_name);
		savedInstanceState.putString("city_id", globalVars.city_id);
		savedInstanceState.putInt("clinic_number", globalVars.clinic_number);
		super.onSaveInstanceState(savedInstanceState);
	}

}
