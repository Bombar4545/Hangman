package com.hangman;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        String allLetters = "";
        String usedLetters = "";
        String availableLetters = "";
        boolean quit;
        int option;
        
        Hangman game = new Hangman();
        quit = false;
        
        do
        {
            System.out.println("1-Start\n2-Quit");
            option = scan.nextInt();
    
            if (option == 1)
            {
                quit = false;
            }
            else if (option == 2)
            {
                quit = true;
                System.out.println("GoodBye!!");
            }
            else
            {
                System.out.println("Input a VALID option!");
            }
    
            if ( !quit )
            {
                //C
    
                String allLetters = game.getAllLetters();
                String usedLetters = game.getUsedLetters();
                String availableLetters;
    
                for( int i = 0; i < allLetters.length(); i++) {
                    allLettersArray[i] = allLetters.charAt(i);
                }
    
    
                availableLetters = "";
                int n = 0;
                for( int i = 0; i < allLettersArray.length; i++) {
                    if( usedLetters.indexOf(allLettersArray[i]) >= 0) {
                        availableLetters +=  "_ ";
                    }
                    else {
                        availableLetters += allLettersArray[i] + " ";
                    }
                    if( n % 13 == 0 ) {
                        availableLetters += "\n";
                    }
                    n++;
                }
                
                //Code for the game is over here!!!!
                if( game.isGameOver() )
                {
                    if ( game.hasLost() )
                    {
                        System.out.println("You Lost");
                    }
                    else
                    {
                        System.out.println("Winner Winner Chicken Dinner!!!");
                    }
                }
            }
            
        }
        while ( !quit );
    }
    
    public static String lol()
    {
    
    }
}
