package org.peerhealthexchange.phemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CitySelection extends Activity implements OnClickListener{
	
	PHEdatabase db;
	Button bayOak,baySF,bostonMain,bostonOuter,chicago,laNorte,laNorth,laSouth,laSur,bronx,brooklyn,manhattan,queens,dc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_selection);
		
		getActionBar().setTitle("Locations");
		
		// creating the buttons
		bayOak = (Button) findViewById(R.id.bayOak);
		baySF = (Button) findViewById(R.id.baySF);
		bostonMain = (Button) findViewById(R.id.bostonMain);
		bostonOuter = (Button) findViewById(R.id.bostonOuter);
		chicago = (Button) findViewById(R.id.chicago);
		laNorte = (Button) findViewById(R.id.laNorte);
		laNorth = (Button) findViewById(R.id.laNorth);
		laSouth = (Button) findViewById(R.id.laSouth);
		laSur = (Button) findViewById(R.id.laSur);
		bronx = (Button) findViewById(R.id.bronx);
		brooklyn = (Button) findViewById(R.id.brooklyn);
		manhattan = (Button) findViewById(R.id.manhattan);
		queens = (Button) findViewById(R.id.queens);
		dc = (Button) findViewById(R.id.dc);
		
		// setting up the listeners
		bayOak.setOnClickListener(this);
		baySF.setOnClickListener(this);
		bostonMain.setOnClickListener(this);
		bostonOuter.setOnClickListener(this);
		chicago.setOnClickListener(this);
		laNorte.setOnClickListener(this);
		laNorth.setOnClickListener(this);
		laSouth.setOnClickListener(this);
		laSur.setOnClickListener(this);
		bronx.setOnClickListener(this);
		brooklyn.setOnClickListener(this);
		manhattan.setOnClickListener(this);
		queens.setOnClickListener(this);
		dc.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		db = new PHEdatabase(getApplicationContext());
		globalVars.lHospitals.clear();
		globalVars.hospitalNames = null;
		switch (v.getId()){
		case R.id.bayOak:
			globalVars.city_id = db.getCity(bayOak.getText().toString()).getId();
			break;
		case R.id.baySF:
			globalVars.city_id = db.getCity(baySF.getText().toString()).getId();
			break;
		case R.id.bostonMain:
			globalVars.city_id = db.getCity(bostonMain.getText().toString()).getId();
			break;
		case R.id.bostonOuter:
			globalVars.city_id = db.getCity(bostonOuter.getText().toString()).getId();
			break;
		case R.id.chicago:
			globalVars.city_id = db.getCity(chicago.getText().toString()).getId();
			break;
		case R.id.laNorte:
			globalVars.city_id = db.getCity(laNorte.getText().toString()).getId();
			break;
		case R.id.laNorth:
			globalVars.city_id = db.getCity(laNorth.getText().toString()).getId();
			break;
		case R.id.laSouth:
			globalVars.city_id = db.getCity(laSouth.getText().toString()).getId();
			break;
		case R.id.laSur:
			globalVars.city_id = db.getCity(laSur.getText().toString()).getId();
			break;
		case R.id.bronx:
			globalVars.city_id = db.getCity(bronx.getText().toString()).getId();
			break;
		case R.id.brooklyn:
			globalVars.city_id = db.getCity(brooklyn.getText().toString()).getId();
			break;
		case R.id.manhattan:
			globalVars.city_id = db.getCity(manhattan.getText().toString()).getId();
			break;
		case R.id.queens:
			globalVars.city_id = db.getCity(queens.getText().toString()).getId();
			break;
		case R.id.dc:
			globalVars.city_id = db.getCity(dc.getText().toString()).getId();
			break;
		}
		
		globalVars.lHospitals.addAll(db.getCityClinics(globalVars.city_id));
		
		db.close();
		globalVars.hospitalNamesInflater();
		Intent intent = new Intent(getApplicationContext(), StartUp.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		startActivity(intent);
	}
	
}
