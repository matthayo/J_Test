import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Driver {
   public static void main(String[] args) throws FileNotFoundException {
    Scanner sc= new Scanner(System.in);
     System.out.print("Enter a filename: ");  
        String str= sc.nextLine();  
         
         int[] count = new int[26];
      Scanner input = new Scanner(new File(str));

      while (input.hasNextLine()) {
           String filename = input.nextLine();
           filename = filename.toLowerCase();
           char[] characters = filename.toCharArray();
         
           for (int letter = 0; letter< characters.length ; letter++) {
               if((characters[letter] >='a') && (characters[letter]<='z')) {
                    count[characters[letter] -'a' ]++;
               }
           }
         
       }

       for (int letter = 0; letter < 26; letter++) {
          System.out.println("Number of " + (char) (letter + 'a') + "'s: " + count[letter]);

       }
   }
}