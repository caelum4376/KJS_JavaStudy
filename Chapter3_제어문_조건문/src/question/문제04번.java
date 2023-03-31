package question;

import java.util.Scanner;

// 문제4. 사용자로부터 세 개의 정수를 입력받아, 그 수들의 최대값과 최소값, 합계와 평균을 구해보자.

public class 문제04번 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("정수를 세 개 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		// 결과 출력
		System.out.println("========결과=======");
		
		// 최대값 계산
		int maxNum = num1;
		if (num2 > num1) {
			maxNum = num2;
			if (num3 > num2) {
				maxNum = num3;
			}
		} else if (num3 > num1) {
			maxNum = num3;
		}
		
		// 최소값 계산
		int minNum = num1;
		if (num2 < num1) {
			minNum = num2;
			if (num3 < num2) {
				minNum = num3;
			}
		} else if (num3 < num1) {
			minNum = num3;
		}
		
		// 합계 계산
		int total = num1 + num2 + num3;
		
		// 평균 계산
		double avg = total/3.0;
		
		
		System.out.printf("%d, %d, %d 중 최대값은 %d입니다.\n", num1, num2, num3, maxNum);
		System.out.printf("%d, %d, %d 중 최소값은 %d입니다.\n", num1, num2, num3, minNum);
		System.out.printf("%d, %d, %d의 합계는 %d입니다.\n", num1, num2, num3, total);
		System.out.printf("%d, %d, %d의 평균은 %.2f입니다.\n", num1, num2, num3, avg);
		

	}

}
