package org.peerhealthexchange.phemobile.objects;

import java.util.ArrayList;
import java.util.List;


import android.util.Log;

// this will the container for our global variables

public class globalVars {
	public static String city_id;
	public static String city_name;
	public static List<City> lCities = new ArrayList<City>();
	public static List<Clinic> lHospitals = new ArrayList<Clinic>();
	public static List<Category> lCategories = new ArrayList<Category>();
	public static List<Hotline> lHotlines = new ArrayList<Hotline>();
	public static String[] cityNames;
	public static String[] hospitalNames;
	public static String[] categoryNames;
	public static String[] hotlineNames;
	public static boolean ran = false;

	public static void cityNamesInflater() {
		cityNames = new String[lCities.size()];
		for (int i = 0; i < lCities.size(); i++) {
			cityNames[i] = lCities.get(i).getName();

		}
	}
	
	public static void hospitalNamesInflater() {
		hospitalNames = new String[lHospitals.size()];
		for (int i = 0; i < lHospitals.size(); i++) {
			Clinic hospital = lHospitals.get(i);
			hospitalNames[i] = hospital.getName();

		}
	}
	
	public static void categoryNamesInflater(){
		categoryNames = new String[lCategories.size()];
		for (int i = 0; i < lCategories.size(); i++) {
			Category category = lCategories.get(i);
			categoryNames[i] = category.getHotlineTitle();
		}
	}
	
	public static void hotlineNamesInflater(){
		hotlineNames = new String[lHotlines.size()];
		for (int i = 0; i < lHotlines.size(); i++) {
			Hotline hotline = lHotlines.get(i);
			hotlineNames[i] = hotline.getName();
		}
	}
}
