package org.peerhealthexchange.phemobile;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
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
	List<ParseObject> listCities;

	String DB_FULL_PATH = "//data/data/org.peerhealthexchange.phemobile/databases/pheDatabase";

	PHEdatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_screen);

		//Parse.initialize(this, "DYgXFCYiB9j2MTxqL4FvNscHYhFs4r9TkRZbCi35",
		//		"H8on7fpB4BcFlYvcQqQ7yjsqhSFQcPUjdqO4SYnu");

		db = new PHEdatabase(getApplicationContext());
		//db.deleteDB(this);

		if (!checkDataBase()) {
			ParseQuery<ParseObject> query1 = ParseQuery
					.getQuery("healthClinics");
			ParseQuery<ParseObject> query2 = ParseQuery
					.getQuery("hotlineCategories");
			ParseQuery<ParseObject> query3 = ParseQuery.getQuery("hotlines");
			ParseQuery<ParseObject> query4 = ParseQuery.getQuery("cities");
			try {
				listHospitals = query1.find();
				listHotlineCategories = query2.find();
				listHotlines = query3.find();
				listCities = query4.find();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (ParseObject hospital : listHospitals) {
				Clinics aClinic = new Clinics(hospital.getObjectId(),
						hospital.getString("cityID"),
						hospital.getString("name"),
						hospital.getString("address"),
						hospital.getString("hoursDetails"),
						hospital.getString("phone"),
						hospital.getString("Details"),
						hospital.getBoolean("isConfidential"),
						hospital.getBoolean("isLowCost"),
						hospital.getBoolean("isOnlyReproductive"),
						hospital.getString("geoPoint"));
				db.createClinics(aClinic);
			}

			for (ParseObject city : listCities) {
				Cities aCity = new Cities(city.getObjectId(),
						city.getString("name"));
				db.createCities(aCity);
			}

			for (ParseObject category : listHotlineCategories) {
				HotlineCategories aCategory = new HotlineCategories(
						category.getObjectId(),
						category.getString("hotlineTitle"));

				db.createCategories(aCategory);
			}

			for (ParseObject hotline : listHotlines) {
				HotlinesInfo aHotline = new HotlinesInfo(hotline.getObjectId(),
						hotline.getString("cityID"),
						hotline.getString("hotlineTitleID"),
						hotline.getString("name"),
						hotline.getString("phoneNumber"),
						hotline.getString("extraDetails"));
				
				db.createHotlines(aHotline);
			}
			
			globalVars.ran=false;
		}
		
		if(!globalVars.ran){
			globalVars.lCategories.addAll(db.getHotlineCategories());
			db.close();
			globalVars.categoryNamesInflater();
			
			globalVars.ran = true;
		}

		Intent intent = new Intent(getApplicationContext(), CitySelection.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
		finish();
	}

	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			checkDB = SQLiteDatabase.openDatabase(DB_FULL_PATH, null,
					SQLiteDatabase.OPEN_READONLY);
			checkDB.close();
		} catch (SQLiteException e) {
			// database doesn't exist yet
		}
		return checkDB != null ? true : false;
	}

}
