package com.example.androiddevelopment.actors.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.androiddevelopment.actors.R;
import com.example.androiddevelopment.actors.adapters.DrawerAdapter;
import com.example.androiddevelopment.actors.fragments.DetailFragment;
import com.example.androiddevelopment.actors.fragments.ListFragment;
import com.example.androiddevelopment.actors.models.NavigationItem;

import java.util.ArrayList;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0 && findViewById(R.id.fl_detail_view) == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ListFragment listFragment = new ListFragment();
                ft.replace(R.id.fl_list_view, listFragment, "List_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else if (position == 1) {
                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
            drawerList.setItemChecked(position, true);
            setTitle(drawerItems.get(position).getTitle());
            drawerLayout.closeDrawer(drawerPane);
        }
    }

    // Attributes used by NavigationDrawer
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private RelativeLayout drawerPane;
    private CharSequence drawerTitle;
    private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();


    boolean landscape = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.show();
        }

        //fragments
        if (savedInstanceState == null) {
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            ListFragment listFragment = new ListFragment();
            fragmentTransaction.add(R.id.fl_list_view, listFragment, "List_Fragment_1");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

        if (findViewById(R.id.fl_detail_view) != null) {
            landscape = true;
            getFragmentManager().popBackStack();

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.fl_detail_view);
            if (detailFragment == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.fl_detail_view, detailFragment, "Detail_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }

        //NavigationDrawer
        drawerItems.add(new NavigationItem(getString(R.string.nav_drawer_home), R.drawable.ic_nav_drawer_home));
        drawerItems.add(new NavigationItem(getString(R.string.nav_drawer_settings), R.drawable.ic_nav_drawer_settings));

        drawerTitle = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.lv_nav_drawer);

        drawerPane = (RelativeLayout) findViewById(R.id.nav_drawer);
        DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setAdapter(adapter);
        drawerToggle = new ActionBarDrawerToggle(
                this,                           //* host Activity
                drawerLayout,                   //* DrawerLayout object
                toolbar,                        //* nav drawer image to replace 'Up' caret
                R.string.nav_drawer_open,           //* "open drawer" description for accessibility
                R.string.nav_drawer_close           //* "close drawer" description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View draweView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }
        };

    }

    @Override
    public void onItemSelected(int position) {

    }
}
