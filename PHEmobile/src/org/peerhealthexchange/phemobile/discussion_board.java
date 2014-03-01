package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;

public class discussion_board extends Fragment {
	SearchView searchView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ScrollView mRelative = (ScrollView) inflater.inflate(
				R.layout.discussion_board, container, false);

		ActionBar locationPage = getActivity().getActionBar();
		locationPage.setTitle("Discussion Board");
		setHasOptionsMenu(true);
		// Button postQuestion = (Button) mRelative.findViewById(R.id.postButt);
		// Button recentActivity = (Button)
		// mRelative.findViewById(R.id.recentButt);
		return mRelative;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		//MenuInflater inflater = getActivity().getMenuInflater();
		super.onCreateOptionsMenu(menu, inflater);
		//menu.clear();
		inflater.inflate(R.menu.discussion_board, menu);
		
		final MenuItem searchMenuItem = menu.findItem(R.id.search);

		SearchManager searchManager = (SearchManager) getActivity()
				.getSystemService(Context.SEARCH_SERVICE);
		searchView = (SearchView) menu.findItem(R.id.search).getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getActivity().getComponentName()));

		searchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					searchView.clearFocus();
					searchView.setQuery("", false);
					searchMenuItem.collapseActionView();
					searchView.setFocusable(false);
					getActivity().invalidateOptionsMenu();
				}

			}
		});

		//return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.newPost:
			Intent intent = new Intent(getActivity(), new_post.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}

		return true;
	}

	/*
	 * @Override public void onBackPressed() { if (!searchView.isIconified()) {
	 * searchView.setIconified(true); } else { super.onBackPressed(); } }
	 */

}
