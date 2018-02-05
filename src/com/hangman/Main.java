package com.hangman;

import java.util.Scanner;

public class Main2
{
	public static void main( String[] args)
	{
		Scanner scan = new Scanner( System.in );
		String guess;
		int tmp;
		Hangman game;
		
		game = new Hangman();
		do
		{
			System.out.println( "* Used Letters: " + game.getUsedLetters() );
			System.out.println( "* Number of Incorrect Tries: " + game.getNumOfIncorrectTries() );
			System.out.println( "* Known So Far: " + game.getKnownSoFar() );
			System.out.println();
			
			do
			{
				guess = scan.nextLine();
			}
			while( guess.length() != 0 );
			
			
			guess = guess.toLowerCase().charAt(0) + "";
			tmp = game.tryThis( guess );
			
			//check all cases
			if ( tmp == -1 )
				System.out.print( "The letter is not valid" );
			else if ( tmp == -2 )
				System.out.println( "The letter was already used" );
			else if ( tmp > 0 )
				System.out.print( tmp + "matchs!!!" );
			
		}
		while ( !game.isGameOver() );
		
		if( game.hasLost() )
			System.out.print("You Lost!");
		else
			System.out.print("You Win!");
	}
	
}
