import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static int isMatch(HashMap<Character, Integer> map, ArrayList<HashMap<Character, Integer>> anagram) {
		int count = 0;
		for (HashMap<Character, Integer> hm : anagram) {
			if (map.size() == hm.size()) {
				boolean match = true;
				for (Character key : map.keySet()) {
					// System.out.println(hm.get(key) + "\t" + key + "\t" + map.get(key));
					if (hm.containsKey(key)) {
						if (hm.get(key) == map.get(key)) {

						} else {
							match = false;
							break;
						}
					} else {
						match = false;
						break;
					}
				}
				if (match)
					count++;
			}
		}
		return count;
	}

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		ArrayList<HashMap<Character, Integer>> anagram = new ArrayList<>();
		int count = 0;

		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String part = s.substring(i, j);
				HashMap<Character, Integer> map = new HashMap<>();
				for (int k = 0; k < part.length(); k++) {
					if (map.containsKey(part.charAt(k))) {
						map.put(part.charAt(k), map.get(part.charAt(k)) + 1);
					} else {
						map.put(part.charAt(k), 1);
					}
				}
				count += isMatch(map, anagram);
//				if (isMatch(map, anagram) != 0) {
//					count++;
//				} // else {
				anagram.add(map);
//				}
				// System.out.println(part +"\t" + anagram.size()+"\t"+map.size()+ "\t" +
				// count);

			}
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
