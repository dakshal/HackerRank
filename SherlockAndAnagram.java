import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
	public static String sortString(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		int count = 0;
		HashMap<String, Integer> anagramList = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length()+1; j++) {
				String sorted = sortString(s.substring(i, j));
                // System.out.println(sorted);
				if (anagramList.containsKey(sorted)) {
					anagramList.put(sorted, anagramList.get(sorted) + 1);
				} else {
					anagramList.put(sorted, 0);
				}
			}
		}

		for (int values : anagramList.values()) {
                            // System.out.println(values);
			count += (values * (values + 1)) / 2;
		}

		return count;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
