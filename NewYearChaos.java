import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        long count = 0;
        boolean invalide = false;
        for(int i=q.length-1; i>=0; i--){
            if(q[i] - (i+1)>2){
                            // System.out.println(q[i] - (i+1) +"\t"+q[i]+"\t"+i +"\t"+count);
                invalide = true;
                break;
            }
            int j=q[i]-2>0?q[i]-2:0;
            
            for(; j<i; j++){
                if(q[i]<q[j]){
                    count++;
                }
            }
        }
        if(invalide){
            System.out.println("Too chaotic");
        } else {
            System.out.println(count);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
