package com.sist.string;
// charAt(0)

// 코테
// 문자열을 입력해서 좌우대칭여부 확인

import java.util.Scanner;

public class 라이브러리_String_04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String user = "";
		boolean bCheck = true;

		while (true) {

			System.out.print("알파벳 문자 입력 : ");
			user = scan.nextLine();

			if (user.length() % 2 != 0) {
				System.out.println("문자 갯수가 짝수여야 합니다");
				continue;
			}
			break;
		}
		for (int i = 0; i < user.length() / 2; i++) {
			if (user.charAt(i) != user.charAt(user.length() - (i + 1))) {
				bCheck = false;
			}
		}

		if (bCheck) {
			System.out.println(user + "는 좌우대칭입니다");
		} else {
			System.out.println(user + "는 좌우대칭이 아닙니다");
		}

	}

}
