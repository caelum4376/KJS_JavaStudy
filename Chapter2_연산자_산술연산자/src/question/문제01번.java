package question;
/*
 * System.out.printf()
 * 서식이 있는 출력
 * 
 * %d => 정수값
 * %f => 실수값
 * %c => 문자
 * %s => 문자열
 *  
 */
public class 문제01번 {

	public static void main(String[] args) {
//		int a;
//		int b;
//		a = 3;
//		b = a + 5;
//		
//		// a의 값 : 3
//		System.out.printf("a의 값: %d \n", a);
//		
//		// b의 값 : 8
//		System.out.printf("b의 값: %d \n", b);

		
		int a = 10;
		double d = 10.5;
		char c = 'A';
		
		System.out.println("a = " + a + ", d = " + d + ", c = " + c);
		System.out.printf("a = %3d, d = %.2f, c = %c", a, d, c);
		
	}

}
