package com.company;

import java.util.Arrays;

public class Board {
    public int boardSize;

    // y,x
    private final int[][] board;

    public Board(int boardSize) {
        this.boardSize = boardSize;

        board = new int[boardSize][];

        for(int i=0; i < board.length; i++){
            board[i] = new int[boardSize];

            // no winner yet = -1
            Arrays.fill(board[i], -1);
        }
    }

    public int checkWinner(){
        int winner = -1;

        for(int i = 0; i < boardSize; i++){
            if(board[i][0] != -1) {
                boolean isWinner = true;

                for(int j = 1; j < boardSize; j++) {
                    if(board[i][j] != board[i][0]) {
                        isWinner = false;
                        break;
                    }
                }

                if (isWinner) {
                    winner = board[i][0];
                    return winner;
                }
            }

            if(board[0][i] != -1) {
                boolean isWinner = true;

                for(int j = 1; j < boardSize; j++) {
                    if(board[j][i] != board[0][i]) {
                        isWinner = false;
                        break;
                    }
                }

                if (isWinner) {
                    winner = board[0][i];
                    return winner;
                }
            }
        }

        if (board[0][0] != -1) {
            boolean isWinner = true;
            for (int i = 1; i < boardSize; i++) {
                if (board[0][0] != board[i][i]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                winner = board[0][0];
            }
        }

        if (board[0][boardSize - 1] != -1) {
            boolean isWinner = true;
            for (int i = 1; i < boardSize; i++) {
                if (board[0][boardSize - 1] != board[i][boardSize - 1 - i]) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                winner = board[0][boardSize - 1];
            }
        }

        return winner;
    }

    public void printBoard(){
        System.out.print("\n");
        for(int i=0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++) {
                if (board[i][j] == -1) {
                    System.out.print(" ");
                } else {
                    System.out.print(board[i][j]);
                }

                if(j != boardSize - 1){
                    System.out.print(" | ");
                } else {
                    System.out.print("\n");
                }
            }

            if(i != boardSize - 1) {
                System.out.println("-".repeat(boardSize + (boardSize - 1) * 3));
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
