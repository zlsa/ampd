package com.zlsadesign.ampd;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class MainActivity extends AppCompatActivity {

  private Toolbar mToolbar;

  private DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle mDrawerToggle;

  private SlidingUpPanelLayout mNowPlayingLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    onCreateToolbar();
    onCreateDrawer();
    onCreateNowPlaying();

    ActionBar mActionBar = getSupportActionBar();

    if(mActionBar != null) {
      mActionBar.setDisplayHomeAsUpEnabled(true);
      mActionBar.setHomeButtonEnabled(true);
    }

  }

  private void onCreateToolbar() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
  }

  private void onCreateDrawer() {
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
            R.string.drawer_open, R.string.drawer_close) {

      public void onDrawerClosed(View view) {
        super.onDrawerClosed(view);
        invalidateOptionsMenu();
        super.onDrawerSlide(view, 0);
      }

      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        invalidateOptionsMenu();
      }

      @Override
      public void onDrawerSlide(View view, float slideOffset) {
        super.onDrawerSlide(view, 0);
      }

    };

    // Set the drawer toggle as the DrawerListener
    mDrawerLayout.setDrawerListener(mDrawerToggle);
  }

  private void onCreateNowPlaying() {
    mNowPlayingLayout = (SlidingUpPanelLayout) findViewById(R.id.now_playing_panel);

    // add a listener for the sliding panel (to lock the navigation drawer
    // when the now playing panel is visible)
    SlidingUpPanelLayout.PanelSlideListener panelListener;
    panelListener = new SlidingUpPanelLayout.PanelSlideListener() {

      @Override
      public void onPanelCollapsed(View v) {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
      }

      @Override
      public void onPanelExpanded(View v) {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
      }

      @Override
      public void onPanelHidden(View v) {
      }

      @Override
      public void onPanelSlide(View v, float f) {
      }

      @Override
      public void onPanelAnchored(View v) {
      }
    };

    mNowPlayingLayout.setPanelSlideListener(panelListener);

  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      openSettingsActivity();
    }

    return super.onOptionsItemSelected(item);
  }

  public void openSettingsActivity() {
    Intent intent = new Intent(this, SettingsActivity.class);
    startActivity(intent);
  }

}