package com.example.personalinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class Drawer_Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Initializing the Side Drawer Navigation View
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ExploreFragment()).commit();
            navigationView.setCheckedItem(R.id.draw_nav_dashboard);
        }

        //Initializing the Bottom Navigation View
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        //Method for opening the bottom navigation view
         bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();

                    if (itemId == R.id.explore_navigation) {
                        replaceFragment(new ExploreFragment());
                    } else if (itemId == R.id.likes_navigation) {
                        replaceFragment(new LikesFragment());
                    } else if (itemId == R.id.shop_navigation) {
                        replaceFragment(new ShopNowFragment());
                    }
                    return true;
             }
         });

    }



    //Method for opening the side drawer navigation view
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        NavigationView navigationView = findViewById(R.id.nav_view);

        if (itemId == R.id.draw_nav_dashboard) {
            replaceFragment(new ExploreFragment());
            bottomNavigationView.setVisibility(View.VISIBLE);

        } else if (itemId == R.id.draw_nav_account) {
            navigationView.setCheckedItem(R.id.draw_nav_account);
            replaceFragment(new MyAccountFragment());
            bottomNavigationView.setVisibility(View.GONE);

        }

        else if (itemId == R.id.draw_nav_settings) {
            replaceFragment(new SettingsFragment());
            bottomNavigationView.setVisibility(View.GONE);

        }
        else if (itemId == R.id.draw_nav_feedback) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Provide us your feedback!");

            final View customLayout = getLayoutInflater().inflate(R.layout.alert_dialog_layout, null);
            builder.setView(customLayout);

            builder.setPositiveButton("OK", (dialog, which) -> {
                EditText editText = customLayout.findViewById(R.id.editText);
                sendDialogDataToActivity(editText.getText().toString());
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }
        else if (itemId == R.id.draw_nav_logout){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to sign out?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Drawer_Navigation.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }









        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void sendDialogDataToActivity(String data) {
        Toast.makeText(this, "Feedback Submitted!", Toast.LENGTH_SHORT).show();
    }

    //method in replacing the fragment after selection
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }






}