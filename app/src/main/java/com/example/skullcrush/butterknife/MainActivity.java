package com.example.skullcrush.butterknife;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        database = Room.databaseBuilder(getApplicationContext(),Database.class,"userdb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment)!= null){
            if(savedInstanceState!= null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragment,new Home()).commit();
        }


    }

}
