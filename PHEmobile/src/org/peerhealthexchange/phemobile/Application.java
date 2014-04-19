package org.peerhealthexchange.phemobile;

import org.peerhealthexchange.phemobile.objects.globalVars;

import com.parse.Parse;
import com.parse.PushService;

public class Application extends android.app.Application {
	
	//public static globalVars gVars = LoadingScreen.gVars;
	
	public Application() {

	}

	@Override
	public void onCreate() {
		super.onCreate();
		// Initialize the Parse SDK.
		Parse.initialize(this, "DYgXFCYiB9j2MTxqL4FvNscHYhFs4r9TkRZbCi35",
				"H8on7fpB4BcFlYvcQqQ7yjsqhSFQcPUjdqO4SYnu");
		// Specify an Activity to handle all pushes by default.
		PushService.setDefaultPushCallback(this, TabContainer.class);


	}

}