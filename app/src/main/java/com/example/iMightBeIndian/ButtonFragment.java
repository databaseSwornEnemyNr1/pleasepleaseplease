package com.example.iMightBeIndian.PongOnParticlePhoton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;


public class ButtonFragment extends Fragment {

    public CommentsDataSource dataSource;
    private ListView lstComments;
    private ArrayAdapter<Comment> commentsAdapter;
    private List<Comment> alComments;
    private boolean AI = false;
    private boolean AImode = false;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    public static boolean playerTurn = true;
    public GameLogic logic = new GameLogic();
    // DbActivity activity;
    private CommentsDataSource commentsDataSource;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_fragment, container, false);
        //   activity = new DbActivity();
        btn1 = (Button) view.findViewById(R.id.button1);
        btn2 = (Button) view.findViewById(R.id.button2);
        btn3 = (Button) view.findViewById(R.id.button3);
        btn4 = (Button) view.findViewById(R.id.button4);
        btn5 = (Button) view.findViewById(R.id.button5);
        btn6 = (Button) view.findViewById(R.id.button6);
        btn7 = (Button) view.findViewById(R.id.button7);
        btn8 = (Button) view.findViewById(R.id.button8);
        btn9 = (Button) view.findViewById(R.id.button9);


        /*dataSource = new CommentsDataSource((DbActivity)getActivity());
        dataSource.open();
        alComments = dataSource.getAllComments();
        commentsAdapter = new ArrayAdapter<>((DbActivity)getActivity(),
                android.R.layout.simple_list_item_1, alComments);

        lstComments.setAdapter(commentsAdapter);

        lstComments = (ListView) view.findViewById(R.id.listView);

        String comments = "Sondre";
        Comment comment = dataSource.createComment(comments);
        alComments.add(comment);
        commentsAdapter.notifyDataSetChanged(); */


        onClick(btn1, 0, 0);
        onClick(btn2, 0, 1);
        onClick(btn3, 0, 2);
        onClick(btn4, 1, 0);
        onClick(btn5, 1, 1);
        onClick(btn6, 1, 2);
        onClick(btn7, 2, 0);
        onClick(btn8, 2, 1);
        onClick(btn9, 2, 2);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();


        if (bundle != null) {
            AImode = bundle.getBoolean("yep");
            AI = bundle.getBoolean("yep");
        }


        //    commentsDataSource = new CommentsDataSource(getActivity());


        System.out.println("yay");


        return view;
    }

    public void onClick(final Button btn, final int row, final int column) {
        btn.setOnClickListener(new View.OnClickListener() {

                                   public void onClick(View v) {
                                       if (!AI) {
                                           if (playerTurn == true || AImode && logic.ticTacArray[row][column] == 0) {
                                               btn.setBackgroundColor(Color.BLUE);
                                               playerTurn = false;
                                               logic.setElement(row, column, 1);
                                               btn.setText(":)");
                                               int s = logic.ticTacArray[row][column];
                                               Log.d(Integer.toString(s), "Eh ja");
                                               logic.checkVictory();
                                               toastIfVictory(logic.player1win, 0);
                                               if (AImode) {
                                                   AI = true;
                                               }
                                           } else if (!AImode || !AI && logic.ticTacArray[row][column] == 0) {
                                               btn.setBackgroundColor(Color.RED);
                                               playerTurn = true;
                                               logic.setElement(row, column, 2);
                                               btn.setText(":(");

                                               logic.checkVictory();
                                               toastIfVictory(logic.player2win, 1);

                                           }
                                       } else {

                                           System.out.println("SuperAiModeEntered");
                                           ((MainActivity) getActivity()).playerNames[1] = "AI";

                                           Random rndNum = new Random();
                                           int sRow;
                                           int sCol;

                                           Random rndBtn = new Random();
                                           boolean breakSwitch = false;
                                           while (!breakSwitch) {
                                               switch (rndBtn.nextInt(10)) {

                                                   case 1:
                                                       sRow = 0;
                                                       sCol = 0;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn1.setBackgroundColor(Color.RED);
                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       break;

                                                   case 2:
                                                       sRow = 0;
                                                       sCol = 1;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn2.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       break;

                                                   case 3:
                                                       sRow = 0;
                                                       sCol = 2;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn3.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       break;

                                                   case 4:

                                                       sRow = 1;
                                                       sCol = 0;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn4.setBackgroundColor(Color.RED);
                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       break;

                                                   case 5:
                                                       sRow = 1;
                                                       sCol = 1;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn5.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       break;

                                                   case 6:
                                                       sRow = 1;
                                                       sCol = 2;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn6.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       AI = false;
                                                       break;

                                                   case 7:
                                                       sRow = 2;
                                                       sCol = 0;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn7.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       AI = false;
                                                       break;

                                                   case 8:
                                                       sRow = 2;
                                                       sCol = 1;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn8.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       AI = false;
                                                       break;

                                                   case 9:
                                                       sRow = 2;
                                                       sCol = 2;
                                                       if (logic.ticTacArray[sRow][sCol] == 0) {
                                                           btn9.setBackgroundColor(Color.RED);

                                                           logic.setElement(sRow, sCol, 2);
                                                           AI = false;
                                                           breakSwitch = true;
                                                           break;
                                                       }
                                                       AI = false;
                                                       break;

                                               }

                                           }
                                       }
                                   }
                               }


        );


    }
public void toastIfVictory(boolean player, int i) {
    if (player == true) {
        System.out.println(" From buttons: Player " + (i + 1) + "" +  " wins");

        Context context = getActivity();
        String winningName = ((MainActivity) getActivity()).getPlayerName(i);
        CharSequence text = winningName + " WINS";


        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        logic.clearArray();
        System.out.println("Cleared?!" + Arrays.deepToString(logic.ticTacArray));
        btn1.setBackgroundResource(android.R.drawable.btn_default);
        btn2.setBackgroundResource(android.R.drawable.btn_default);
        btn3.setBackgroundResource(android.R.drawable.btn_default);
        btn4.setBackgroundResource(android.R.drawable.btn_default);
        btn5.setBackgroundResource(android.R.drawable.btn_default);
        btn6.setBackgroundResource(android.R.drawable.btn_default);
        btn7.setBackgroundResource(android.R.drawable.btn_default);
        btn8.setBackgroundResource(android.R.drawable.btn_default);
        btn9.setBackgroundResource(android.R.drawable.btn_default);
        logic.player1win = false;
        logic.player2win = false;


    }
}

}