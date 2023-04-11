import java.util.Arrays;
import java.util.Scanner;
/*
 * 1. 난수 발생
 * 2. 사용자 입력
 * ------------------
 * 3. 비교
 * 4. 힌트
 * ------------------
 * 5. 종료여부
 */

public class 메소드조립법_03 {

	static void input(int[] com, int[] user) {

		if (com == null) {
			for (int i = 0; i < 3; i++) {
				com[i] = (int) (Math.random() * 9) + 1; // 1~9

				for (int j = 0; j < i; j++) {
					if (com[i] == com[j]) {
						i--;
						break;
					}
				}
			}
		}

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("세자리 정수 입력 : ");
			int input = scan.nextInt();
			// 정상 입력 => &&
			// 오류 => ||
			if (input < 100 || input > 999) {
				System.out.println("잘못된 입력입니다!!");
				// while문의 조건식으로 이동 => 처음부터 다시 시작
				continue;
			}
			user[0] = input / 100;
			user[1] = (input % 100) / 10;
			user[2] = input % 10;

			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("같은 숫자는 사용이 불가능합니다!!");
				continue;
			}

			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0을 입력할 수 없습니다");
				continue;
			}

			break;
		}
	}

	static int compare(int[] com, int[] user) {
		int s = 0, b = 0;
		// s는 같은 자리의 수가 동일, b는 다른 자리에 있는 수가 동일

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (com[i] == user[j]) { // 같은 수가 있는지
					if (i == j) { // 같은 자리면
						s++;
					} else { // 다른 자리면
						b++;
					}
				}
			}
		}

		// 힌트
		System.out.printf("Input : %s, Result : %dS-%dB\n", Arrays.toString(user), s, b);

		return s;

	}

	static boolean eCheck(int s) {
		// 종료 여부
		if (s == 3) {
			System.out.print("GameOver!!");
			return true;
		}
		return false;
	}

	static void process() {
		int[] com = new int[3];
		int[] user = new int[3];

		// 난수 발생, 사용자 입력
		while (true) {
			input(com, user);

			// 비교
			int s = 0;
			s = compare(com, user);

			// 종료여부
			if (eCheck(s)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		process();
	}

}
