package org.techtown.animalunteer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    //MapFragment map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*map = new MapFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, map).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, map).commit();
                        return true;
                }
                return false;
            }
        }); */

    }
}