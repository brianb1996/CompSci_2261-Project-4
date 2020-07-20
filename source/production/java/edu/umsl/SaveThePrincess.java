package edu.umsl;


import KnightVs.Hydra.Hydra;
import KnightVs.Hydra.Knight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SaveThePrincess {
    public static void main(String[] args){
        int count = 0;
        Hydra hydra = createHydra();
        do{
            attackHydra(hydra);
            if(++count % 5 == 0){
                if(!continueGame()){
                    break;
                }
            }
        }while(hydra.hydraAlive() && hydra.canKill());
        if(!hydra.hydraAlive()){
            System.out.println("\n\t\t\tYou've Won!" +
                    "\nYou killed the Hydra and saved the Princess!");
        }else{
            System.out.println("\n\tYou've Lost!" +
                    "\nBetter Luck next time");
        }

    }

    public static Hydra createHydra(){
        int numHeads = 0;
        int numTails = 0;
        Scanner userInput = new Scanner(System.in);
        do {
            try {
                System.out.println("Please enter the Number of Heads the Hydra has: ");
                numHeads = userInput.nextInt();
            } catch (InputMismatchException ex) {
                userInput = new Scanner(System.in);
            }
            if(numHeads <= 0){
                System.out.println("Error: Please enter a integer larger than 0 for the number of Heads");
            }
        }while(numHeads <= 0);
        do{
            try {
                System.out.println("Please enter the Number of Tails the Hydra has: ");
                numTails = userInput.nextInt();
            } catch (InputMismatchException ex) {
                userInput = new Scanner(System.in);
            }
            if(numTails <= 0){
                System.out.println("Error: Please enter a integer larger than 0 for the number of Tails");
            }
        }while( numTails <= 0);
        return new Hydra(numHeads,numTails);
    }

    public static void attackHydra(Hydra hydra){
        do {
            hydra.displayHydra();
            Knight.DisplayMoveSet(hydra);
        }while(!hydra.move(Knight.attack()));
    }

    public static boolean continueGame(){
        Scanner userInput = new Scanner(System.in);
        String keepGoing = "";
        do {
            System.out.println("Would you like to continue the game?" +
                    "\nPress [ Y ] to continue\t Press anything else to exit");
            try {
                keepGoing = userInput.nextLine();
                if (keepGoing.charAt(0) == 'y' || keepGoing.charAt(0) == 'Y') {
                    return true;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                userInput = new Scanner(System.in);
            }
        }while(keepGoing.isEmpty());
        return false;
    }

}
