package com.example.svettleif.tictactoe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



public class CommentsDataSource   {

    static SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String [] allColumns = { SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_COMMENT};


    public CommentsDataSource (Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();

    }

    public void close () {
        dbHelper.close();
    }

    public Comment createComment (String comment) {

        Log.d("KOMMER DU HIT?: ", "TESTER");
        ContentValues  values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_COMMENT,comment);

        long insertId = database.insert(SQLiteHelper.TABLE_COMMENTS,null,values);

        Cursor cursor = database.query(
                SQLiteHelper.TABLE_COMMENTS, //tabellen som spørringen går mot
                allColumns, //kolonner
                SQLiteHelper.COLUMN_ID + " = " + insertId,  //kolonner for where, evt med faste paramtere
                null, //evt where paratere for parametrisk query
                null, //evt gruppering
                null, //evt filtrering på gruppering
                null); //sortering

        cursor.moveToFirst();
        Comment newComment = cursorToComment(cursor);
        cursor.close();
        return newComment;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }

    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<Comment>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_COMMENTS,allColumns,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Comment comment = cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }

        cursor.close();
        return comments;
    }

    public void deleteComment(long id) {
        database.delete(SQLiteHelper.TABLE_COMMENTS,
                SQLiteHelper.COLUMN_ID + " = " + id,
                null );
    }


}
