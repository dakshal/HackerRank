import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
                
        String charArray [] = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        String strS1 = "";
        for(int i=0; i<26; i++) {
            if(s1.contains(charArray[i])) {
                strS1 += charArray[i];
            }
        }
        
        String strS2 = "";
        for(int i=0; i<26; i++) {
            if(s2.contains(charArray[i])) {
                strS2 += charArray[i];
            }
        }
                
        if(strS1.length() + strS2.length()>26) {
            return "YES";
        } else {
            for(int i=0; i<strS2.length(); i++) {
                if(strS1.contains(""+strS2.charAt(i))) {
                    return "YES";
                }
            }
        }
                
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
