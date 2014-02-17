package org.peerhealthexchange.phemobile;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class location extends Activity implements LocationListener {
	// change this as you please, this is the update interval
	private static final int TWO_MINUTES = 1000 * 60 * 2;
	private static final LatLng buSHS = new LatLng(42.35144,-71.1153548);
	private LocationManager locationManager;
	private GoogleMap map;
	private LatLng myLocation;
	private Marker myMarker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_page);
		
		ActionBar locationPage = getActionBar();
		locationPage.setTitle("Locations");
		
		locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.setMyLocationEnabled(true);

		if (locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
			locationManager.requestLocationUpdates(
					locationManager.GPS_PROVIDER, 0, 0, this);
			Location location = locationManager
					.getLastKnownLocation(locationManager.GPS_PROVIDER);
			Marker kiel = map.addMarker(new MarkerOptions().position(buSHS).title("BU SHS").snippet("BU Student Health Services"));
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(buSHS, 14));
			//onLocationChanged(location);
		} else {
			// do nothing... for now....
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_up, menu);
		return true;
	}

	@Override
	public void onLocationChanged(Location location) {
		/*myLocation = new LatLng(location.getLatitude(), location.getLongitude());
		myMarker = map.addMarker(new MarkerOptions().position(myLocation));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));*/
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	// code to re-enable the gps when the user goes back to the app
	@Override
	public void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,
				0, 0, this);
	}

	// code to stop the gps when the user hides the app
	@Override
	public void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

}
