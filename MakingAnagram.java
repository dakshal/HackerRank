import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> uniqueA = new HashMap<>();
        int count = 0;
        
        for(int i=0; i<a.length(); i++){
            if(uniqueA.containsKey(a.charAt(i))){
                uniqueA.put(a.charAt(i), uniqueA.get(a.charAt(i))+1);
            } else {
                uniqueA.put(a.charAt(i), 1);
            }
        }
        for(int i=0; i<b.length(); i++){
            if(uniqueA.containsKey(b.charAt(i))){
                if(uniqueA.get(b.charAt(i)) > 0){
                    uniqueA.put(b.charAt(i), uniqueA.get(b.charAt(i)) - 1);
                    count++;
                }
            }
        }
        return a.length() + b.length() - (count*2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
