package com.company;

import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);

    public Player(int number){
        this.number = number;
    }

    public int getTurn(){
        System.out.println("Player " + number + " du bist am Zug!");
        int input = scanner.nextInt();
        if(input < 9 && input >= 0){
            return input;
        }
        System.out.println("Ungültige Eingabe.");
        return getTurn();
    }

    public boolean validateTurn(Board board, int turn){
        if(board.getField(turn) == -1) {
            return true;
        }
        return false;
    }
}
