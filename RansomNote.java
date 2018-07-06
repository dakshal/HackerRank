import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {

		HashMap<String, Integer> magazineList = new HashMap<>();

		for (int i = 0; i < magazine.length; i++) {
			if (magazineList.containsKey(magazine[i])) {
				magazineList.put(magazine[i], magazineList.get(magazine[i]) + 1);
			} else {
				magazineList.put(magazine[i], 1);
			}
		}
		boolean print = true;

		for (int i = 0; i < note.length; i++) {
			if (magazineList.get(note[i]) > 0) {
				magazineList.put(note[i], magazineList.get(note[i]) - 1);
			} else {
				print = false;
				break;
			}
		}
		if (print) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
