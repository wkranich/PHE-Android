package org.peerhealthexchange.phemobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class discussion_board extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.discussion_board);
		Button postQuestion = (Button) findViewById(R.id.postButt);
		Button recentActivity = (Button) findViewById(R.id.recentButt);
		
	}
	
}
