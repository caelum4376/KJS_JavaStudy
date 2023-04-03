package question;

import java.util.Scanner;

// 11) 한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라
public class 문제11번 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int num = scan.nextInt();
		int sum = 0;
		
		if (num >= 1) {
			for (int i = 1; i <=num; i++) {
				sum += i;
			}
		} else if (num < 1) {
			for (int i = 1; i >=num; i--) {
				sum += i;
			}
		}
		
		System.out.printf("1부터 %d까지의 합은 %d입니다.", num, sum );
	}

}
