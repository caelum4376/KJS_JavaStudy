package question;

import java.util.Scanner;

/*
 * 문제3. 1학년부터 4학년까지 중간고사 시험을 보았다. 
 *       4학년은 70점 이상이면 합격, 그 이외의 학년은 60점 이상이면 합격이다. 
 *       이를 판단하는 프로그램을 작성해보자.
 *       점수가 0미만 100초과이면 경고문구 출력! 
 *
 *  if (score < 0 || score > 100) {
 *  	경고메세지
 *  } else {
 *  	if (grade == 4) {
 *  		if (score >= 70) {
 *  			합격	
 *  		} else {
 *  			불합격
 *  		}
 *  	} else {
 *  		if (score >= 60) {
 *  			합격	
 *  		} else {
 *  			불합격
 *  		}
 *  	}
 *  
 *  }
 */
public class 문제03번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 사용자 입력
		System.out.print("학년과 점수를 입력하세요 : ");
		int grade = scan.nextInt();
		int score = scan.nextInt();

		// 결과 출력
		if (grade == 4) {
			if (score >= 70 && score <= 100) {
				System.out.println("합격입니다!");
			} else if (score > 100 || score < 0){
				System.out.println("잘못된 점수입니다.");
			} else {
				System.out.println("불합격입니다.");
			}
		} else {
			if (score >= 60 && score <= 100) {
				System.out.println("합격입니다!");
			} else if (score > 100 || score < 0){
				System.out.println("잘못된 점수입니다.");
			} else {
				System.out.println("불합격입니다.");
			}
		}
	}

}
