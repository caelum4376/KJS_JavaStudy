import java.util.Scanner;

// 중첩 조건문 => 3개의 정수를 받아서 총점 / 평균 / 학점 (A+, A0, A-)
// A+ >= 97, A0 >= 94, A- >= 90
public class 조건문_05 {

	public static void main(String[] args) {

		int kor = 0, eng = 0, math = 0, total = 0;
		double avg = 0.0;
		char score = 'A', option = '-';
		Scanner scan = new Scanner(System.in);

		// 사용자의 입력값을 받는다
		System.out.print("국어, 영어, 수학 점수를 입력하세요 : ");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();

		// 결과값을 출력한다
		total = kor + eng + math;
		avg = total / 3.0;
		int temp = (int) avg;

		if (temp >= 90 && temp <= 100) {
			score = 'A';
			if (temp >= 97 && temp <= 100) {
				option = '+';
			}
			if (temp >= 94 && temp < 97) {
				option = '0';
			}
		}

		if (temp >= 80 && temp < 90) {
			score = 'B';
			if (temp >= 87 && temp < 90) {
				option = '+';
			}
			if (temp >= 84 && temp < 87) {
				option = '0';
			}
		}

		if (temp >= 70 && temp < 80) {
			score = 'c';
			if (temp >= 77 && temp < 80) {
				option = '+';
			}
			if (temp >= 74 && temp < 77) {
				option = '0';
			}
		}

		if (temp >= 60 && temp < 70) {
			score = 'd';
			if (temp >= 67 && temp < 70) {
				option = '+';
			}
			if (temp >= 64 && temp < 67) {
				option = '0';
			}
		}

		if (temp < 60) {
			score = 'F';
			option = ' ';
		}

		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		System.out.println("학점 : " + score + option);
	}

}
