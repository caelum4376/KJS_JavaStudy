package question;

import java.util.Scanner;

// 3) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 정수의 절대값을 출력하라
public class 문제03번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int num = scan.nextInt();
	
		System.out.print("a = " + (~num+1));
	}

}
