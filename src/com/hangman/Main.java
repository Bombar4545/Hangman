
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
      
      System.out.println( availableLetters );
   }
}
