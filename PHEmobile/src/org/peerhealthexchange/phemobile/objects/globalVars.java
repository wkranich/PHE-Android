package org.peerhealthexchange.phemobile.objects;

import java.util.ArrayList;
import java.util.List;


import android.util.Log;

// this will the container for our global variables

public class globalVars {
	public static String city_id; // id of the user selected city
	public static String city_name; // name of the user selected city
	public static String category_name; // name of the user selected hotline category
	public static int clinic_number; // number of the user selected clinic
	public static List<City> lCities = new ArrayList<City>();
	public static List<Clinic> lClinics = new ArrayList<Clinic>();
	public static List<Category> lCategories = new ArrayList<Category>();
	public static List<Hotline> lHotlines = new ArrayList<Hotline>();
	public static List<Website> lWebsites = new ArrayList<Website>();
	public static String[] cityNames;
	public static String[] hospitalNames;
	public static String[] categoryNames;
	public static String[] hotlineNames;
	public static String[] websiteNames;
	public static boolean ran = false;
	
	public globalVars() {
	}

	public static void cityNamesInflater() {
		cityNames = new String[lCities.size()];
		for (int i = 0; i < lCities.size(); i++) {
			cityNames[i] = lCities.get(i).getName();

		}
	}
	
	public static void hospitalNamesInflater() {
		hospitalNames = new String[lClinics.size()];
		for (int i = 0; i < lClinics.size(); i++) {
			Clinic hospital = lClinics.get(i);
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
		hotlineNames = new String[lHotlines.size() + lWebsites.size()];
		for (int i = 0; i < lHotlines.size(); i++) {
			Hotline hotline = lHotlines.get(i);
			hotlineNames[i] = hotline.getName();
		}
		
		for (int j = 0; j < lWebsites.size(); j++) {
			Website website = lWebsites.get(j);
			hotlineNames[lHotlines.size()+j] = website.getName();
		}
	}
	
	public static void websiteNamesInflater(){
		websiteNames = new String[lWebsites.size()];
		for (int i = 0; i < lWebsites.size(); i++) {
			Website website = lWebsites.get(i);
			websiteNames[i] = website.getName();
		}
	}
	
	public static void clear(){
		// clear everything in this class
		city_id = null;
		city_name = null;
		category_name = null;
		lCities.clear();
		lClinics.clear();
		lCategories.clear();
		lHotlines.clear();
		lWebsites.clear();
		cityNames = null;
		hospitalNames = null;
		categoryNames = null;
		hotlineNames = null;
		websiteNames = null;
	}
}
