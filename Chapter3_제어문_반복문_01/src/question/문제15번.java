package question;

import java.util.Scanner;

// Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,
// 십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.
public class 문제15번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("10 ~ 99 사이의 수를 입력하세요 : ");
		int num = scan.nextInt(); 
		
		if (num >= 10 && num <= 99) {
			if (num % 11 == 0) {
				System.out.println(num + " 두 개는 같은 정수입니다.");
			} else {
				System.out.println(num + " 두 개는 다른 정수입니다.");
			}
		} else {
			System.out.print("잘못된 입력입니다!");
		}
	}

}
