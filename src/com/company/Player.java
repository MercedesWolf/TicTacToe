package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
    }

    public Position getTurn(){
        System.out.println("Player " + number + " du bist am Zug!");

        int y = getRowOrColumn("Zeile:");
        int x = getRowOrColumn("Spalte:");

        return new Position(y, x);
    }

    private int getRowOrColumn(String name) {
        int rowOrColumn = -1;

        while (rowOrColumn < 0 || rowOrColumn >= 3) {
            System.out.print(name);

            try {
                rowOrColumn = scanner.nextInt();
            } catch(InputMismatchException ignored) {
                // consume wrong input
                scanner.next();
            }

            if (rowOrColumn < 0 || rowOrColumn >= 3) {
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
