package org.peerhealthexchange.phemobile;

import java.util.ArrayList;

import org.peerhealthexchange.phemobile.slidingmenu.adapter.NavDrawerListAdapter;
import org.peerhealthexchange.phemobile.slidingmenu.model.NavDrawerItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class StartUp extends Activity {
	
	
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		setContentView(R.layout.start_up_page);
		Parse.initialize(this,"DYgXFCYiB9j2MTxqL4FvNscHYhFs4r9TkRZbCi35", "H8on7fpB4BcFlYvcQqQ7yjsqhSFQcPUjdqO4SYnu");
		PushService.setDefaultPushCallback(this,TeacherStartUp.class);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
		Button student_start = (Button) findViewById(R.id.student_button);
		Button teacher_login = (Button) findViewById(R.id.teacher_button);

		student_start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), StudentStartUp.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				// TODO Auto-generated method stub

			}
		});
		// Teacher button disabled for time being.
		teacher_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), teacher_login.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				// TODO Auto-generated method stub

			}
		});
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_up, menu);
		return true;
	}*/

}
