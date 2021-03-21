package com.company;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Bitte Spielfeldgröße angeben!");
            System.exit(1);
        }

        int boardSize = 0;

        try {
            boardSize = Integer.parseInt(args[0]);
        } catch(NumberFormatException ignored) {
            System.err.println("Spielfeldgröße muss eine Zahl sein!");
            System.exit(3);
        }

        if (boardSize < 1) {
            System.err.println("Spielfeldgröße muss mindestens 1 sein!");
            System.exit(2);
        }

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
        Board board = new Board(boardSize);

        Player a = new Player(0, board);
        Player b = new Player(1, board);
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
