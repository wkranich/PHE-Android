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

public class hotlines extends Activity {
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotlines);
		ActionBar locationPage = getActionBar();
		locationPage.setTitle("Hotlines");
		// Button postQuestion = (Button) findViewById(R.id.postButt);
		// Button recentActivity = (Button) findViewById(R.id.recentButt);

	}
}