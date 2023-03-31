package question;

import java.util.Scanner;

// 문제1. 정수 한 개를 입력받아서, 그 수가 50 이상의 수인지 50미만의 수인지 판단해보자.

public class 문제01번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("정수를 한 개 입력하세요 : ");
		int num = scan.nextInt();
		
		// 결과 출력
		if (num >= 50) {
			System.out.println(num + "은(는) 50이상입니다.");
		} else {
			System.out.println(num + "은(는) 50미만입니다.");
		}
	}

}
