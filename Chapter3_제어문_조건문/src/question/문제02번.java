package question;

import java.util.Scanner;

// 문제2. 정수 한 개를 입력받아서, 그 수가 3의 배수인지 판단해보자.

public class 문제02번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("정수를 한 개 입력하세요 : ");
		int num = scan.nextInt();

		// 결과 출력
		if (num % 3 == 0) {
			System.out.println(num + "은(는) 3의 배수입니다.");
		} else {
			System.out.println(num + "은(는) 3의 배수가 아닙니다.");
		}
	}

}
