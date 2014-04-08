package org.peerhealthexchange.phemobile.adapters;

import org.peerhealthexchange.phemobile.HospitalListFrag;
import org.peerhealthexchange.phemobile.CategoryListFrag;

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
            return new HospitalListFrag();
        case 1:
            // Games fragment activity
            return new CategoryListFrag();
        }
 
        return null;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}
