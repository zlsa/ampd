package com.zlsadesign.ampd;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_settings);

    // add back button
    ActionBar ab = getSupportActionBar();
    if(ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
    }

    // add settings fragment
    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(android.R.id.content, new SettingsFragment()).commit();
  }
}
