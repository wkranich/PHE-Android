package org.peerhealthexchange.phemobile.slidingmenu.adapter;

import org.peerhealthexchange.phemobile.hospitalsMap;
import org.peerhealthexchange.phemobile.location;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// do nothing
	}

	@Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new hospitalsMap();
        case 1:
            // Games fragment activity
            return new hospitalsMap();
        }
 
        return null;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}
