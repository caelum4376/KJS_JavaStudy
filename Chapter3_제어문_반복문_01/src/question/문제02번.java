package question;

import java.util.Scanner;

// 2) 한 개의 정수를 입력 받아 3의 배수인지 판별하여 출력하라
public class 문제02번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int num = scan.nextInt();
	
		if (num % 3 == 0) {
			System.out.println(num + "는(은) 3의 배수 입니다");
		} else {
			System.out.println(num + "는(은) 3의 배수가 아닙니다");
		}
	}

}
