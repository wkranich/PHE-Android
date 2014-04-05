package org.peerhealthexchange.phemobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HotlinesAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	private final String parentActivity;

	public HotlinesAdapter(Context context, String[] values,
			String parentActivity) {
		super(context, R.layout.hotlines_layout, values);
		this.context = context;
		this.values = values;
		this.parentActivity = parentActivity;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater
				.inflate(R.layout.hotlines_layout, parent, false);
		LinearLayout linear = (LinearLayout) rowView.findViewById(R.id.linearLayout2);
		Typeface myTypeface = Typeface.createFromAsset(context.getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		TextView textView = (TextView) rowView.findViewById(R.id.textView1);
		textView.setTypeface(myTypeface);
		ImageView imageView1 = (ImageView) rowView
				.findViewById(R.id.imageView1);
		ImageView imageView2 = (ImageView) rowView
				.findViewById(R.id.imageView2);
		ImageView imageView3 = (ImageView) rowView
				.findViewById(R.id.imageView3);

		textView.setText(values[position]);
		if (parentActivity == "hospitals") {
			BitmapFactory.Options myOptions = new BitmapFactory.Options();
			myOptions.inDither = true;
			myOptions.inScaled = false;
			myOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;// important
			myOptions.inPurgeable = true;

			Bitmap.Config conf = Bitmap.Config.ARGB_8888;

			if (globalVars.lHospitals.get(position).getLowCost()) {
				// green color circle
				Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
				Paint paint = new Paint();
				paint.setAntiAlias(true);
				paint.setColor(Color.parseColor("#3BB24D"));
				Canvas canvas = new Canvas(bmp);
				canvas.drawCircle(60, 50, 25, paint);
				imageView1.setAdjustViewBounds(true);
				imageView1.setImageBitmap(bmp);
			} else {
				imageView1.setImageResource(0);
			}

			if (globalVars.lHospitals.get(position).getConfidential()) {
				// yellow color circle
				Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
				Paint paint = new Paint();
				paint.setAntiAlias(true);
				paint.setColor(Color.parseColor("#FDD52B"));
				Canvas canvas = new Canvas(bmp);
				canvas.drawCircle(60, 50, 25, paint);
				imageView2.setAdjustViewBounds(true);
				imageView2.setImageBitmap(bmp);
			}
			else {
				imageView2.setImageResource(0);
			}

			if (globalVars.lHospitals.get(position).getReproductive()) {
				// pink color circle
				Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
				Paint paint = new Paint();
				paint.setAntiAlias(true);
				paint.setColor(Color.parseColor("#FA3475"));
				Canvas canvas = new Canvas(bmp);
				canvas.drawCircle(60, 50, 25, paint);
				imageView3.setAdjustViewBounds(true);
				imageView3.setImageBitmap(bmp);
			} else {
				imageView3.setImageResource(0);
			}

		} else if (this.parentActivity == "cities") {
			linear.setGravity(Gravity.CENTER);
			imageView1.setImageResource(android.R.color.transparent);
			imageView2.setImageResource(android.R.color.transparent);
			imageView3.setImageResource(android.R.color.transparent);
			
		} else {
			imageView1.setImageResource(android.R.color.transparent);
			imageView2.setImageResource(android.R.color.transparent);
			imageView3.setImageResource(android.R.color.transparent);
		}

		return rowView;
	}
}