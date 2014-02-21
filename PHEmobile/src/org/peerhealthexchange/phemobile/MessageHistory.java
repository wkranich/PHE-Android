package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MessageHistory extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar locationPage = getActionBar();
		locationPage.setTitle("Message History");
		setContentView(R.layout.message_history);
		
		TextView messageText1 = (TextView) findViewById(R.id.messageText1);
		TextView messageText2 = (TextView) findViewById(R.id.messageText2);
		TextView messageText3 = (TextView) findViewById(R.id.messageText3);
		TextView messageText4 = (TextView) findViewById(R.id.messageText4);
		
		messageText1.setText("No new messages!");
		messageText2.setText("No new messages!");
		messageText3.setText("No new messages!");
		messageText4.setText("No new messages!");
	}
}
