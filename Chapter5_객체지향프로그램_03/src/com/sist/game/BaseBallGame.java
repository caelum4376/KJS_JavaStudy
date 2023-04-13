package com.sist.game;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 컴퓨터 난수 발생 int[] com
 * 2. 사용자 입력 int[] user
 * 3. 비교 com / user 비교 => s, b
 * 4. 힌트 s, b
 * 5. 종료여부 확인 s
 */

public class BaseBallGame {
	int[] com = new int[3];
	int[] user = new int[3];
	int s, b;

	// 1. 컴퓨터 난수 발생
	void rand() {
		for (int i = 0; i < 3; i++) {
			com[i] = (int) (Math.random() * 9) + 1;

			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--;
					break;
				}
			}
		}
	}

	// 2. 사용자 입력 void
	void input() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("세 자리 정수입력 : ");
			int input = scan.nextInt();

			if (input < 100 || input > 999) {
				System.out.println("잘못된 입력값입니다!!");
				continue; // 처음부터 다시 수행(while)
			}

			// 세 자리 정수를 입력했다면
			user[0] = input / 100; // 369/100 => 3
			user[1] = (input % 100) / 10; // 369%100 => 69/10 => 6
			user[2] = input % 10; // 369%10 => 9

			// 1. 같은 정수를 입력하면 안된다
			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("중복된 수는 사용하 수 없습니다");
				continue;
			}

			// 2. 0을 포함할 수 없다
			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0은 사용할 수 없습니다");
				continue;
			}

			// 정상입력시 종료
			break;
		}
	}

	// 3. 비교 void
	void compare() {
		s = 0;
		b = 0;
		for (int i = 0; i < com.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if (com[i] == user[j]) {
					if (i == j) {
						s++;
					} else {
						b++;
					}
				}
			}
		}
	}

	// 4. 힌트 void
	void hint() {
		System.out.printf("Input : %s, Result : %dS - %dB\n", Arrays.toString(user), s, b);
	}

	// 5. 종료여부 확인 void
	boolean exitStatus() {
		if (s == 3) {
			return true;
		} else {
			return false;
		}
	}

	// 6. 조립 => process
	void process() {
		
		Scanner scan = new Scanner(System.in);
		// 컴퓨터 난수 발생
		rand();

		while (true) {
			
			// 사용자 입력
			input();

			// 비교
			compare();

			// 힌트출력
			hint();

			// 종료여부 확인
			if (exitStatus()) {
				System.out.print("게임을 다시할까요?(y(Y)/n(N)) : ");
				char c = scan.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					System.out.println("새 게임을 시작합니다!!");
					process();
				} else {
					System.out.print("Game Over!!!");
					System.exit(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		BaseBallGame b = new BaseBallGame();

		b.process();
	}
}
