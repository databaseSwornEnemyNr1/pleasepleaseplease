package com.example.iMightBeIndian.PongOnParticlePhoton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DbActivity extends AppCompatActivity {

    private CommentsDataSource dataSource;
    private ListView lstComments;
    private ArrayAdapter<Comment> commentsAdapter;
    private List<Comment> alComments;
    private String[] arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_activity);
//        alComments = new ArrayList<>();

        dataSource = new CommentsDataSource(this);
        dataSource.open();
        alComments = dataSource.getAllComments();


        initWidgets();
        initListView();

        /* Comment comment = (Comment) lstComments.getAdapter().getItem(0);
            dataSource.deleteComment(comment.getId());
            commentsAdapter.remove(comment); */


        String comments = "Sondre";
       Comment comment = dataSource.createComment(comments);
        alComments.add(comment);
        commentsAdapter.notifyDataSetChanged();





    }

    public void createCommentFragment(String playerWin) {




        Comment comment = dataSource.createComment(playerWin);
        alComments.add(comment);
        commentsAdapter.notifyDataSetChanged();
    }

    private void initListView() {
        commentsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alComments);

        lstComments.setAdapter(commentsAdapter);
    }

    private void initWidgets() {
        lstComments = (ListView) findViewById(R.id.listView);
     }

     public void testComment() {

        String [] comments = new String[]{"Nr 1", "Nr 2", "Nr 3"};
        int nextInt = new Random().nextInt(3);
        Comment comment = null;

         comment = dataSource.createComment(comments[nextInt]);
         alComments.add(comment);
         commentsAdapter.notifyDataSetChanged();

     }

    public void onClick(View view) {

        Comment comment = null;

        switch (view.getId()) {
            case R.id.add:
                String[] comments = new String[]{"Nr 1", "Nr 2", "Nr 3"};
                int nextInt = new Random().nextInt(3);

                comment = dataSource.createComment(comments[nextInt]);
                alComments.add(comment);
                commentsAdapter.notifyDataSetChanged();

                break;

          /*      case R.id.delete:
                //Kan brukes om man ønsker å logge til konsoll alle lagrede kommentarer
                logComments();
                //Fjerner den første kommentaren
                comment = (Comment) lstComments.getAdapter().getItem(0);
                dataSource.deleteComment(comment.getId());
                commentsAdapter.remove(comment);
                break;
        */

           // commentsAdapter.notifyDataSetChanged();
        }
    }

    private void logComments() {
        List<Comment> comments = dataSource.getAllComments();
        for(Comment comment : comments) {
            Log.w(DbActivity.class.getName(), "Comments stored: " + comment);
        }
    }

    //livsløpmetdoer for å håndtere database-syklus
    @Override
    protected void onResume() {
        super.onResume();
        dataSource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    protected void onDestroy() {
        dataSource.close();
        super.onDestroy();
    }
}
