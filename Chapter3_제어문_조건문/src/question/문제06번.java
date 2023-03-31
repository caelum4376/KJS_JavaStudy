package question;

import java.util.Scanner;

// 문제6. 임의의 문자를 추출하여 대문자인지 소문자인지 확인하는 프로그램 작성
public class 문제06번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("영문자 하나를 입력하세요 : ");
		char alp = scan.next().charAt(0);

		if (alp >= 'A' && alp <= 'Z')
			System.out.println(alp + "는(은) 대문자입니다.");
		else if (alp >= 'a' && alp <= 'z')
			System.out.println(alp + "는(은) 소문자입니다.");
		else
			System.out.println("영문자를 입력해주세요");
	}

}
