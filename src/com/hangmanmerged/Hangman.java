package com.hangmanmerged;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bilkent CS102 Section 2
 * @date 08.02.2018
 */
public class Hangman
{
	// Properties
	private StringBuffer secretWord;
	private StringBuffer allLetters;
	private StringBuffer usedLetters;
	private StringBuffer knownSoFar;
	private int numberOfIncorrectTries;
	private int maxAllowedIncorrectTries;
	
	/**
	 * Class Constructor
	 * No parameters
	 * Empty body (should be filled)
	 */
	public Hangman()
	{
		secretWord = new StringBuffer( chooseSecretWord() );
		allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		usedLetters = new StringBuffer("");
		knownSoFar = new StringBuffer("");
		numberOfIncorrectTries = 0;
		maxAllowedIncorrectTries = 6;
		
		// hide the secret word by stars
		for ( int i = 0 ; i < secretWord.length() ; i++ )
			if ( secretWord.charAt( i ) == ' ' )
				knownSoFar.append(" ");
			else
				knownSoFar.append("*");
	}
	
	// Methods
	/**
	 * This method is used to get all letters that can be used.
	 * @return all letters that can be used to predict the secret word.
	 */
	public String getAllLetters()
	{
		return allLetters.toString();
	}
	
	/**
	 * This method is used to get already tried letters.
	 * @return letters that have been tried by the user.
	 */
	public String getUsedLetters()
	{
		return usedLetters.toString();
	}
	
	/**
	 * This method is used to get the number of incorrect tries.
	 * @return the number of incorrect tries that user has made.
	 */
	public int getNumOfIncorrectTries()
	{
		return numberOfIncorrectTries;
	}
	
	/**
	 * This method is used to get maximum allowed number of incorrect tries.
	 * @return the integer value of maximum allowed incorrect tries.
	 */
	public int getMaxAllowedIncorrectTries()
	{
		return maxAllowedIncorrectTries;
	}
	
	/**
	 * This method is used to get known part of the secret word.
	 * @return the known part of the secret word.
	 */
	public String getKnownSoFar()
	{
		return knownSoFar.toString();
	}
	
	/**
	 * This method is used to determine whether the game is over or not.
	 * @return true if the game is over.
	 */
	public boolean isGameOver()
	{
		return ( knownSoFar.toString().equals( secretWord.toString() ) ) || ( numberOfIncorrectTries >= maxAllowedIncorrectTries );
	}
	
	/**
	 * This method is used to determine whether the user has lost or not.
	 * @return true if the user has lost the game.
	 */
	public boolean hasLost()
	{
		return numberOfIncorrectTries >= maxAllowedIncorrectTries;
	}
	
	/**
	 * This method returns the number of times the specified letter occurs in the chosen word.
	 * @author Hanzallah Azim Burney, Abdul Hamid Dabboussi, Khasmamad, Muhammad Raza, Gledis, Supermurat
	 * @param letter character to be checked in the word.
	 * @return The number of times the letter occurs or else the corresponding error code.
	 */
	public int tryThis( char letter )
	{
		letter = ( letter + "" ).toLowerCase().charAt( 0 );
		int count = 0;
		
		if ( this.usedLetters.indexOf( letter + "" ) != -1 )
		{
			
			return -2;
		}
		else if ( isGameOver() )
		{
			return -3;
		}
		else if ( this.secretWord.indexOf( letter + "" ) != -1 )
		{
			for ( int i = 0; i < this.secretWord.length(); i++ )
			{
				if ( this.secretWord.toString().toLowerCase().charAt( i ) == letter )
				{
					this.knownSoFar.replace( i, i + 1, this.secretWord.charAt( i ) + "" );
					count++;
				}
			}
			usedLetters.append( letter );
			return count;
		}
		else if ( this.usedLetters.indexOf( letter + "" ) == -1 )
		{
			usedLetters.append( letter + "" );
			numberOfIncorrectTries++;
			return -1;
		}
		return -1;
	}
	
	/**
	 * Chooses a word from random from a String array ( rewritten bu Ufuk BOMBAR )
	 * @return StringBuffer the randomly chosen word
	 */
	public String chooseSecretWord()
	{
		ArrayList<String> dictionary = new ArrayList();
		
		try
		{
			BufferedReader bufferedReader = new BufferedReader( new FileReader( "./dictionary.txt" ) );
			String buffer;
			
			while ( ( buffer = bufferedReader.readLine() ) != null )
				dictionary.add( buffer );
			
			bufferedReader.close();
		}
		catch ( Exception e )
		{
			System.err.println( "# Could not load dictionary! Getting with the default dictionary..." );
			
			dictionary.add( "nevada" );
			dictionary.add( "welcome" );
			dictionary.add( "slogan" );
			dictionary.add( "branch" );
			dictionary.add( "archaeologists" );
			dictionary.add( "reminiscent" );
			dictionary.add( "coach" );
		}
		
		return dictionary.get( ( int ) ( Math.random() * ( dictionary.size() - 1 ) ) );
	}
	
	/**
	 * Operates hangman game
	 * @author Group C: Ege Hakan KARAAGAC, Ege Ozan Ozyedek, Ufuk Bombar, Ata Sonat Uzun, Taha Khurram, Muhammad Saboor.
	 * @date 4/2/2018
	 * @version 1.00
	 * @return void
	 */
	public static void main( String[] args )
	{
		//declaring variables
		Scanner scan = new Scanner( System.in );
		String guess;
		int tmp;
		Hangman game;
		
		//initializing hangman game
		game = new Hangman();
		
		//this block runs while game is running
		do
		{
			//display hangman stats
			System.out.println( "\t* Used Letters: " + game.getUsedLetters() );
			System.out.println( "\t* Number of Incorrect Tries: " + game.getNumOfIncorrectTries() );
			System.out.println( "\t* Known So Far: " + game.getKnownSoFar() );
			System.out.println();
			
			//getting valid user input
			do
			{
				System.out.print( "Please enter a letter: " );
				guess = scan.nextLine();
			}
			while( guess.length() != 1 );
			
			//getting first character of user input, rest is ignored
			guess = guess.toLowerCase().charAt(0) + "";
			tmp = game.tryThis( guess.charAt( 0 ) );
			
			//check all cases and errors from tryThis method
			if ( tmp == -1 )
				System.out.println( "The word does not contains this letter" );
			else if ( tmp == -2 )
				System.out.println( "The letter was already used" );
			else if ( tmp > 0 )
				System.out.println( tmp + " match(s)!!" );
		}
		while ( !game.isGameOver() );
		
		
		
		//checking if the player has won or lost
		if( game.hasLost() )
			System.out.println( "\t**You Lost!**" );
		else
			System.out.println( "\t**You Win!**" );
			
	}
}
