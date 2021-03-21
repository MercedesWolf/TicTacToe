package com.company;

public class Board {
    // y,x
    int[][] board = new int[3][];

    public Board() {
        for(int i=0; i < board.length; i++){
            board[i] = new int[3];

            for(int j=0; j < board[i].length; j++){
                // no winner yet = -1
                board[i][j] = -1;
            }
        }
    }

    public int checkWinner(){
        int winner;

        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != -1){
            winner = board[0][0];
        }
        else if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != -1) {
            winner = board[1][0];
        }
        else if(board[2][0] == board[2][2] && board[2][0] == board[2][2] && board[2][0] != -1) {
            winner = board[2][0];
        }

        else if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != -1) {
            winner = board[0][0];
        }
        else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != -1){
            winner = board[0][1];
        }
        else if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != -1){
            winner = board[0][2];
        }

        else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != -1){
            winner = board[0][0];
        }
        else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != -1){
            winner = board[0][2];
        }

        else {
            winner = -1;
        }
        return winner;
    }

    public void printBoard(){
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("____________");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("____________");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public int getField(Position position){
        return board[position.y][position.x];
    }

    public void setField(Position position, int value){
        board[position.y][position.x] = value;
    }
}
