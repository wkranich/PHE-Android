package org.peerhealthexchange.phemobile;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import org.peerhealthexchange.phemobile.dialogbox.*;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HospitalMapView extends Activity implements
		MapsDialog.MapsDialogListener {

	private GoogleMap map;
	private LatLng buSHS = new LatLng(42.35144, -71.1153548);
	private String number = "tel:610-653-3136";
	private String Name = "BU SHS";
	private String Hours = "General Hours: Mon/Fri 8:45am-5pm, Tues/Thurs 8:45am-7pm, Wed 1pm-7pm Walk-In Hours: Fri 10am-4:30pm";
	private String Address = "130 Boylston St, Boston, MA";

	class MyInfoWindowsAdapter implements InfoWindowAdapter {

		private final View myContentsView;

		MyInfoWindowsAdapter() {
			myContentsView = getLayoutInflater().inflate(
					R.layout.custom_info_box, null);
		}

		@Override
		public View getInfoContents(Marker marker) {

			TextView hospitalName = ((TextView) myContentsView
					.findViewById(R.id.name));
			TextView hospitalHours = ((TextView) myContentsView
					.findViewById(R.id.hours));
			TextView hospitalAddress = ((TextView) myContentsView
					.findViewById(R.id.address));

			hospitalName.setText(Name);
			hospitalAddress.setText(Address);
			hospitalHours.setText(Hours);
			return myContentsView;
		}

		@Override
		public View getInfoWindow(Marker arg0) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hospital_map_layout);

		// set the page name from the hospital that was selected
		getActionBar().setTitle(getIntent().getStringExtra("hospital"));

		// we need to find textview that is responsible for filling the title of
		// the page
		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView yourTextView = (TextView) findViewById(titleId);
		Typeface myTypeface = Typeface.createFromAsset(this.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		yourTextView.setTypeface(myTypeface);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.setInfoWindowAdapter(new MyInfoWindowsAdapter());

		Marker SHS = map.addMarker(new MarkerOptions().position(buSHS).title(
				Name));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(buSHS, 14));
		map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

			@Override
			public void onInfoWindowClick(Marker marker) {
				hospitalOptions(Hours, Name);

			}
		});
		SHS.showInfoWindow();

	}

	@Override
	public void onChoiceClick(int which) {
		switch (which) {
		case 0:
			String uri = "geo:0,0?q=" + buSHS.latitude + "," + buSHS.longitude
					+ "(" + Name + ")";
			startActivity(new Intent(android.content.Intent.ACTION_VIEW,
					Uri.parse(uri)));
			break;
		case 1:
			Intent callIntent = new Intent(Intent.ACTION_CALL,
					Uri.parse(number));
			startActivity(callIntent);
			break;
		}

	}

	public void hospitalOptions(String Hours, String Name) {
		DialogFragment newFragment = MapsDialog.newInstance(Hours, Name);
		newFragment.show(getFragmentManager(), "options");
	}
}
