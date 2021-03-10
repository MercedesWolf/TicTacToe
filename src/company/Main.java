package company;

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
        int[] board = new int[9];
        for(int i=0; i < board.length; i++){
            // no winner yet = -1
            board[i] = -1;
        }
        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        while(winner == -1){
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].validateTurn(board, turnField)){
                board[turnField] = players[turn].number;
                turn = (turn + 1) % 2;
            }
            winner = checkWinner(board);
        }

        System.out.println("Herzlichen Glückwunsch, Spieler " + winner + ". Du hast gewonnen!");
    }
    public static int checkWinner(int[] board){
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
    public static void printBoard(int[] meinBoard){
        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);
    }
}
