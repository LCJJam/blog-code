package com.example.project_smb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Notification;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;

    Home homeFragment = new Home();
    Notification notificationFragment = new Notification();
    Dashboard dashboardFragment = new Dashboard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        fragmentTransaction.replace(R.id.frameLayout,homeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_dashboard:
                        fragmentTransaction.replace(R.id.frameLayout,dashboardFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_notifications:
                        fragmentTransaction.replace(R.id.frameLayout,notificationFragment).commitAllowingStateLoss();
                        break;
                }
                return false;
            }
        });
    }

}

