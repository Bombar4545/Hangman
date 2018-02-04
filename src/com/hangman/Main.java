
package com.hangman;

public class Main {

    public static void main(String[] args)
    {
    	String allLetters = game.getAllLetters();
    	String usedLetters = game.getAllLetters();
    	String availableLetters;
    	String[] allLettersArray = new String[allLetters.length()];
        String[] usedLettersArray = new String[usedLetters.length()];

    	for( int i = 0; i < allLetters.length(); i++) {
            allLettersArray[i] = allLetters.charAt(i);
        }

        for( int i = 0; i < usedLetters.length(); i++) {
            usedLettersArray[i] = usedLetters.charAt(i);
        }

        availableLetters = "";
    	for( int i = 0; i < allLettersArray.length; i++) {
    	    for( int j = 0; j < usedLettersArray.length; j++) {
    	        if( usedLettersArray[j].equals( allLetters[i] ) ) {
    	            availableLetters += "_ ";
                }
                else {
    	            availableLetters += allLettersArray[i] + " ";
                }
            }
        }
    }
}
