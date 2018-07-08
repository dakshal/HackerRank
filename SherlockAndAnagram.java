import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static HashMap<HashMap<Character, Integer>, Integer> isMatch(HashMap<Character, Integer> map,
			HashMap<HashMap<Character, Integer>, Integer> anagram) {
		int count = 0;
		boolean match = true;
		for (HashMap<Character, Integer> hm : anagram.keySet()) {
			if (map.size() == hm.size()) {
				for (Character key : map.keySet()) {
					// System.out.println(hm.get(key) + "\t" + key + "\t" + map.get(key));
					if (hm.containsKey(key)) {
						if (hm.get(key) == map.get(key)) {
							match = true;
						} else {
							match = false;
							break;
						}
					} else {
						match = false;
						break;
					}
				}
				if (match) {
					anagram.put(hm, anagram.get(hm)+1);
					return anagram;
				}
			} else {
				match = false;
			}
		}
		if (!match) {
			anagram.put(map, 0);
		}
		if (anagram.size() == 0) {
			anagram.put(map, 0);
		}
		return anagram;
	}

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		HashMap<HashMap<Character, Integer>, Integer> anagram = new HashMap<>();
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
				anagram = isMatch(map, anagram);
			}
		}
		for (int value : anagram.values()) {
			count += (value*(value+1))/2;
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
