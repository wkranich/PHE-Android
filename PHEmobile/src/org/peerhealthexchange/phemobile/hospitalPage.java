package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.dialogbox.MapsDialog.MapsDialogListener;

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
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hospitalPage extends Activity implements
		MapsDialog.MapsDialogListener {

	private GoogleMap map;
	private LatLng buSHS = new LatLng(42.35144, -71.1153548);
	private String number = "tel:6106533136";
	private String Name = "BU SHS";
	private String Hours = "General Hours: Mon/Fri 8:45am-5pm, Tues/Thurs 8:45am-7pm, Wed 1pm-7pm Walk-In Hours: Fri 10am-4:30pm";
	private String Address = "130 Boylston St, Boston, MA";

	class MyInfoWindowsAdapter implements InfoWindowAdapter {

		private final View myContentsView;

		MyInfoWindowsAdapter() {
			myContentsView = getLayoutInflater().inflate(R.layout.custom_info,
					null);
		}

		@Override
		public View getInfoContents(Marker marker) {

			TextView hospitalName = ((TextView) myContentsView
					.findViewById(R.id.name));
			TextView hospitalHours = ((TextView) myContentsView.findViewById(R.id.hours));
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
		setContentView(R.layout.test_speific_hospital);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.setInfoWindowAdapter(new MyInfoWindowsAdapter());

		Marker SHS = map.addMarker(new MarkerOptions().position(buSHS).title(
				Name));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(buSHS, 14));
		map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

			@Override
			public void onInfoWindowClick(Marker marker) {
				hospitalOptions(Hours,Name);

			}
		});
		SHS.showInfoWindow();

	}

	@Override
	public void onChoiceClick(int which) {
		switch (which) {
		case 0:
			String uri = "geo:0,0?q="+buSHS.latitude+","+buSHS.longitude+"("+Name+")";
			startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
			break;
		case 1:
			Intent callIntent = new Intent(Intent.ACTION_CALL,
					Uri.parse(number));
			startActivity(callIntent);
			break;
		}

	}

	public void hospitalOptions(String Hours, String Name) {
		DialogFragment newFragment = MapsDialog.newInstance(Hours,Name);
		newFragment.show(getFragmentManager(), "options");
	}
}
