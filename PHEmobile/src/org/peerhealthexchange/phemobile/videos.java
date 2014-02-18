package org.peerhealthexchange.phemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class videos extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.videos);
		
		Button fitness = (Button) findViewById(R.id.fitness_button);
		Button health = (Button) findViewById(R.id.health_button);
		Button nutrition = (Button) findViewById(R.id.nutrition_button);
		Button alcoholDrugs = (Button) findViewById(R.id.alcoholAndDrugs_button);
		Button eatingDisorders = (Button) findViewById(R.id.eatingDisorder_button);
		Button glbt = (Button) findViewById(R.id.glbt_button);
	
	/*
	fitness.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), fitnessVideos.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});
	
	health.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), healthVideos.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});
	
	nutrition.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), nutritionVideos.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});
	
	alcoholDrugs.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), alcoholDrugsVideos.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});
	
	eatingDisorders.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), eatingDisordersVideos.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});
	
	glbt.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), glbt.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});
	
	*/
	}
}