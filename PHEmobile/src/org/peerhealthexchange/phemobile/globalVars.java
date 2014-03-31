package org.peerhealthexchange.phemobile;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class globalVars {
	public static List<Clinics> lHospitals = new ArrayList<Clinics>();
	public static List<HotlineCategories> lCategories = new ArrayList<HotlineCategories>();
	public static String[] hospitalNames;
	public static String[] categoryNames;

	public static void hospitalNamesInflater(List<Clinics> hosp) {
		hospitalNames = new String[lHospitals.size()];
		for (int i = 0; i < lHospitals.size(); i++) {
			Clinics hospital = lHospitals.get(i);
			hospitalNames[i] = hospital.getName();

		}
	}
	
	public static void categoryNamesInflater(List<HotlineCategories> cat){
		categoryNames = new String[lCategories.size()];
		for (int i = 0; i < lCategories.size(); i++) {
			HotlineCategories category = lCategories.get(i);
			categoryNames[i] = category.getHotlineTitle();
		}
	}
}
