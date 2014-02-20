package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class discussion_board extends Activity {
	SearchView searchView; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discussion_board);
		ActionBar locationPage = getActionBar();
		locationPage.setTitle("Discussion Board");
		// Button postQuestion = (Button) findViewById(R.id.postButt);
		// Button recentActivity = (Button) findViewById(R.id.recentButt);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.discussion_board, menu);

		final MenuItem searchMenuItem = menu.findItem(R.id.search);

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		searchView = (SearchView) menu.findItem(R.id.search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));

		searchView.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					searchView.clearFocus();
					searchView.setQuery("", false);
					searchMenuItem.collapseActionView();
					searchView.setFocusable(false);
					invalidateOptionsMenu();
				}

			}
		});

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.newPost:
			Intent intent = new Intent(getApplicationContext(), new_post.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}

		return true;
	}
	
	@Override
	public void onBackPressed() {
	    if (!searchView.isIconified()) {
	        searchView.setIconified(true);
	    } else {
	        super.onBackPressed();
	    }
	}

}
