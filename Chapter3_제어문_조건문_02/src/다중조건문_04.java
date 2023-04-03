import java.util.Scanner;

/*
 * 성적 계산 ==> A+(97점 이상), A0, A-
 * 
 */
public class 다중조건문_04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("세 개의 정수를 입력 : ");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		int avg = (kor+eng+math)/3; //학점 계산

		System.out.println("총점 : " + (kor+eng+math));
		System.out.printf("평균 : %.2f\n", (kor+eng+math)/3.0);
		
		// 학점 계산
		char score = 'F'; // 값이 변경이 없는 경우에 처리되는 값(default)
		char option = '+';
		
		if (avg >= 90) {
			score = 'A';
			if (avg >= 97) {
				option = '+';
			} else if (avg >= 94) {
				option = '0';
			} else {
				option = '-';
			}
		} else if (avg >= 80) {
			score = 'B';
			if (avg >= 87) {
				option = '+';
			} else if (avg >= 84) {
				option = '0';
			} else {
				option = '-';
			}
		} else if (avg >= 70) {
			score = 'C';
			if (avg >= 77) {
				option = '+';
			} else if (avg >= 74) {
				option = '0';
			} else {
				option = '-';
			}
		} else if (avg >= 60) {
			score = 'D';
			if (avg >= 67) {
				option = '+';
			} else if (avg >= 64) {
				option = '0';
			} else {
				option = '-';
			}
		} else { // 생략이 가능
			score = 'F';
			option = ' ';
		}
		
		System.out.println("학점 : " + score+option);
	}

}
