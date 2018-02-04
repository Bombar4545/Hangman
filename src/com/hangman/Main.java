
package com.hangman;

import java.util.Scanner;

public class Main
{
    
    static String _allLetters = "abcdefg";
    static String _usedLetters = "af";
    
    public static void main(String[] args)
    {
        System.out.println( getAvailableLetters(_allLetters, _usedLetters) );
    }
    
    public static String getAvailableLetters(String allLetters, String usedLetters)
    {
        String availableLetters = "";
        for( int i = 0; i < allLetters.length(); i++)
        {
            for( int j = 0; j < usedLetters.length(); j++)
            {
                if( usedLetters.charAt( j ) == allLetters.charAt( i ) )
                {
                    availableLetters += "_ ";
                }
                else
                {
                    availableLetters += allLetters.charAt( i ) + " ";
                }
            }
        }
        return availableLetters;
    }
    
    
    
    
}
