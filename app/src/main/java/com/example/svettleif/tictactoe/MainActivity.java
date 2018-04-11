package com.example.svettleif.tictactoe;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    String[] playerNames = new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFrags(R.id.fragmentbtn,new ButtonFragment(), false);
        replaceFrags(R.id.newFragment,new TopFragment(), false);



    }

    public void replaceFrags(int cont,Fragment fragment, boolean addBackTrack) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(cont, fragment, null);
            fragmentTransaction.commit();
        }




    public String getPlayerName(int i) {

        System.out.println(playerNames[0].toString());

        return playerNames[i];

    }

    public String[] getAllPlayerNames() {

        return playerNames;
    }


    }

