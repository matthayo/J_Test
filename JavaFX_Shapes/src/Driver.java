import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

public class Driver {

   public static void main(String[] args) {

      File oddNumber = new File("oddnumber.txt");

      try {

         PrintWriter output = new PrintWriter(oddNumber);

         int i = 101;

         while (i < 400){

            output.println(i);

            i = i + 2;

         }

         output.close();

      } catch (FileNotFoundException e) {

         e.printStackTrace();

      }

   }

}