package org.peerhealthexchange.phemobile;

import android.content.Context;
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
    

    imageView2.setImageResource(R.drawable.common_signin_btn_icon_dark);
    imageView3.setImageResource(R.drawable.common_signin_btn_icon_dark);

    return rowView;
  }
} 