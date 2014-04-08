package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.adapters.ListAdapter;
import org.peerhealthexchange.phemobile.objects.globalVars;

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

public class HospitalListFrag extends ListFragment {
	private ListView mListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mListView = (ListView) inflater.inflate(R.layout.list_fragment, container,
				false);
		
		// fill our list the hospital string array
		ListAdapter adapter = new ListAdapter(getActivity(), globalVars.hospitalNames, "hospitals");
		setListAdapter(adapter);

		return mListView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(getActivity(), HospitalMapView.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// pass on the name of the hospital that was selected
		intent.putExtra("hospital", globalVars.hospitalNames[position]);
	    this.startActivity(intent);
	}
}
