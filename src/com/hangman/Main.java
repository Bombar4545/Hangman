package com.hangman;
import java.util.Scanner;
/**
 * Hangman Game Main Method = 1, Section 2. CS 102
 * @author Group C, Ege Hakan KARAAGAC, Ege Ozan Ozyedek, Ufuk Bombar, Ata Sonat Uzun, Taha Khurram, Muhammad Saboor.
 * @version 4/2/2018, 1.00
 */
public class Main {

    public static void main(String[] args) {
        public class Main {

            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                //Constants

                //Variable
                String guess;
                Hangman game;
                boolean quit;
                int option;

                //Program Code
                Hangman game = new Hangman();
                quit = false;
                System.out.println("Welcome to hangman");
                do {
                    System.out.println("1-Start\n2-Quit");
                    option = scan.nextInt();
                    if (option == 1) {
                        quit = false;
                    } else if (option == 2) {
                        quit = true;
                        System.out.println("GoodBye!!");
                    } else {
                        System.out.println("Input a VALID option!");
                    }
                    if (!quit) {

                        while ( !game.isGameOver()) {
                            //Code for the game is over here!!!!
                        }
                            if (game.hasLost()) {
                                System.out.println("You Lost");
                            } else {
                                System.out.println("Winner Winner Chicken Dinner!!!");
                            }
                        }
                    }while(!quit);
                }
            }
        }
    }
}
