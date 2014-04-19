package org.peerhealthexchange.phemobile.adapters;

import org.peerhealthexchange.phemobile.R;
import org.peerhealthexchange.phemobile.R.id;
import org.peerhealthexchange.phemobile.R.layout;
import org.peerhealthexchange.phemobile.objects.globalVars;

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

public class ListAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	private final String parentActivity;

	public ListAdapter(Context context, String[] values, String parentActivity) {
		super(context, R.layout.list_adapter_layout, values);
		this.context = context;
		this.values = values;
		this.parentActivity = parentActivity;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int px2 = 80;
		if (parentActivity != "hotlines") {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.list_adapter_layout,
					parent, false);
			LinearLayout linear = (LinearLayout) rowView
					.findViewById(R.id.linearLayout2);
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
			if (parentActivity == "hospitals") {
				BitmapFactory.Options myOptions = new BitmapFactory.Options();
				myOptions.inDither = true;
				myOptions.inScaled = false;
				myOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;// important
				myOptions.inPurgeable = true;

				Bitmap.Config conf = Bitmap.Config.ARGB_8888;

				if (globalVars.lClinics.get(position).getLowCost()) {
					// green color circle
					/*
					 * Bitmap bmp = Bitmap.createBitmap(100, 100, conf); Paint
					 * paint = new Paint(); paint.setAntiAlias(true);
					 * paint.setColor(Color.parseColor("#3BB24D")); Canvas
					 * canvas = new Canvas(bmp); canvas.drawCircle(60, 50, 25,
					 * paint); imageView1.setAdjustViewBounds(true);
					 */
					imageView1.setImageResource(R.drawable.ic_nonexpensive);
					// imageView1.setImageBitmap(bmp);
					imageView1.getLayoutParams().height = px2;
					imageView1.getLayoutParams().width = px2;
				} else {
					imageView1.setImageResource(R.drawable.ic_isexpensive);
					imageView1.getLayoutParams().height = px2;
					imageView1.getLayoutParams().width = px2;
				}
				if (globalVars.lClinics.get(position).getConfidential()) {
					// yellow color circle
					Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
					Paint paint = new Paint();
					paint.setAntiAlias(true);
					paint.setColor(Color.parseColor("#FDD52B"));
					Canvas canvas = new Canvas(bmp);
					canvas.drawCircle(60, 50, 25, paint);
					imageView2.setAdjustViewBounds(true);
					imageView2.setImageResource(R.drawable.ic_confidential);
					// imageView2.setImageBitmap(bmp);
					imageView2.getLayoutParams().height = px2;
					imageView2.getLayoutParams().width = px2;
				} else {
					imageView2.setImageResource(0);
				}

				if (globalVars.lClinics.get(position).getReproductive()) {
					// pink color circle
					Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
					Paint paint = new Paint();
					paint.setAntiAlias(true);
					paint.setColor(Color.parseColor("#FA3475"));
					Canvas canvas = new Canvas(bmp);
					canvas.drawCircle(60, 50, 25, paint);
					imageView3.setAdjustViewBounds(true);
					imageView3.setImageResource(R.drawable.ic_reproductive);
					// imageView3.setImageBitmap(bmp);
					imageView3.getLayoutParams().height = px2;
					imageView3.getLayoutParams().width = px2;
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
			textView.setText(values[position]);
			return rowView;

		} else {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.hotlines_adapter_layout,
					parent, false);
			LinearLayout linear = (LinearLayout) rowView
					.findViewById(R.id.linearLayout2);
			Typeface myTypefaceItalic = Typeface.createFromAsset(context.getAssets(),
					"fonts/HelveticaNeue-LightItalic.otf");
			Typeface myTypeface = Typeface.createFromAsset(context.getAssets(),
					"fonts/HelveticaNeue-Light.otf");
			TextView textView1 = (TextView) rowView
					.findViewById(R.id.textView1);
			TextView textView2 = (TextView) rowView
					.findViewById(R.id.textView2);
			textView1.setTypeface(myTypeface);
			textView2.setTypeface(myTypefaceItalic);
			textView1.setText(values[position]);
			ImageView imageView1 = (ImageView) rowView
					.findViewById(R.id.imageView1);
			imageView1.getLayoutParams().height = px2;
			imageView1.getLayoutParams().width = px2;
			if (position < globalVars.lHotlines.size()) {
				imageView1.setImageResource(R.drawable.ic_action_call);
				textView2.setText(globalVars.lHotlines.get(position).getExtraDetails());
			} else {
				imageView1.setImageResource(R.drawable.ic_action_web_site);
				textView2.setText(null);
				textView2.setTextSize(0f);
			}
			return rowView;

		}
	}
}