/*@author Ahmed Alkhalaf
En hjälp klass till samtliga uppgifter i labb 4
Koden är imblementation för att läsa in filen och retunera den som In dataType 
för att använda den vidare i labben.
Koden  In som har använt är från princeton (ch: 3.1) In.java
https://introcs.cs.princeton.edu/java/stdlib/In.java.htmlKoden 
skapade den 2021/10/07 
Sista upptadering 2021/10/13
 */
package labb4task1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class In {
    private static final String CHARSET_NAME = "UTF-8";
    private Scanner scanner;
    
    //read a file and reurn it as type In
    public In(String name) {
        if (name == null) throw new IllegalArgumentException("argument is null");
        if (name.length() == 0) throw new IllegalArgumentException("argument is the empty string");
        try {
            // first try to read file from local file system
            File file = new File(name);
            if (file.exists()) {
                // for consistency with StdIn, wrap with BufferedInputStream instead of use
                // file as argument to Scanner
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), CHARSET_NAME);
                return;
            }
        }
            catch (IOException ioe) {
                throw new IllegalArgumentException("Could not open " + name, ioe);
            }
        
    }

    //read Integer data and throw exp if that is not Integer
    public int readInt() {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
                                           + "but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from the input stream, "
                                           + "but no more tokens are available");
        }
    }

   //return false if file has more line
     public boolean hasNextLine() {
         return scanner.hasNextLine();
     }

     //read Line  and return it as string
     public String readLine() {
         String line;
         try {
             line = scanner.nextLine();
         }
         catch (NoSuchElementException e) {
             line = null;
         }
         return line;
     }
}