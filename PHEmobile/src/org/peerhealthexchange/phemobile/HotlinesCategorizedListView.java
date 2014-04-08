package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.dialogbox.HotlinesDialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
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

public class HotlinesCategorizedListView extends Activity implements
		HotlinesDialog.HotlinesDialogListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotline_categorized);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fixed Portrait orientation
		ListView listview = (ListView) findViewById(R.id.listview);
		ListAdapter adapter = new ListAdapter(getApplicationContext(),
				globalVars.hotlineNames, "hotlines");
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1,
					int position, long id) {
				hotlineOptions(globalVars.lHotlines.get(position)
						.getExtraDetails(), globalVars.lHotlines.get(position)
						.getName(), position);
			}

		});
	}

	public void onChoiceClick(int which) {
		Intent callIntent = new Intent(Intent.ACTION_CALL,
				Uri.parse("tel:"+globalVars.lHotlines.get(which).getPhoneNumber()));
		startActivity(callIntent);
	}

	public void hotlineOptions(String Hours, String Name, int position) {
		DialogFragment newFragment = HotlinesDialog.newInstance(Hours, Name,
				position);
		newFragment.show(getFragmentManager(), "options");
	}
}
