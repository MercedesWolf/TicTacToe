package com.company;

public class Main {
    public static void main(String[] args) {
        /* 0 = first player */
        int turn = 0;
        int winner = -1;
        /** Board
         * A|A|A
         * _____
         * A|A|A
         * _____
         * A|A|A
         */
        Board board = new Board();

        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while(winner == -1){
            board.printBoard();

            Player currentPlayer = players[turn];

            Position position = currentPlayer.getTurn();

            if(currentPlayer.validateTurn(board, position)){
                board.setField(position, currentPlayer.number);
                winner = board.checkWinner();
                turn = (turn + 1) % 2;
            }
        }

        System.out.println("Herzlichen Glückwunsch, Spieler " + winner + ". Du hast gewonnen!");
    }


}
