package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class faq extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		 View rootView = inflater.inflate(R.layout.faq, container, false);
		
		//ActionBar title = getActionBar();
		//title.setTitle("FAQs");
		
		TextView healthText = (TextView) getView().findViewById(R.id.healthText);
		TextView nutritionText = (TextView) getView().findViewById(R.id.nutritionText);
		TextView eatingDisordersText = (TextView) getView().findViewById(R.id.eatingDisordersText);
		TextView topicNameText = (TextView) getView().findViewById(R.id.topicNameText);
		
		Button faq1Button = (Button) getView().findViewById(R.id.faq1Button);
		Button faq2Button = (Button) getView().findViewById(R.id.faq2Button);
		Button faq3Button = (Button) getView().findViewById(R.id.faq3Button);
		Button faq4Button = (Button) getView().findViewById(R.id.faq4Button);
		
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
		return rootView;
	}
	
}
