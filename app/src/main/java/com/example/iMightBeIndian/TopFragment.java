package com.example.iMightBeIndian.PongOnParticlePhoton;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;


//Chronometer source http://abhiandroid.com/ui/chronometer


public class TopFragment extends android.support.v4.app.Fragment {
    TextView txtVS, txtPlayer1, txtPlayer2, testTxt;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, container, false);
        txtPlayer1= (TextView) view.findViewById(R.id.player1);
        txtPlayer2= (TextView) view.findViewById(R.id.player2);
        testTxt = (TextView) view.findViewById(R.id.testText);
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();






        if (bundle != null){
            txtPlayer1.setText(String.valueOf(intent.getStringExtra("playerOne")));
            txtPlayer2.setText(String.valueOf(bundle.getString("playerTwo")));

        } else {
            Log.d("Viktig", "Det skjedde");
            System.out.println("MMH !");
        }

        ((MainActivity)getActivity()).getAllPlayerNames()[0] = txtPlayer1.getText().toString();
        ((MainActivity)getActivity()).getAllPlayerNames()[1] = txtPlayer2.getText().toString();

        txtVS = (TextView)  view.findViewById(R.id.vs);

        Chronometer simpleChronometer = (Chronometer) view.findViewById(R.id.simpleChronometer); // initiate a chronometer
        simpleChronometer.setFormat("Time Running - %s"); // set the format for a chronometer
        simpleChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override

            public void onChronometerTick(Chronometer chronometer) {


            }

        });

        simpleChronometer.start();


        return view;
    }


    public TextView getTest() {


        return txtPlayer1;
    }
}