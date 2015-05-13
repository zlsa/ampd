package com.zlsadesign.ampd;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationDrawerAdapter {

  Context context;
  int layoutResourceId;

  String labels[];
  int icons[];

  private Typeface roboto_medium_typeface;

  public NavigationDrawerAdapter(Context context, int layoutResourceId, String[] labels, int[] icons) {
    this.layoutResourceId = layoutResourceId;
    this.context = context;

    this.labels = labels;
    this.icons = icons;

    roboto_medium_typeface = Typeface.createFromAsset(context.getAssets(), "fonts/roboto-medium.ttf");
  }

  public int getCount() {
    return labels.length;
  }

  public View getView(int position, ViewGroup parent) {

    ItemHolder holder;

    LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
    View row = inflater.inflate(layoutResourceId, parent, false);

    holder = new ItemHolder();
    holder.label = (TextView) row.findViewById(R.id.item_label);
    holder.icon = (ImageView) row.findViewById(R.id.item_icon);
    holder.position = position;

    holder.label.setText(labels[position]);
    holder.label.setTypeface(roboto_medium_typeface);
    holder.icon.setImageResource(icons[position]);

    return row;
  }

  static class ItemHolder {
    TextView label;
    ImageView icon;
    int position;
  }

}
