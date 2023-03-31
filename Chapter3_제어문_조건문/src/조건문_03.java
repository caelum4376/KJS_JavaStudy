import java.util.Scanner;

// 3개의 정수를 입력을 받아서 총점 / 평균 / 학점
public class 조건문_03 {

	public static void main(String[] args) {
		
		int kor, eng, math;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어, 영어, 수학 점수를 입력하세요 : ");
		kor = scan.nextInt();
		eng = scan.nextInt();
		math = scan.nextInt();
		
		//결과값을 출력
		System.out.println("========결과========");
		
		int total = kor + eng + math;
		double avg = total/3.0;
		int temp = (int)avg;
		char score = 'A';

		if (temp >= 90 && temp <= 100) {
			score = 'A';
		} 
		if (temp >= 80 && temp < 90) {
			score = 'B';
		}
		if (temp >= 70 && temp < 80) {
			score = 'C';
		}
		if (temp >= 60 && temp < 70) {
			score = 'D';
		}
		if (temp < 60) {
			score = 'F';
		}
		
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %.2f\n", avg);
		System.out.println("학점 : " + score);
	}

}
