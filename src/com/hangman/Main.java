
public class Main {
   
   public static void main(String[] args)
   {
      String allLetters = game.getAllLetters();
      String usedLetters = game.getUsedLetters();
      String availableLetters;
      char[] allLettersArray = new char[allLetters.length()];
      
      for( int i = 0; i < allLetters.length(); i++) {
         allLettersArray[i] = allLetters.charAt(i);
      }
      
      
      availableLetters = "";
      for( int i = 0; i < allLettersArray.length; i++) {
         if( usedLetters.indexOf(allLettersArray[i]) >= 0) {
            availableLetters +=  "_ ";
         }
         else {
            availableLetters += allLettersArray[i] + " ";
         }
      }
      System.out.println( availableLetters );
   }
}
