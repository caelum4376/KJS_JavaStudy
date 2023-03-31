package question;

import java.util.Scanner;

// 문제7. 정수 3개를 입력받아서 총점과 평균을 구하고 학점을 구하는 프로그램
// 작성 ( 90이상이면 A,80이상이면 B, 70이상이면 C,60이상이면 D, 나머지는 F)

public class 문제07번 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("정수를 세 개 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		// 결과 출력
		System.out.println("========결과=======");
		
		// 총점
		int total = num1 + num2 + num3;
		
		// 평균
		double avg = total/3.0;
		
		// 학점
		char score = 'A';
		
		if (avg >= 90 && avg <= 100) {
			score = 'A';
		} else if (avg >= 80 && avg < 90) {
			score = 'B';
		} else if (avg >= 70 && avg < 80) {
			score = 'C';
		} else if (avg >= 60 && avg < 70) {
			score = 'D';
		} else {
			score = 'F';
		}
		
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		System.out.println("학점 : " + score);
	}

}
