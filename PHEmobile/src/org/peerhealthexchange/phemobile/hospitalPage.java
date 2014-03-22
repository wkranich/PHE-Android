package org.peerhealthexchange.phemobile;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.os.Bundle;

public class hospitalPage extends Activity{
	
	private GoogleMap map;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_speific_hospital);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
	}
}
