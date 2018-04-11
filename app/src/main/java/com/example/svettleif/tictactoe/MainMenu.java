package com.example.svettleif.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Text;

public class MainMenu extends AppCompatActivity {

    TextView vs, enterNames;
    EditText player1, player2;
    Button btnStartgame, btnHighscores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);


      initWidgets();



      btnHighscores.setOnClickListener(new View.OnClickListener()
                                       {
                                           @Override
                                           public void onClick(View view) {
                                               Intent intent = new Intent(getApplicationContext(), DbActivity.class);
                                            startActivity(intent);
                                           }
                                       }




      );

        btnStartgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Log.d("player1", player1.getText().toString());
                // System.out.println(player1.getText());

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                

                if (!player1.getText().toString().isEmpty() && !player2.getText().toString().isEmpty()){

                    intent.putExtra("playerOne", player1.getText().toString());
                    intent.putExtra("playerTwo", player2.getText().toString());

                    startActivity(intent);



                }

            }



        });
    }





    public void initWidgets() {
        vs = (TextView) findViewById(R.id.vs);
        enterNames = (TextView) findViewById(R.id.enterNames);

        player1 = (EditText) findViewById(R.id.editName1);
        player2 = (EditText) findViewById(R.id.editName2);

        btnStartgame = (Button) findViewById(R.id.btnStartgame);
        btnHighscores = (Button) findViewById(R.id.btnHighscore);
    }
}


