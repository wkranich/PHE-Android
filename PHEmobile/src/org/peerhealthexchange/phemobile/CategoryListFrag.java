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

public class CategoryListFrag extends ListFragment {
	PHEdatabase db;
	private ListView mListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mListView = (ListView) inflater.inflate(R.layout.list_fragment, container,
				false);
		ListAdapter adapter = new ListAdapter(getActivity(), globalVars.categoryNames, "categories");
		setListAdapter(adapter);

		return mListView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		db = new PHEdatabase(getActivity());
		
		// make sure we clear our list of categorized hotlines
		globalVars.lHotlines.clear();
		
		// find all hotlines related to the category and city that got selected
		globalVars.lHotlines.addAll(db.getHotlines(globalVars.city_id, globalVars.lCategories.get(position).getId()));
		
		// inflate the strings
		globalVars.hotlineNamesInflater();
		db.close();
		
		// call up the next activity
		Intent intent = new Intent(getActivity(), HotlinesCategorizedListView.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// passing on the category name to the next activity
		intent.putExtra("category", globalVars.categoryNames[position]);
	    this.startActivity(intent);
	}
}
