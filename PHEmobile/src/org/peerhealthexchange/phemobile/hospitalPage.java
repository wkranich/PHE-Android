package org.peerhealthexchange.phemobile;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hospitalPage extends Activity {

	private GoogleMap map;
	private String number = "tel:6106533136";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_speific_hospital);

		Button callButton = (Button) findViewById(R.id.button3);

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		callButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
				startActivity(callIntent);

			}
		});
	}
}
