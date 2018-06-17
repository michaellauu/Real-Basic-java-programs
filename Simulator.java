
/**
* Assignment #3b.
* This program simulates the probability of winning given an input.
*
* Authors: Michael Lau (mlau10@ucsc.edu)
*          and Jeffrey Liu (jliu63@ucsc.edu)
*/

import java.util.*;

public class Simulator {

    public static boolean roll() {
        Random rand = new Random(System.nanoTime()); // generates random seed without user input
        int dice;
        dice = (rand.nextInt(6) + 1) +
                (rand.nextInt(6) + 1); // adds up 2 dice
        if (dice == 7 || dice == 11) {
            return true; // true = win
        }
        if (dice == 2 || dice == 3 || dice == 12) {
            return false; // false = lose
        }
        while (true) { // must use while, else loop causes output errors
            int point = dice; // Any number thats not 7, 11, 2, 3, 12
            dice = (rand.nextInt(6) + 1) +
                    (rand.nextInt(6) + 1);
            if (dice == point)
                return true; // win
            if (dice == 7)
                return false; // lose
        }
    }

    public static void main(String[] args) {
        /* get user input for amount of trials */
        Scanner in = new Scanner(System.in);
        System.out.println("How many times do you want to run this?");
        int number = in.nextInt();
        int wins = 0;
        for (int i = 0; i < number; i++)
            if (roll()) wins++; // count wins
        System.out.println("Odds of winning = " + 1.0 * wins / number); // calculate odds
    }
}

