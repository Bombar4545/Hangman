package com.hangman;

import java.util.Scanner;

public class Main
{
   public static void main( String[] args )
   {
      Scanner scan = new Scanner( System.in );
      String allLetters;
      String usedLetters;
      String availableLetters;
      char[] allLettersArray;
      boolean quit;
      String option;
      String guess;
      
      Hangman game = new Hangman();
      quit = false;
      
      allLetters = game.getAllLetters();
      allLettersArray = new char[allLetters.length()];
      for( int i = 0; i < allLettersArray.length; i++) {
         allLettersArray[i] = allLetters.charAt( i );
      }
      
      do
      {
         System.out.println("1-Start\n2-Quit");
         option = scan.nextLine();
         
         if (option.equals("1"))
         {
            quit = false;
         }
         else if (option.equals("2"))
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
            //update usedLetters String and reinitialize availableLetters
            usedLetters = game.getUsedLetters();
            availableLetters = "";
            
            //creating available letters table
            availableLetters = "";
            int n = 0;
            for( int i = 0; i < allLettersArray.length; i++)
            {
               if( usedLetters.indexOf(allLettersArray[i]) >= 0)
               {
                  availableLetters +=  "_ ";
               }
               else
               {
                  availableLetters += allLettersArray[i] + " ";
               }
               if( n % 13 == 0 )
               {
                  availableLetters += "\n";
               }
               n++;
            }
            
            System.out.println(availableLetters);
            System.out.println("Number of Incorrect Tries Left: " + game.getNumOfIncorrectTries());
            
            //taking input from the user
            do
            {
               System.out.println( "Guess the word by typing exactly letter" );
               guess = scan.nextLine().toLowerCase();
            }
            while ( guess.length() != 1  );
            
            int debug;
            do
            {
               debug = game.tryThis(guess);
               if ( debug == -2 )
               {
                  System.out.println( "You are entering an already used letter" );
               }
               if ( debug == -1 )
               {
                  System.out.println( "You are entering an invalid character" );
               }
            } while(debug < 0);
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
}
