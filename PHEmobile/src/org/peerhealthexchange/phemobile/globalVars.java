package org.peerhealthexchange.phemobile;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class globalVars {
	public static String city_id;
	public static List<Clinics> lHospitals = new ArrayList<Clinics>();
	public static List<HotlineCategories> lCategories = new ArrayList<HotlineCategories>();
	public static List<HotlinesInfo> lHotlines = new ArrayList<HotlinesInfo>();
	public static String[] hospitalNames;
	public static String[] categoryNames;
	public static String[] hotlineNames;
	public static boolean ran = false;

	public static void hospitalNamesInflater() {
		hospitalNames = new String[lHospitals.size()];
		for (int i = 0; i < lHospitals.size(); i++) {
			Clinics hospital = lHospitals.get(i);
			hospitalNames[i] = hospital.getName();

		}
	}
	
	public static void categoryNamesInflater(){
		categoryNames = new String[lCategories.size()];
		for (int i = 0; i < lCategories.size(); i++) {
			HotlineCategories category = lCategories.get(i);
			categoryNames[i] = category.getHotlineTitle();
		}
	}
	
	public static void hotlineNamesInflater(){
		hotlineNames = new String[lHotlines.size()];
		for (int i = 0; i < lHotlines.size(); i++) {
			HotlinesInfo hotline = lHotlines.get(i);
			hotlineNames[i] = hotline.getName();
		}
	}
}
