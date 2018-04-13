package com.example.iMightBeIndian.PongOnParticlePhoton;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.Scanner;


public class GameLogic {


    int player1, player2;
     boolean player1win = false;
     boolean player2win = false;

    int[][] ticTacArray = new int[][]{
            {0, 0, 0,},
            {0, 0, 0,},
            {0, 0, 0,}
    };


    public GameLogic() {


        System.out.println(Arrays.deepToString(ticTacArray));


    }


    public void setNumber() {

        System.out.println("If player");
        Scanner keyboard = new Scanner(System.in);
        int answer = keyboard.nextInt();
    }


    public void setElement(int row, int column, int i) {

        ticTacArray[row][column] = i;
        System.out.println(Arrays.deepToString(ticTacArray));

    }

    public void checkRows() {


        for (int i = 0; i < 3; i++) {
            if (ifRowsTrue(ticTacArray[i][0], ticTacArray[i][1], ticTacArray[i][2]) && ticTacArray[i][0] == 1) {

                player1win = true;
                System.out.println("Player 1 wins on rows");

            } else if (ifRowsTrue(ticTacArray[i][0], ticTacArray[i][1], ticTacArray[i][2]) && ticTacArray[i][0] == 2) {

                player2win = true;
                System.out.println("Player 2 wins on rows");
            }

        }
    }

    public void checkColumns() {


        for (int i = 0; i < 3; i++) {
            if (ifRowsTrue(ticTacArray[0][i], ticTacArray[1][i], ticTacArray[2][i]) && ticTacArray[0][i] == 1) {

                player1win = true;
                System.out.println("Player 1 wins on columns");

            } else if (ifRowsTrue(ticTacArray[0][i], ticTacArray[1][i], ticTacArray[2][i]) && ticTacArray[0][i] == 2) {

                player2win = true;
                System.out.println("Player 2 wins on columns");
            }


        }
    }

    public void checkDiagonals() {

        if (ifRowsTrue(ticTacArray[0][0], ticTacArray[1][1], ticTacArray[2][2]) && ticTacArray[0][0] == 1 ||
                ifRowsTrue(ticTacArray[0][2], ticTacArray[1][1], ticTacArray[2][0]) && ticTacArray[0][2] == 1) {

            player1win = true;
            System.out.println("Player 1 wins on diagonals");

        } else if (ifRowsTrue(ticTacArray[0][0], ticTacArray[1][1], ticTacArray[2][2]) && ticTacArray[0][0] == 2 ||
                ifRowsTrue(ticTacArray[0][2], ticTacArray[1][1], ticTacArray[2][0]) && ticTacArray[0][2] == 2) {

            player2win = true;
            System.out.println("Player 2 wins on diagonals");

        }

    }

    public void checkVictory (){

        checkRows();
        checkColumns();
        checkDiagonals();
    }

    public void clearArray() {
        //clear rows
        for(int i = 0;  i < 3; i ++) {
            setElement(0,i,0);
            setElement(1,i,0);
            setElement(2,i,0);



        }
        // clear columns
        for(int i = 0; i < 3; i++) {
            setElement(i,0,0);
            setElement(i,1,0);
            setElement(i,2,0);



        }


    }


    public boolean ifRowsTrue(int a, int b, int c) {

        if  (a == b && b == c ) {

            return true;

        }
        return false;
    }



























































    public void teste() {

        if(ifRowsTrue(ticTacArray[0][0], ticTacArray[1][1], ticTacArray[2][2])) {

            System.out.println("yep");
        }
    }






























    public void newCheckRows() {


        boolean win = true;
        int rowWin = 0;
        int row = 0;

        while (win) {
            for (int i = 0; i < 3; i++) {
                if (ticTacArray[row][i] == 1) {

                    rowWin++;

                    if (rowWin == 3) {
                        System.out.println("Player 1  wins");
                        win = false;
                    }

                }

            }
            rowWin = 0;
            if (row < 2){
                row++;


            }

        }
    }
}
