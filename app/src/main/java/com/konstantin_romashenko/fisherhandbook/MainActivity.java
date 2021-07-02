package com.konstantin_romashenko.fisherhandbook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.MenuItem;
import android.content.Intent;
import com.google.android.material.navigation.NavigationView.*;
import java.util.Arrays;
import android.widget.ListView;
import com.google.android.material.navigation.NavigationView;
import com.konstantin_romashenko.fisherhandbook.settings.SettingsActivity;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {
    private ListView list;
    private String[] str_arr;
    private ArrayAdapter<String> str_adapter;
    private Toolbar toolbar;
    private int category_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        str_arr = getResources().getStringArray(R.array.fish_array);
        str_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(str_arr)));
        list.setAdapter(str_adapter);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_fish);

        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_fish)
        {
            fillArray(R.string.menu_fish, R.array.fish_array, 0);
        }
        if (id == R.id.nav_bait)
        {
            fillArray(R.string.menu_bait, R.array.bait_array, 1);
        }
        if (id == R.id.nav_tackle)
        {
            fillArray(R.string.menu_tackle, R.array.tackle_array, 2);
        }
        if (id == R.id.nav_lure)
        {
            fillArray(R.string.menu_lure, R.array.lure_array, 3);
        }
        if(id == R.id.nav_stories)
        {
            fillArray(R.string.menu_stories, R.array.stories_array, 4);
        }
        if(id == R.id.nav_advices)
        {
            fillArray(R.string.menu_advices, R.array.advices_array, 5);
        }

        NavigationView navigationView = findViewById(R.id.nav_view);

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    private void fillArray(int title, int arrayList, int index)
    {
        str_arr = getResources().getStringArray(arrayList);
        str_adapter.clear();
        str_adapter.addAll(str_arr);
        str_adapter.notifyDataSetChanged();
        toolbar.setTitle(title);
        category_index = index;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
        intent.putExtra("category", category_index);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
