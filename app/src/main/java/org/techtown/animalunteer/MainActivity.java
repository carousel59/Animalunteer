package org.techtown.animalunteer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements OnButtonSelectedListener{
    private static final String TAG = "MainActivity";

    MapFragment mapFragment;
    InformFragment informFragment;
    RecruitFragment recruitFragment;
    MemoFragment memoFragment;

    public static MemoDatabase mDatabase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fragment
        mapFragment = new MapFragment();
        informFragment = new InformFragment();
        recruitFragment = new RecruitFragment();
        memoFragment = new MemoFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                        return true;
                    case R.id.information:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, informFragment).commit();
                        return true;
                    case R.id.volunteer:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, recruitFragment).commit();
                        return true;
                }
                return false;
            }
        });

        openDatabase();
    }

    public void onButtonSelected(int position){
        if (position == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, recruitFragment).commit();
        } else if (position == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, memoFragment).commit();
        }
    }

    public void showMemoFragment(Memo item) {
        memoFragment = new MemoFragment();
        memoFragment.setItem(item);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, memoFragment).commit();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mDatabase != null){
            mDatabase.close();
            mDatabase = null;
        }
    }

    public void openDatabase(){
        if(mDatabase != null){
            mDatabase.close();
            mDatabase = null;
        }
        mDatabase = MemoDatabase.getInstance(this);
        boolean isOpen = mDatabase.open();
        if(isOpen){
            Log.d(TAG, "Memo database is open.");
        } else{
            Log.d(TAG, "Memo database is not open.");
        }
    }
}