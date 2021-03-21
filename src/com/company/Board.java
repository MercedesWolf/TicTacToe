package com.company;

import java.util.Arrays;

public class Board {
    // y,x
    int[][] board = new int[3][];

    public Board() {
        for(int i=0; i < board.length; i++){
            board[i] = new int[3];

            // no winner yet = -1
            Arrays.fill(board[i], -1);
        }
    }

    public int checkWinner(){
        int winner = -1;

        for(int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != -1){
                winner = board[i][0];
            }
        }

        for (int i = 0; i < 3; i++){
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != -1) {
                winner = board[0][i];
            }
        }

        if (board[0][0] != -1) {
            boolean isWinner = true;
            for (int i = 1; i < 3; i++) {
                if (board[0][0] != board[i][i]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                winner = board[0][0];
            }
        }

        if (board[0][2] != -1) {
            boolean isWinner = true;
            for (int i = 1; i < 3; i++) {
                if (board[0][2] != board[i][2 - i]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                winner = board[0][2];
            }
        }

        return winner;
    }

    public void printBoard(){
        for(int i=0; i < 3; i++){
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);

            if(i != 2) {
                System.out.println("____________");
            }
        }
    }

    public int getField(Position position){
        return board[position.y][position.x];
    }

    public void setField(Position position, int value){
        board[position.y][position.x] = value;
    }
}
