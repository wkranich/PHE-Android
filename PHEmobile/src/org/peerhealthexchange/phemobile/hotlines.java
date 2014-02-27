package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class hotlines extends Fragment {
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.videos, container, false);
		ActionBar locationPage = getActivity().getActionBar();
		locationPage.setTitle("Hotlines");
		// Button postQuestion = (Button) findViewById(R.id.postButt);
		// Button recentActivity = (Button) findViewById(R.id.recentButt);
		return rootView;
	}
}