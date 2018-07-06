import java.util.Scanner;

public class Panelty {

	public static boolean penalize(String attendance) {

		String dailyAttendence[] = attendance.split(" ");
		int score = 0, absCount = 0;

		for (int i = 0; i < dailyAttendence.length; i++) {
			switch (dailyAttendence[i]) {
			case "A":
				absCount++;
				break;
			case "P":
				score = 0;
				break;
			case "L":
				score += 1;
				break;
			}
			
			if(score>=3 || absCount>=2) {
				return false;
			}
		}

		return false;

	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String attendance = sc.nextLine();

		System.out.println(penalize(attendance));

	}

}
