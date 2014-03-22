package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class hotlines extends ListFragment {

	/*@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2" };
		HotlinesAdapter adapter = new HotlinesAdapter(getActivity(), values);
		setListAdapter(adapter);
		ActionBar locationPage = getActivity().getActionBar();
		locationPage.setTitle("Hotlines");

	}*/

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = (View) inflater.inflate(R.layout.hotlines, container,
				false);
		
		String[] values = new String[] { "Hospital", "Peer Health", "Clinic",
				"Landmark", "Fenway Health", "MGH", "Boston University SHS", "Brigham",
				"Dentist", "Neurologist", "Blah", "Yeah", "Haha", "Boom", "What happens when I make the string so long that it would go over to the next line?"};
		HotlinesAdapter adapter = new HotlinesAdapter(getActivity(), values);
		setListAdapter(adapter);
		ActionBar locationPage = getActivity().getActionBar();
		locationPage.setTitle("Hotlines");

		return rootView;
	}
}
