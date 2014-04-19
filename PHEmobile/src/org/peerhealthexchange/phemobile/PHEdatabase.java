package org.peerhealthexchange.phemobile;

import java.util.ArrayList;
import java.util.List;

import org.peerhealthexchange.phemobile.objects.Category;
import org.peerhealthexchange.phemobile.objects.City;
import org.peerhealthexchange.phemobile.objects.Clinic;
import org.peerhealthexchange.phemobile.objects.Hotline;
import org.peerhealthexchange.phemobile.objects.Website;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PHEdatabase extends SQLiteOpenHelper {
	private static final String TABLE_CITIES = "cities";
	private static final String TABLE_CLINICS = "clinics";
	private static final String TABLE_CATEGORIES = "categories";
	private static final String TABLE_HOTLINES = "hotlines";
	private static final String TABLE_WEBSITES = "websites";
	private static final String TABLE_REMEMBERCITY = "remembered_city";

	private static final String DATABASE_NAME = "pheDatabase";
	private static final int DATABASE_VERSION = 1;

	// Common column names
	private static final String KEY_NUM = "num";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_CITY = "city_id";
	private static final String KEY_EXTRA = "extra_Details";
	private static final String KEY_PHONE = "phone";

	// CITIES Table - column names
	// welp they're common

	// CLINICS table - column names
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_HOURS = "hours";
	private static final String KEY_CONFIDENTIAL = "isConfidential";
	private static final String KEY_LOWCOST = "isLowCost";
	private static final String KEY_REPRODUCTIVE = "isOnlyReproductive";
	private static final String KEY_GEOPOINT = "geoPoint";

	// HOTLINES table - column names
	private static final String KEY_HOTLINE = "hotline_id";

	// WEBSITES table - column names
	private static final String KEY_WEBSITE = "website";

	// Cities table create statement
	private static final String CREATE_TABLE_CITIES = "CREATE TABLE "
			+ TABLE_CITIES + "(" + KEY_NUM + " INTEGER PRIMARY KEY," + KEY_ID
			+ " TEXT," + KEY_NAME + " TEXT" + ")";

	// Clinics table create statement
	private static final String CREATE_TABLE_CLINICS = "CREATE TABLE "
			+ TABLE_CLINICS + "(" + KEY_NUM + " INTEGER PRIMARY KEY," + KEY_ID
			+ " TEXT," + KEY_CITY + " TEXT," + KEY_NAME + " TEXT,"
			+ KEY_ADDRESS + " TEXT," + KEY_HOURS + " TEXT," + KEY_PHONE
			+ " TEXT," + KEY_EXTRA + " TEXT," + KEY_CONFIDENTIAL + " INTEGER,"
			+ KEY_LOWCOST + " INTEGER," + KEY_REPRODUCTIVE + " INTEGER,"
			+ KEY_GEOPOINT + " TEXT" + ")";

	// HOTLINECAT table create statement
	private static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE "
			+ TABLE_CATEGORIES + "(" + KEY_NUM + " INTEGER PRIMARY KEY,"
			+ KEY_ID + " TEXT," + KEY_NAME + " TEXT" + ")";

	// Hotlines table create statement
	private static final String CREATE_TABLE_HOTLINES = "CREATE TABLE "
			+ TABLE_HOTLINES + "(" + KEY_NUM + " INTEGER PRIMARY KEY," + KEY_ID
			+ " TEXT," + KEY_CITY + " TEXT," + KEY_HOTLINE + " TEXT,"
			+ KEY_NAME + " TEXT," + KEY_PHONE + " TEXT," + KEY_EXTRA + " TEXT"
			+ ")";

	// Websites table create statement
	private static final String CREATE_TABLE_WEBSITES = "CREATE TABLE "
			+ TABLE_WEBSITES + "(" + KEY_NUM + " INTEGER PRIMARY KEY," + KEY_ID
			+ " TEXT," + KEY_CITY + " TEXT," + KEY_HOTLINE + " TEXT,"
			+ KEY_NAME + " TEXT," + KEY_WEBSITE + " TEXT" + ")";

	// Remembered City table create statement
	private static final String CREATE_TABLE_REMEMBERED_CITY = "CREATE TABLE "
			+ TABLE_REMEMBERCITY + "(" + KEY_NUM + " INTEGER PRIMARY KEY,"
			+ KEY_NAME + " TEXT" + ")";

	public PHEdatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_CITIES);
		db.execSQL(CREATE_TABLE_CLINICS);
		db.execSQL(CREATE_TABLE_CATEGORIES);
		db.execSQL(CREATE_TABLE_HOTLINES);
		db.execSQL(CREATE_TABLE_WEBSITES);
		db.execSQL(CREATE_TABLE_REMEMBERED_CITY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLINICS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTLINES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEBSITES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMEMBERCITY);

		onCreate(db);
	}

	/*
	 * Functions related to cities
	 */
	public void createCities(City city) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, city.getId());
		values.put(KEY_NAME, city.getName());
		Log.d("cityId", city.getId());
		// insert row
		db.insert(TABLE_CITIES, null, values);
		db.close();
	}

	public City getCity(String city_name) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM " + TABLE_CITIES + " WHERE "
				+ KEY_NAME + " = " + "'" + city_name + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		if (c != null) {
			c.moveToFirst();
		}

		City city = new City(c.getString(c.getColumnIndex(KEY_ID)),
				c.getString(c.getColumnIndex(KEY_NAME)));

		return city;
	}

	public List<City> getCities() {
		List<City> cities = new ArrayList<City>();

		String selectQuery = "SELECT * FROM " + TABLE_CITIES;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				City city = new City();
				city.setId(c.getString(c.getColumnIndex(KEY_ID)));
				city.setName(c.getString(c.getColumnIndex(KEY_NAME)));

				cities.add(city);
			} while (c.moveToNext());
		}

		return cities;
	}

	/*
	 * Functions related to hospitals
	 */
	public void createClinics(Clinic clinic) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, clinic.getId());
		values.put(KEY_CITY, clinic.getCityId());
		values.put(KEY_NAME, clinic.getName());
		values.put(KEY_ADDRESS, clinic.getAddress());
		values.put(KEY_HOURS, clinic.getHours());
		values.put(KEY_PHONE, clinic.getPhone());
		values.put(KEY_EXTRA, clinic.getDetails());
		values.put(KEY_CONFIDENTIAL, (clinic.getConfidential()) ? 1 : 0);
		values.put(KEY_LOWCOST, (clinic.getLowCost()) ? 1 : 0);
		values.put(KEY_REPRODUCTIVE, (clinic.getReproductive()) ? 1 : 0);
		values.put(KEY_GEOPOINT, clinic.getGeoPoint());

		// insert row
		db.insert(TABLE_CLINICS, null, values);
		db.close();
	}

	public Clinic getClinic(String clinic_name) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM " + TABLE_CLINICS + " WHERE "
				+ KEY_NAME + " = " + "'" + clinic_name + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		if (c != null) {
			c.moveToFirst();
		}

		Clinic clinic = new Clinic();
		clinic.setId(c.getString(c.getColumnIndex(KEY_ID)));
		clinic.setCityId(c.getString(c.getColumnIndex(KEY_CITY)));
		clinic.setName(c.getString(c.getColumnIndex(KEY_NAME)));
		clinic.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
		clinic.setHours(c.getString(c.getColumnIndex(KEY_HOURS)));
		clinic.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));
		clinic.setDetails(c.getString(c.getColumnIndex(KEY_EXTRA)));
		clinic.setConfidential((c.getInt(c.getColumnIndex(KEY_CONFIDENTIAL)) == 1) ? true
				: false);
		clinic.setLowCost((c.getInt(c.getColumnIndex(KEY_LOWCOST)) == 1) ? true
				: false);
		clinic.setReproductive((c.getInt(c.getColumnIndex(KEY_REPRODUCTIVE)) == 1) ? true
				: false);
		clinic.setGeoPoint(c.getString(c.getColumnIndex(KEY_GEOPOINT)));
		return clinic;
	}

	public List<Clinic> getCityClinics(String city_id) {
		List<Clinic> cityClinics = new ArrayList<Clinic>();

		String selectQuery = "SELECT * FROM " + TABLE_CLINICS + " WHERE "
				+ KEY_CITY + " = " + "'" + city_id + "'";
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Clinic clinic = new Clinic();
				clinic.setId(c.getString(c.getColumnIndex(KEY_ID)));
				clinic.setCityId(c.getString(c.getColumnIndex(KEY_CITY)));
				clinic.setName(c.getString(c.getColumnIndex(KEY_NAME)));
				clinic.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
				clinic.setHours(c.getString(c.getColumnIndex(KEY_HOURS)));
				clinic.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));
				clinic.setDetails(c.getString(c.getColumnIndex(KEY_EXTRA)));
				clinic.setConfidential((c.getInt(c
						.getColumnIndex(KEY_CONFIDENTIAL)) == 1) ? true : false);
				clinic.setLowCost((c.getInt(c.getColumnIndex(KEY_LOWCOST)) == 1) ? true
						: false);
				clinic.setReproductive((c.getInt(c
						.getColumnIndex(KEY_REPRODUCTIVE)) == 1) ? true : false);
				clinic.setGeoPoint(c.getString(c.getColumnIndex(KEY_GEOPOINT)));

				cityClinics.add(clinic);
			} while (c.moveToNext());
		}

		return cityClinics;
	}

	/*
	 * Functions related to hotline categories
	 */

	public void createCategories(Category category) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, category.getId());
		values.put(KEY_NAME, category.getHotlineTitle());

		db.insert(TABLE_CATEGORIES, null, values);
		db.close();
	}

	public List<Category> getHotlineCategories() {
		List<Category> categories = new ArrayList<Category>();

		String selectQuery = "SELECT * FROM " + TABLE_CATEGORIES;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Category category = new Category();
				category.setId(c.getString(c.getColumnIndex(KEY_ID)));
				category.setName(c.getString(c.getColumnIndex(KEY_NAME)));

				categories.add(category);
			} while (c.moveToNext());
		}

		return categories;
	}

	/*
	 * Functions related to hotlines
	 */

	public void createHotlines(Hotline hotline) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, hotline.getId());
		values.put(KEY_CITY, hotline.getCityId());
		values.put(KEY_HOTLINE, hotline.getHotlineId());
		values.put(KEY_NAME, hotline.getName());
		values.put(KEY_PHONE, hotline.getPhoneNumber());
		values.put(KEY_EXTRA, hotline.getExtraDetails());

		db.insert(TABLE_HOTLINES, null, values);
		db.close();
	}

	public List<Hotline> getHotlines(String cityId, String hotlineCatId) {
		List<Hotline> hotlines = new ArrayList<Hotline>();
		String selectQuery = "SELECT * FROM " + TABLE_HOTLINES + " WHERE "
				+ KEY_CITY + " = " + "'" + cityId + "'" + " AND " + KEY_HOTLINE
				+ " = " + "'" + hotlineCatId + "'";
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Hotline hotline = new Hotline();
				hotline.setId(c.getString(c.getColumnIndex(KEY_ID)));
				hotline.setCityId(c.getString(c.getColumnIndex(KEY_CITY)));
				hotline.setHotlineTitleId(c.getString(c
						.getColumnIndex(KEY_HOTLINE)));
				hotline.setName(c.getString(c.getColumnIndex(KEY_NAME)));
				hotline.setPhoneNumber(c.getString(c.getColumnIndex(KEY_PHONE)));
				hotline.setExtraDetails(c.getString(c.getColumnIndex(KEY_EXTRA)));

				hotlines.add(hotline);
			} while (c.moveToNext());
		}

		return hotlines;
	}

	/*
	 * Functions related to websites
	 */

	public void createWebsites(Website website) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, website.getId());
		values.put(KEY_CITY, website.getCityId());
		values.put(KEY_HOTLINE, website.getHotlineId());
		values.put(KEY_NAME, website.getName());
		values.put(KEY_WEBSITE, website.getWebsite());

		db.insert(TABLE_WEBSITES, null, values);
		db.close();
	}

	public List<Website> getWebsites(String cityId, String hotlineCatId) {
		List<Website> websites = new ArrayList<Website>();
		String selectQuery = "SELECT * FROM " + TABLE_WEBSITES + " WHERE "
				+ KEY_CITY + " = " + "'" + cityId + "'" + " AND " + KEY_HOTLINE
				+ " = " + "'" + hotlineCatId + "'";
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {
				Website website = new Website();
				website.setId(c.getString(c.getColumnIndex(KEY_ID)));
				website.setCityId(c.getString(c.getColumnIndex(KEY_CITY)));
				website.setHotlineTitleId(c.getString(c
						.getColumnIndex(KEY_HOTLINE)));
				website.setName(c.getString(c.getColumnIndex(KEY_NAME)));
				website.setWebsite(c.getString(c.getColumnIndex(KEY_WEBSITE)));

				websites.add(website);
			} while (c.moveToNext());
		}

		return websites;
	}

	/*
	 * Functions related to Remembered City
	 */

	public void createRememberCity(String cityName) {
		SQLiteDatabase db = this.getWritableDatabase();

		// drop this particular table since the user wants another city to remember
		db.delete(TABLE_REMEMBERCITY, null, null);

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, cityName);

		db.insert(TABLE_REMEMBERCITY, null, values);
		db.close();
	}

	public String getRememberCity() {
		String selectQuery = "SELECT * FROM " + TABLE_REMEMBERCITY + " WHERE "
				+ KEY_NUM + " = " + 1;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.rawQuery(selectQuery, null);
		if (c != null && c.getCount() > 0) {
			c.moveToFirst();
		} else {
			return null;
		}

		return c.getString(c.getColumnIndex(KEY_NAME));
	}

	/*
	 * Miscellaneous functions
	 */
	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen()) {
			db.close();
		}
	}

	public boolean deleteDB(Context context) {
		return context.deleteDatabase(this.getDatabaseName());
	}

}
