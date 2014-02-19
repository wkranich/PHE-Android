package org.peerhealthexchange.phemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Messages extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.messages);
		
		TextView messageText = (TextView) findViewById(R.id.messageText);
		Button shuffleButton = (Button) findViewById(R.id.shuffleButton);
		Button historyButton = (Button) findViewById(R.id.historyButton);
		
		messageText.setText("No new messages!");
	/*historyButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), History.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	});*/
	}
}
