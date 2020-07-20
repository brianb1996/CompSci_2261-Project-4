package KnightVs.Hydra;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Knight {
    public static String[][] moveSet = {{"[ 1 ] Knight PyPy can cut off exactly one of Hydra’s heads.","[ 2 ] Knight PyPy can cut off exactly one of Hydra’s tails."},
                                { "[ 3 ] Knight PyPy can cut off exactly two of Hydra’s heads.","[ 4 ] Knight PyPy can cut off exactly two of Hydra’s tails."}};

    private Knight(){}

    public static void DisplayMoveSet() {
        System.out.println("PyPy can make 4 different moves:");
        for (String[] row : moveSet) {
            for (String element : row) {
                System.out.println(element);
            }
        }
    }

    public static void DisplayMoveSet(Hydra hydra){
        int tempH = Math.min(hydra.numHeads, 2);
        int tempT = Math.min(hydra.numTails, 2);
        int numMoves = tempH + tempT;
        System.out.println("PyPy can make " + numMoves +" different moves:");
        if(hydra.numHeads > 0){
            System.out.println(moveSet[0][0]);
        }
        if(hydra.numTails > 0){
            System.out.println(moveSet[0][1]);
        }
        if(hydra.numHeads > 1){
            System.out.println(moveSet[1][0]);
        }
        if(hydra.numTails > 1){
            System.out.println(moveSet[1][1]);
        }
    }

    public static int attack(){
        int moveSelect = 0;
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.print("Enter a move for PyPy: ");
            try {
                moveSelect = userInput.nextInt();
            } catch (InputMismatchException ex) {
                userInput = new Scanner(System.in);
                System.out.println("ERROR: Please enter the integer associated with the move");
            }
            if (moveSelect < 1 || moveSelect > 4) {
                System.out.println("Please enter an valid integer associated with the move");
            }
        }while(moveSelect < 1 || moveSelect > 4);
        return moveSelect;
    }
}
