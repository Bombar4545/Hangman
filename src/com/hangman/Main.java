
package com.hangman;

public class Main
{

    public static void main(String[] args)
    {
        String guess;
        
        do
        {
            System.out.println( "Guess the word by typing exactly letter" );
            guess = sc.nextLine().toLowerCase();
        }
        while ( guess.length() != 1  );
    }
    
}
