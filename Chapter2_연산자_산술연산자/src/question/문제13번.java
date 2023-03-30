package question;
import java.util.Scanner;

/*
 * 두 개의 정수를 입력 받아서 첫째 수를 둘째 수로 나눈 나머지를 출력하는 프로그램을 작성해 보자.
 */
public class 문제13번 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 사용자 입력
		System.out.print("두 개의 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		// 결과 출력
		System.out.println("======결과======");
		System.out.printf("%d %% %d = %d", num1, num2, num1%num2);
	}

}
