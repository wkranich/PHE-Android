package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.adapters.ListAdapter;
import org.peerhealthexchange.phemobile.objects.globalVars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
		Intent intent = new Intent(getActivity(), ClinicInfo.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// pass on the name of the hospital that was selected
		globalVars.clinic_number = position;
		intent.putExtra("clinic", globalVars.clinic_number);
	    this.startActivity(intent);
	}
}
