package org.peerhealthexchange.phemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class faq extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faq);
		TextView healthText = (TextView) findViewById(R.id.healthText);
		TextView nutritionText = (TextView) findViewById(R.id.nutritionText);
		TextView eatingDisordersText = (TextView) findViewById(R.id.eatingDisordersText);
		TextView topicNameText = (TextView) findViewById(R.id.topicNameText);
		
		Button faq1Button = (Button) findViewById(R.id.faq1Button);
		Button faq2Button = (Button) findViewById(R.id.faq2Button);
		Button faq3Button = (Button) findViewById(R.id.faq3Button);
		Button faq4Button = (Button) findViewById(R.id.faq4Button);
		
		faq1Button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), faq_info_page.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				// TODO Auto-generated method stub

			}
		});
		
		faq2Button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), faq_info_page.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				// TODO Auto-generated method stub

			}
		});
		faq3Button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), faq_info_page.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				// TODO Auto-generated method stub

			}
		});
		faq4Button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), faq_info_page.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				// TODO Auto-generated method stub

			}
		});
	}
	
}
