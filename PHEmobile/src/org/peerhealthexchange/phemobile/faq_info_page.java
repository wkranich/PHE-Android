package org.peerhealthexchange.phemobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class faq_info_page extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.faq_info_page);
		
		TextView questionText = (TextView) findViewById(R.id.questionText);
		TextView answerText = (TextView) findViewById(R.id.answerText);
	}
}
