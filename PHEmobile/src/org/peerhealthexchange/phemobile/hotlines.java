package org.peerhealthexchange.phemobile;

import com.parse.ParseObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class hotlines extends ListFragment {
	//String[] values = new String[globalVars.lHospitals.size()];
	private ListView mListView;

	/*
	 * @Override public void onActivityCreated(Bundle savedInstanceState) {
	 * super.onActivityCreated(savedInstanceState); String[] values = new
	 * String[] { "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS",
	 * "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2" }; HotlinesAdapter
	 * adapter = new HotlinesAdapter(getActivity(), values);
	 * setListAdapter(adapter); ActionBar locationPage =
	 * getActivity().getActionBar(); locationPage.setTitle("Hotlines");
	 * 
	 * }
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mListView = (ListView) inflater.inflate(R.layout.hotlines, container,
				false);
		
		
	
		HotlinesAdapter adapter = new HotlinesAdapter(getActivity(), globalVars.categoryNames);
		setListAdapter(adapter);

		/*mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getActivity(),
						"Click ListItem Number " + position, Toast.LENGTH_LONG)
						.show();
			}
		});*/

		return mListView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		/*Toast.makeText(getActivity(),
				"Click ListItem Number " + position, Toast.LENGTH_LONG)
				.show();*/
		Intent intent = new Intent(getActivity(), hospitalPage.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("position", position);
	    this.startActivity(intent);
	}
}
