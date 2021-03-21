package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Player {
    int number;

    Board board;

    Scanner scanner = new Scanner(System.in);

    public Player(int number, Board board){
        this.number = number;
        this.board = board;
    }

    public Position getTurn(){
        System.out.println("Player " + number + " du bist am Zug!");

        int y = getRowOrColumn("Zeile: ");
        int x = getRowOrColumn("Spalte: ");

        return new Position(y, x);
    }

    private int getRowOrColumn(String name) {
        int rowOrColumn = -1;

        while (rowOrColumn < 0 || rowOrColumn >= board.boardSize) {
            System.out.print(name);

            try {
                rowOrColumn = scanner.nextInt() - 1;
            } catch(InputMismatchException ignored) {
                // consume wrong input
                scanner.next();
            } catch(NoSuchElementException ignored) { // e.g. ctrl + d
                System.exit(0);
            }

            if (rowOrColumn < 0 || rowOrColumn >= board.boardSize) {
                System.out.println("Ungültige Eingabe.");
            }
        }

        return rowOrColumn;
    }

    public boolean validateTurn(Board board, Position turn){
        if(board.getField(turn) == -1) {
            return true;
        }
        return false;
    }
}
