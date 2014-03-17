package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class hotlines extends Fragment {
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ScrollView mScrollView = (ScrollView) inflater.inflate(R.layout.hotlines, container, false);
		ActionBar locationPage = getActivity().getActionBar();
		locationPage.setTitle("Hotlines");
		return mScrollView;
	}
}