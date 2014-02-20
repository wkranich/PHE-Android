package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class question_cards extends Activity {
	
	String Activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		Activity = intent.getStringExtra("activity");
		setContentView(R.layout.question_cards);
		
		ActionBar locationPage = getActionBar();
		locationPage.setTitle(Activity);

		Button answerButton = (Button) findViewById(R.id.answerButton);
		
	answerButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), answer_cards.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", Activity);
			startActivity(intent);
			
		}
	});
	}
}
