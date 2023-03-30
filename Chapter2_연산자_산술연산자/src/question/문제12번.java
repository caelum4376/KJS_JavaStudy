package question;
import java.util.Scanner;

/*
 * 사용자로부터 세 개의 정수를 입력받은 다음에 곱과 합을 순서대로 진행해서 그 결과를 출력하는 프로그램을 작성해 보자. 
 * 예를 들어 사용자로부터 순서대로 입력받은 세 개의 정수가 1, 2, 3 이라면 
 * 1 * 2 + 3의 계산 결과를 출혁해야 한다. 단 출력 양식은 다음과 같아야 한다.
 */
public class 문제12번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 사용자 입력
		System.out.print("세 개의 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();

		// 결과 출력
		System.out.println("======결과======");
		System.out.printf("%d * %d + %d = %d", num1, num2, num3, num1 * num2 + num3);
	}

}
