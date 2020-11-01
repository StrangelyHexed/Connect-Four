import java.util.InputMismatchException;
import java.util.Scanner;

public class ConnectFourSimulation {
    public static void main(String[] args){
        ConnectFour game = new ConnectFour();
        char player;
        Scanner input = new Scanner(System.in);
        int col;
        boolean gameOver = false;
        game.printBoard();


        // Game Simulation //
        int first = (int)(Math.random()*2);
        if (first==0){
            System.out.println("Red will go first.");
            player = 'R';
        }
        else {
            System.out.println("Yellow will go first.");
            player = 'Y';
        }


        while (!gameOver){
            if (player == 'R')
                System.out.print("Drop a red disk at column(0-6): ");

            else
                System.out.print("Drop a yellow disk at column(0-6): ");

            try{
                col = input.nextInt();
                if (game.dropPieces(player, col)){
                    if(player == 'R') {
                        player = 'Y';
                    }
                    else
                        player = 'R';

                    if(game.checkWin()){
                        gameOver = true;
                        if(player == 'R')
                            player = 'Y';
                        else
                            player = 'R';

                        String printPlayer;

                        if (player =='R')
                            printPlayer = "red";
                        else
                            printPlayer = "yellow";

                        game.printBoard();

                        System.out.println("The " + printPlayer + "player has won!");

                        return;
                    }
                }
                game.printBoard();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input. Enter valid column numbers only.");
                input.next();
                game.printBoard();
                System.out.println();
            }
        }

    }
}
