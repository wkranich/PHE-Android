package org.peerhealthexchange.phemobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PHEdatabase extends SQLiteOpenHelper {

	private static final String TABLE_CITIES = "cities";
	private static final String TABLE_CLINICS = "clinics";
	private static final String TABLE_CATEGORIES = "categories";
	private static final String TABLE_HOTLINES = "hotlines";

	private static final String DATABASE_NAME = "pheDatabase";
	private static final int DATABASE_VERSION = 1;

	// Common column names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_CITY = "city_id";
	private static final String KEY_EXTRA = "extra_Details";
	private static final String KEY_PHONE = "phone";
	// private static final String KEY_CREATED_AT = "created_at";

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

	// Cities table create statement
	private static final String CREATE_TABLE_CITIES = "CREATE TABLE "
			+ TABLE_CITIES + "(" + KEY_ID + " STRING PRIMARY KEY," + KEY_NAME
			+ " TEXT" + ")";

	// Clinics table create statement
	private static final String CREATE_TABLE_CLINICS = "CREATE TABLE "
			+ TABLE_CLINICS + "(" + KEY_ID + " STRING PRIMARY KEY," + KEY_NAME
			+ " TEXT," + KEY_ADDRESS + " TEXT," + KEY_HOURS + " TEXT,"
			+ KEY_PHONE + " TEXT," + KEY_EXTRA + " TEXT," + KEY_CONFIDENTIAL
			+ " INTEGER," + KEY_LOWCOST + " INTEGER," + KEY_REPRODUCTIVE
			+ " INTEGER," + KEY_GEOPOINT + " TEXT" + ")";

	// HOTLINECAT table create statement
	private static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE "
			+ TABLE_CATEGORIES + "(" + KEY_ID + " STRING PRIMARY KEY,"
			+ KEY_NAME + " TEXT" + ")";

	// Hotlines table create statement
	private static final String CREATE_TABLE_HOTLINES = "CREATE TABLE "
			+ TABLE_HOTLINES + "(" + KEY_ID + " STRING PRIMARY KEY," + KEY_CITY
			+ " TEXT," + KEY_HOTLINE + " TEXT," + KEY_NAME + " TEXT,"
			+ KEY_PHONE + " TEXT," + KEY_EXTRA + " TEXT" + ")";

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
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLINICS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTLINES);
		
		onCreate(db);
	}

	
	public Long createCities(Cities city, Long[] city_ids){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ID, city.getId());
		values.put(KEY_NAME, city.getName());
		
		// insert row
		Long city_id = db.insert(TABLE_CITIES, null, values);
		return city_id;
	}
}
