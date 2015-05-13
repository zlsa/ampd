package com.zlsadesign.ampd;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class NavigationDrawerListLayout extends LinearLayout {

  private String TAG = "FixedListView";

  private Context context;
  private NavigationDrawerAdapter adapter;
  private String prefix;

  public NavigationDrawerListLayout(Context context) {
    super(context);
    this.context = context;
    setOrientation(LinearLayout.VERTICAL);
  }

  public NavigationDrawerListLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    setOrientation(LinearLayout.VERTICAL);
  }

  public NavigationDrawerListLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.context = context;
    setOrientation(LinearLayout.VERTICAL);
  }

  public void setAdapter(NavigationDrawerAdapter adapter) {
    this.adapter = adapter;
    addItems();
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  private void addItems() {
    for(int i=0; i<adapter.getCount(); i++) {
      View row = adapter.getView(i, this);
      row.setClickable(true);
      final int finalI = i;
      row.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          ((MainActivity) context).onDrawerListItemClicked(prefix, finalI);
        }
      });
      this.addView(row, i);
      Log.d(TAG, "list view item " + i);
    }
  }

}