package org.peerhealthexchange.phemobile;

import com.parse.ParseObject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class teacher_login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar locationPage = getActionBar();
		locationPage.setTitle("Teacher Login");
		setContentView(R.layout.teacher_login);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
		
		/*
		// text boxes
		EditText username = (EditText) findViewById(R.id.userNameBox);
		EditText password = (EditText) findViewById(R.id.passBox);
		
		// correct info for test
		ParseObject loginTest = new ParseObject("login");
		loginTest.put("login", "algrice");
		loginTest.put("password", "12345");
		loginTest.saveInBackground();
		
		// info collected from user
		ParseObject loginInfo = new ParseObject("login");
		loginInfo.put("login", username.getText().toString());
		loginInfo.put("password", password.getText().toString());
		loginInfo.saveInBackground();
		*/
		
		Button login = (Button) findViewById(R.id.loginButt);
		

		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), TeacherStartUp.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
			
		});
	}

}
