package question;

// 라이브러리, 사용자정의 => 클래스가 다른 폴더에 저장된 경우
// 생략이 가능한 라이브러리 => java.lang.* => Math, String, Object...
// 주로 사용하는 라이브러리 => java.util, java.text, java.io, java.net
// java.sql => 1.0버전부터
// javax~~ => 1.2버전(Web)부터
// 기타 => 외부에서 만든 라이브러리 => 대게 org/com으로 시작
import java.util.Scanner;

// 1) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 양수인지 음수인지 판별하여 출력하라
public class 문제01번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		if (num >= 0) {
			
			System.out.print(num + "는(은) 양수입니다.");
			
		} else {
			
			System.out.print(num + "는(은) 음수입니다.");
			
		}
		
	}

}
