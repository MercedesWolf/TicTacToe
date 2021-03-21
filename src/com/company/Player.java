package com.company;

import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
    }

    public Position getTurn(){
        System.out.println("Player " + number + " du bist am Zug!");

        int y = -1;

        while (y < 0 || y >= 3) {
            System.out.print("Zeile:");
            y = scanner.nextInt();

            if (y < 0 || y >= 3) {
                System.out.println("Ungültige Eingabe.");
            }
        }


        int x = -1;

        while (x < 0 || x >= 3) {
            System.out.print("Spalte:");
            x = scanner.nextInt();

            if (x < 0 || x >= 3) {
                System.out.println("Ungültige Eingabe.");
            }
        }

        return new Position(y, x);
    }

    public boolean validateTurn(Board board, Position turn){
        if(board.getField(turn) == -1) {
            return true;
        }
        return false;
    }
}
