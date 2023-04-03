import java.util.Scanner;

/*
 * 다중조건문 : 조건이 맞는 문장을 수행하고 종료 (한 개 문잔만 수행)
 *          => 여러 개를 수행 : 단일 조건문을 사용해야 된다
 * ex) 1~100까지 숫자 중 3의 배수, 5의 베수, 7의 배수의 합을 출력한다
 *                    ---------------------- 단일 3개 사용
 * 형식)
 *     if (조건문) {
 *        true일 때 수행하는 문장 작성 ==> 종료
 *        false
 *     } else if (조건문) {
 *        true일 때 수행하는 문장 작성 ==> 종료
 *        false                
 *     } else if (조건문) {
 *        true일 때 수행하는 문장 작성 ==> 종료
 *        false
 *     } else {
 *        해당조건이 없는 경우에 처리되는 문장
 *     } ----- 생략이 가능
 *                   
 */

// 사칙연산 쳐리
public class 다중조건문_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 정수");
		int num2 = scan.nextInt();
		System.out.print("두 번째 정수");
		int num1 = scan.nextInt();
		System.out.print("연산자 입력(+, -, *, /) : ");
		char op = scan.next().charAt(0); // 문자열 중에 첫번째에 문자를 추출
		
		// 경우 +, -, 
		
		if ( op == '+' ) {
			System.out.printf("%d+%d=%d\n", num1, num2, num1+num2);
		} else if (op == '-') {
			System.out.printf("%d-%d=%d\n", num1, num2, num1-num2);
		} else if (op == '*') {
			System.out.printf("%d*%d=%d\n", num1, num2, num1*num2);
		} else if (op == '/') {
			if (num2 == 0) {
				System.out.println();
			} else {
				System.out.printf("%d/%d=%d\n", num1, num2, num1/num2);
			}
		}
				
	}
}

