package com.example.meridianjobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EmployerHomePg extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_home_pg);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.profile:
                        fragment = new FirstFragment();
                        break;
                    case R.id.add:
                        fragment = new SecondFragment();
                        break;
                    case R.id.notf:
                        fragment = new SecondFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bottomNavigationView, fragment).commit();
                return true;
            }
        });
    }
}

