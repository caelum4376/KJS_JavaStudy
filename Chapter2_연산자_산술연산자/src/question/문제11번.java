package question;
import java.util.Scanner;

/* 
 * 사용자로부터 두 개의 정수를 입력 받아서 뺄셈과 곱셈 연산의 결과를 출력하는 프로그램을 작성
 * 
 * 1. 변수 : int a, b
 * 2. 초기화 : Scanner
 * 3. 연산처리 : a-b, a*b
 * 4. 결과 출력
 * 
 * 데이터 저장 ==========> 데이터 가공(연산처리) ==========> 결과값 출력
 *   |                         |
 * 1) 직접 값을 입력 int a = 10;  연산자                   System.out.println()
 * 2) 사용자로부터 입력을 받는다
 * 3) 난수
 * --------------------------메모리
 * 4) 파일에 읽기
 * 5) 오라클에서 값 읽기
 * 
 */
public class 문제11번 {

	public static void main(String[] args) {

		int res1, res2;
		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
				
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		
		// 결과 출력
		System.out.println("======결과======");
		res1 = num1-num2;
		System.out.println(num1 + " - " + num2 + " = " + res1);
		res2 = num1*num2;
		System.out.println(num1 + " * " + num2 + " = " + res2);
	}

}
