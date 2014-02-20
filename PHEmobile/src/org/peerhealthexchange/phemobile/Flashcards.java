package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flashcards extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flashcards);
		
		ActionBar locationPage = getActionBar();
		locationPage.setTitle("Flashcards");
		
		final Button alcAndDrugsButton = (Button) findViewById(R.id.alcAndDrugsButton);
		final Button eatingDisordersButton = (Button) findViewById(R.id.eatingDisordersButton);
		final Button glbtButton = (Button) findViewById(R.id.glbtButton);
		final Button nutrAndFitButton = (Button) findViewById(R.id.nutrAndFitButton);
		final Button sexButton = (Button) findViewById(R.id.sexButton);
		
		
	
	
	alcAndDrugsButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), question_cards.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", alcAndDrugsButton.getText());
			startActivity(intent);
		}
	});
	
	eatingDisordersButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), question_cards.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", eatingDisordersButton.getText());
			startActivity(intent);
		}
	});
	
	glbtButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), question_cards.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", glbtButton.getText());
			startActivity(intent);
		}
	});
	
	nutrAndFitButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), question_cards.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", nutrAndFitButton.getText());
			startActivity(intent);
		}
	});
	
	sexButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), question_cards.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", sexButton.getText());
			startActivity(intent);
		}
	});
	}

}
