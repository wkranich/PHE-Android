package org.peerhealthexchange.phemobile;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class hospitalsMap extends Fragment {
	
	private GoogleMap map;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		//View rootView = inflater.inflate(R.layout.location_page, container, false);
        
        //return rootView;
        return(new FrameLayout(getActivity()));
	}
}
