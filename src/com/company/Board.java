package com.company;

public class Board {
    int[] board = new int[9];

    public Board() {
        for(int i=0; i < board.length; i++){
            // no winner yet = -1
            board[i] = -1;
        }
    }

    public int checkWinner(){
        int winner;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != -1) {
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != -1){
            winner = board[6];
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
        }else if(board[2] == board[4] && board[6] == board[2] && board[2] != -1){
            winner = board[2];
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != -1){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != -1){
            winner = board[2];
        }
        else {
            winner = -1;
        }
        return winner;
    }

    public void printBoard(){
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("____________");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("____________");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public int getField(int num){
        return board[num];
    }
    public void setField(int num, int value){
        board[num] = value;
    }
}
