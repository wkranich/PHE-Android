package org.peerhealthexchange.phemobile;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Messages extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		RelativeLayout mRelative = (RelativeLayout) inflater.inflate(R.layout.messages,container,false);
		//View rootView = inflater.inflate(R.layout.messages, container, false);
		// ActionBar locationPage = getActionBar();
		// locationPage.setTitle("Messages");

		TextView messageText = (TextView) mRelative.findViewById(
				R.id.messageText);
		Button shuffleButton = (Button) mRelative.findViewById(
				R.id.shuffleButton);
		Button historyButton = (Button) mRelative.findViewById(
				R.id.historyButton);

		messageText.setText("No new messages!");
		historyButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), MessageHistory.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		return mRelative;
	}
}
