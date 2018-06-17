
/**
* Assignment #3.
* This program plays Craps.
*
* Authors: Michael Lau (mlau10@ucsc.edu)
*          and Jeffrey Liu (jliu63@ucsc.edu)
*/

import java.util.*;

public class Craps {

    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis()); // generates random seed without user input
        int dice;  // initial roll
        Scanner in = new Scanner(System.in);
        System.out.println("How many coins do you want to start out with?");
        int bet = 0, coins = in.nextInt(); // coin count
        in.nextLine();
        while (coins > 0 && bet <= coins) { // no bet greater than coin count
            System.out.println("How many coins do you want to bet?");
            bet = in.nextInt(); // amount of coins to be bet
            in.nextLine();
            System.out.println("Press enter to start the roll");
            in.nextLine();
            dice = (rand.nextInt(6) + 1) +
                    (rand.nextInt(6) + 1); // adds up 2 dice
            if (dice ==  7 || dice == 11) {
                System.out.println("You won, you rolled: " + dice);
                coins += bet; // win
                System.out.println("Now you have: " + coins);
            } else {
                if (dice == 2 || dice == 3 || dice == 12) {
                    System.out.println("You lost, you rolled: " + dice);
                    coins -= bet; // lose
                    System.out.println("Now you have: " + coins);
                } else {
                    int point = dice; // point: Any point thats not 2,3,12,7,11
                    System.out.println("Neither win nor loss, you rolled: " + point);
                    System.out.println("Press enter to reroll...");
                    in.nextLine();
                    while (true) { // keep rolling
                        dice = (rand.nextInt(6) + 1) +
                                (rand.nextInt(6) + 1); // adds up 2 dice
                        if (dice == point) {
                            System.out.println("You won, rolled: " + point);
                            coins += bet; // win
                            System.out.println("Now you have: " + coins);
                            break;
                        }
                        if (dice == 7) {
                            System.out.println("You lost, rolled: 7");
                            coins -= bet; // lose
                            System.out.println("Now you have: " + coins);
                            break;
                        }
                    }
                }
                System.out.println("Press enter to continue or any key to stop");
                if (!"".equals(in.nextLine()) && coins > 0) {
                    System.exit(-1); // exits game by user command
                } else if (coins <= 0) {
                    System.out.println("Game over, you're out of coins!"); // game over by lack of coins
                }
            }
        }
    }
}

