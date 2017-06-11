package com.bnr.dev.bnr;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bnr.dev.bnr.beat_box.BeatBoxFragment;
import com.bnr.dev.bnr.drag_and_draw.DragAndDrawFragment;

public class BNRActivity extends AppCompatActivity {

    // drawer
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private String[] mAppsTitles;
    // title
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;

    // ActionBar
    private ActionBar actionBar;


    // -----------------------------------
    //          Lifecycle
    // -----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnr);

        // ActionBar
        actionBar = getSupportActionBar();

        // Drawer: init
        mAppsTitles = getResources().getStringArray(R.array.drawer_menu_titles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) findViewById(R.id.drawer_list_view);

        // Drawer:adapter
        mDrawerListView.setAdapter(new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_activated_1, mAppsTitles));

        // Drawer: listener
        mDrawerListView.setOnItemClickListener(new DrawerItemClickListener());


        // Drawer: open/close
        mTitle = mDrawerTitle = getTitle();
        mDrawerToggle = new ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            R.string.drawer_open,
            R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                actionBar.setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                actionBar.setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    // -----------------------------------
    //          Drawer: listener
    // -----------------------------------
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        // new Fragment
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = BeatBoxFragment.newInstance();
                break;
            case 1:
                fragment = BeatBoxFragment.newInstance();
                break;
            case 2:
                fragment = BeatBoxFragment.newInstance();
                break;
            case 3:
                fragment = BeatBoxFragment.newInstance();
                break;
            case 4:
                fragment = BeatBoxFragment.newInstance();
                break;
            case 5:
                fragment = DragAndDrawFragment.newInstance();
                break;
            case 6:
                fragment = BeatBoxFragment.newInstance();
                break;
            case 7:
                fragment = BeatBoxFragment.newInstance();
                break;
            default:
                fragment = BeatBoxFragment.newInstance();
        }

        // Insert the fragment by replacing any existing fragment
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(null)
            .commit();


        // Drawer: update
        mDrawerListView.setItemChecked(position, true);
        setTitle(mAppsTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerListView);
    }

    // Lifecycle
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }


    // -----------------------------------
    //              Menu
    // -----------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        if (actionBar != null)
            actionBar.setTitle(mTitle);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}
