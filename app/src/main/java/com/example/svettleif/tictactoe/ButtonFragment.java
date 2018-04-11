package com.example.svettleif.tictactoe;

import android.content.Context;
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
import java.util.List;

import javax.sql.DataSource;


public class ButtonFragment extends Fragment   {

    public CommentsDataSource dataSource;
    private ListView lstComments;
    private ArrayAdapter<Comment> commentsAdapter;
    private List<Comment> alComments;
    private boolean AI = false;

    private  Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    public static boolean playerTurn = true;
    public GameLogic logic =  new GameLogic();
    DbActivity activity;
    private CommentsDataSource commentsDataSource;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_fragment, container, false);
        activity = new DbActivity();
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

        commentsDataSource = new CommentsDataSource(getActivity());
        return view;
    }

    public void onClick (final Button btn, final int row, final int column){
        btn.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        if(!AI) {
                                            if (playerTurn == true) {
                                                btn.setBackgroundColor(Color.BLUE);
                                                playerTurn = false;
                                                logic.setElement(row, column, 1);
                                                btn.setText(":)");
                                                int s = logic.ticTacArray[row][column];
                                                Log.d(Integer.toString(s), "Eh ja");
                                                logic.checkVictory();
                                                if (logic.player1win == true) {


                                                    System.out.println("From buttons: Player 1 wins");
                                                    Context context = getActivity();
                                                    String winningName = ((MainActivity) getActivity()).getPlayerName(0);
                                                    CharSequence text = winningName + "WINS";

                                                    //    activity.createCommentFragment(winningName);
                                                    int duration = Toast.LENGTH_LONG;

                                                    Toast toast = Toast.makeText(context, text, duration);
                                                    toast.show();


                                                }

                                            } else {
                                                btn.setBackgroundColor(Color.RED);
                                                playerTurn = true;
                                                logic.setElement(row, column, 2);
                                                btn.setText(":(");

                                                logic.checkVictory();
                                                if (logic.player2win == true) {
                                                    System.out.println(" From buttons: Player 2 wins");

                                                    Context context = getActivity();
                                                    String winningName = ((MainActivity) getActivity()).getPlayerName(0);
                                                    CharSequence text = winningName + " WINS";

                                                    List<Comment> list = new ArrayList<>();
                                                    list = commentsDataSource.getAllComments();
                                                    for (int i = 0; i < list.size(); i++) {
                                                        System.out.println("MY LIST!!!: " + list.get(i));
                                                    }

                                                    commentsDataSource.createComment(winningName);


                                                    int duration = Toast.LENGTH_LONG;
                                                    Toast toast = Toast.makeText(context, text, duration);
                                                    toast.show();

                                                }

                                            }
                                        }else {
                                            ((MainActivity)getActivity()).playerNames[1] = "AI";
                                            logic.setElement(1, 1,2);















                                        }

                                    }
                                }
        );

    }




}