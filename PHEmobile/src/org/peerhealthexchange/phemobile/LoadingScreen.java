package org.peerhealthexchange.phemobile;

import java.util.List;

import org.peerhealthexchange.phemobile.objects.Category;
import org.peerhealthexchange.phemobile.objects.City;
import org.peerhealthexchange.phemobile.objects.Clinic;
import org.peerhealthexchange.phemobile.objects.Hotline;
import org.peerhealthexchange.phemobile.objects.Website;
import org.peerhealthexchange.phemobile.objects.globalVars;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

// this is the first activity that gets called when the app starts
public class LoadingScreen extends Activity {
	List<ParseObject> listHospitals;
	List<ParseObject> listHotlineCategories;
	List<ParseObject> listHotlines;
	List<ParseObject> listCities;
	List<ParseObject> listWebsites;

	public static globalVars gVars;

	String DB_FULL_PATH = "//data/data/org.peerhealthexchange.phemobile/databases/pheDatabase";

	PHEdatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.loading_screen);
		getActionBar().hide();
		new Handler().postDelayed(new Runnable(){
	        @Override
	        public void run() {
	        /* Create an Intent that will start the InfralineTabWidget-Activity. */
	        	loadMethod();
	        }
	    }, 3000);
		
	}
	
	public void loadMethod(){
		gVars = new globalVars();

		db = new PHEdatabase(getApplicationContext());
		//db.deleteDB(this);

		// we need to check if the database exists so we don't end up adding
		// duplicates
		if (!checkDataBase()) {
			ParseQuery<ParseObject> query1 = ParseQuery
					.getQuery("healthClinics");
			query1.setLimit(1000);
			query1.orderByAscending("name");
			ParseQuery<ParseObject> query2 = ParseQuery
					.getQuery("hotlineCategories");
			query2.setLimit(1000);
			query2.orderByAscending("name");
			ParseQuery<ParseObject> query3 = ParseQuery.getQuery("hotlines");
			query3.setLimit(1000);
			query3.orderByAscending("name");
			ParseQuery<ParseObject> query4 = ParseQuery.getQuery("cities");
			query4.setLimit(1000);
			query4.orderByAscending("name");
			ParseQuery<ParseObject> query5 = ParseQuery.getQuery("websites");
			query5.setLimit(1000);
			query5.orderByAscending("name");
			try {
				listHospitals = query1.find();
				listHotlineCategories = query2.find();
				listHotlines = query3.find();
				listCities = query4.find();
				listWebsites = query5.find();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (ParseObject hospital : listHospitals) {
				Clinic aClinic = new Clinic(hospital.getObjectId(),
						hospital.getString("cityID"),
						hospital.getString("name"),
						hospital.getString("address"),
						hospital.getString("hoursDetails"),
						hospital.getString("phone"),
						hospital.getString("extraDetails"),
						hospital.getBoolean("isConfidential"),
						hospital.getBoolean("isLowCost"),
						hospital.getBoolean("isOnlyReproductive"),
						hospital.getString("geoPoint"));
				db.createClinics(aClinic);
			}

			for (ParseObject city : listCities) {
				City aCity = new City(city.getObjectId(),
						city.getString("name"));
				db.createCities(aCity);
			}

			for (ParseObject category : listHotlineCategories) {
				Category aCategory = new Category(category.getObjectId(),
						category.getString("hotlineTitle"));

				db.createCategories(aCategory);
			}

			for (ParseObject hotline : listHotlines) {
				Hotline aHotline = new Hotline(hotline.getObjectId(),
						hotline.getString("cityID"),
						hotline.getString("hotlineTitleID"),
						hotline.getString("name"),
						hotline.getString("phoneNumber"),
						hotline.getString("extraDetails"));

				db.createHotlines(aHotline);
			}

			for (ParseObject website : listWebsites) {
				Website aWebsite = new Website(website.getObjectId(),
						website.getString("cityID"),
						website.getString("hotlineTitleID"),
						website.getString("name"), website.getString("website"));
				
				db.createWebsites(aWebsite);
			}

			globalVars.ran = false;
		}

		// we want to avoid adding additional objects to our global variables
		if (!globalVars.ran) {
			// we CAN NOT make the assumption that the system deletes the
			// variables after app shutdown
			globalVars.clear();
			globalVars.lCities.addAll(db.getCities());
			globalVars.lCategories.addAll(db.getHotlineCategories());
			//db.close();
			globalVars.cityNamesInflater();
			globalVars.categoryNamesInflater();

			globalVars.ran = true;
		}
		
		if(db.getRememberCity() == null){
			Intent intent = new Intent(getApplicationContext(), CitySelection.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			db.close();
			startActivity(intent);
			finish();
		} else {
			globalVars.lClinics.clear();
			globalVars.hospitalNames = null;
			globalVars.city_name = db.getRememberCity();
			globalVars.city_id = db.getCity(globalVars.city_name).getId();
			globalVars.lClinics.addAll(db.getCityClinics(globalVars.city_id));
			db.close();
			globalVars.hospitalNamesInflater();
			Intent intent = new Intent(getApplicationContext(), TabContainer.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(intent);
			finish();
		}
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
