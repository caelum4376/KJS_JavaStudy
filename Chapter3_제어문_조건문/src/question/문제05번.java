package question;

import java.util.Scanner;

// 문제5. 사용자로 부터 정수를 입력받아서 양수인지 음수인지 확인하는 프로그램 작성

public class 문제05번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("정수를 한 개 입력하세요 : ");
		int num = scan.nextInt();

		// 결과 출력
		if (num >= 0) {
			System.out.println(num + "은(는) 양수입니다.");
		} else {
			System.out.println(num + "은(는) 음수입니다.");
		}
	}

}
