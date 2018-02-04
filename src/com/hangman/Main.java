
package com.hangman;

import java.util.Scanner;

public class Main
{
    
    static String _allLetters = "abcdefg";
    static String _usedLetters = "af";
    
    public static void main(String[] args)
    {
        String allLetters = _allLetters;
        String usedLetters = _usedLetters;
        String availableLetters;
        String[] allLettersArray = new String[allLetters.length()];
        String[] usedLettersArray = new String[usedLetters.length()];
        
        for( int i = 0; i < allLetters.length(); i++) {
            allLettersArray[i] = allLetters.charAt(i) + "";
        }
        
        for( int i = 0; i < usedLetters.length(); i++) {
            usedLettersArray[i] = usedLetters.charAt(i) + "";
        }
        
        availableLetters = "";
        for( int i = 0; i < allLettersArray.length; i++) {
            for( int j = 0; j < usedLettersArray.length; j++) {
                if( usedLettersArray[j].equals( allLettersArray[i] ) ) {
                    availableLetters += "_ ";
                }
                else {
                    availableLetters += allLettersArray[i] + " ";
                }
            }
        }
    }
    
    
    
    
}
