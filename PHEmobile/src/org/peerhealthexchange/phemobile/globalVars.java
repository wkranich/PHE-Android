package org.peerhealthexchange.phemobile;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class globalVars {
	public static final ArrayList<hospitals> lHospitals = new ArrayList<hospitals>();
	public static String[] hospitalNames;
	
	public static void hospitalNamesInflater(List<hospitals> hosp) {
		hospitalNames = new String[globalVars.lHospitals.size()];
		Log.d("wat","hi");
		for(int i = 0; i < globalVars.lHospitals.size(); i++) {
			hospitals hospital = globalVars.lHospitals.get(i);
			hospitalNames[i] = hospital.getName();
			
		}
	}
}
