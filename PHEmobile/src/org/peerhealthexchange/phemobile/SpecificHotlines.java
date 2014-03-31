package org.peerhealthexchange.phemobile;

import android.app.Activity;
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

public class SpecificHotlines extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotline_categorized);
		
		ListView listview = (ListView) findViewById(R.id.listview);
		HotlinesAdapter adapter = new HotlinesAdapter(getApplicationContext(), globalVars.hotlineNames);
		Log.d("nameSize",Integer.toString(globalVars.lHotlines.size()));
		listview.setAdapter(adapter);
	}
	
	
	
	
}
