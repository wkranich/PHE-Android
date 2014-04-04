package org.peerhealthexchange.phemobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HotlinesAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public HotlinesAdapter(Context context, String[] values) {
    super(context, R.layout.hotlines_layout, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.hotlines_layout, parent, false);
    Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/HelveticaNeue-Light.otf");
    TextView textView = (TextView) rowView.findViewById(R.id.textView1);
    textView.setTypeface(myTypeface);
    ImageView imageView2 = (ImageView) rowView.findViewById(R.id.imageView2);
    ImageView imageView3 = (ImageView) rowView.findViewById(R.id.imageView3);
    
    textView.setText(values[position]);
    
    BitmapFactory.Options myOptions = new BitmapFactory.Options();
    myOptions.inDither = true;
    myOptions.inScaled = false;
    myOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;// important
    myOptions.inPurgeable = true;

    //green color circle
    Bitmap.Config conf = Bitmap.Config.ARGB_8888;
    Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.parseColor("#3BB24D"));

    Canvas canvas = new Canvas(bmp);
    canvas.drawCircle(60, 50, 25, paint);

    imageView2.setAdjustViewBounds(true);
    imageView2.setImageBitmap(bmp);
    
    
    //pink color circle
    bmp = Bitmap.createBitmap(100, 100, conf);
    paint.setColor(Color.parseColor("#FA3475"));
    canvas = new Canvas(bmp);
    canvas.drawCircle(60, 50, 25, paint);
    imageView3.setAdjustViewBounds(true);
    imageView3.setImageBitmap(bmp);
    
    //yellow hex = #FDD52B
    

    //imageView2.setImageResource(R.drawable.common_signin_btn_icon_dark);
    //imageView3.setImageResource(R.drawable.common_signin_btn_icon_dark);

    return rowView;
  }
} 