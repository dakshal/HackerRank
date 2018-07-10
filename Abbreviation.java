import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int j=0, i=0;
        for(i=0; i<a.length() && j<b.length(); i++){
            // System.out.println(b.substring(j, j+1).equalsIgnoreCase(a.substring(i, i+1))+"\t"+Character.isLowerCase(a.charAt(i)));
            if((a.charAt(i) == b.charAt(j)) || (Character.isLowerCase(a.charAt(i)) && b.substring(j, j+1).equalsIgnoreCase(a.substring(i, i+1)))){
                j++;
            }
        }
        if(j == b.length() && i == a.length()){
            return "YES";
        }else if(i<a.length() &&(a.substring(i, a.length()).equals(a.substring(i, a.length()).toLowerCase()))){
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
