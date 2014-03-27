package org.peerhealthexchange.phemobile;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class loading extends Activity {
	List<ParseObject> listHospitals;
	List<ParseObject> listHotlineCategories;
	List<ParseObject> listHotlines;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_screen);
		
		Parse.initialize(this, "DYgXFCYiB9j2MTxqL4FvNscHYhFs4r9TkRZbCi35",
				"H8on7fpB4BcFlYvcQqQ7yjsqhSFQcPUjdqO4SYnu");

		ParseQuery<ParseObject> query1 = ParseQuery.getQuery("healthClinics");
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery("hotlineCategories");
		ParseQuery<ParseObject> query3 = ParseQuery.getQuery("hotlines");
		try {
			listHospitals = query1.find();
			listHotlineCategories = query2.find();
			listHotlines = query3.find();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (ParseObject hospital : listHospitals) {
			globalVars.lHospitals.add(new hospitals(hospital.getString("objectId"),
					hospital.getString("cityId"),
					hospital.getString("name"), hospital
					.getString("address"), hospital
					.getString("hoursDetails"), hospital
					.getString("phone"), hospital
					.getString("Details"), hospital
					.getBoolean("isConfidential"), hospital
					.getBoolean("isLowCost"), hospital
					.getBoolean("isOnlyReproductive")));
		}
		
		globalVars.hospitalNames = new String[globalVars.lHospitals.size()];
		
		for (int i = 0; i < globalVars.lHospitals.size(); i++) {
			Log.d("wat", "yo");
			hospitals hospital = globalVars.lHospitals.get(i);
			globalVars.hospitalNames[i] = hospital.getName();
		}
		// globalVars.hospitalNamesInflater(globalVars.lHospitals);

		Intent intent = new Intent(getApplicationContext(), StartUp.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
