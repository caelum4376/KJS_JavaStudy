/*
 * 피연산자 / 연산자
 * ------ 연산 대상
 * 
 * 피연산자 1개 : 단항연산자
 * a++
 * 피연산자 2개 : 이항연산자
 * 10 + 20
 * --   --
 * 피연산자 3개 : 삼항연산자
 * 
 * 
 * 1. 단항연산자
 *    = ***증감연산자  (++, 00) 한개 증가/한개 감소 => 반복문
 *      int a=10;
 *      a++;
 *       => 11
 *      int b=10;
 *      b--;
 *       => 9
 *    = ***부정연산자  (boolean만 사용 가능) ! => 턴
 *      boolean b=true;
 *      !b;
 *       => false
 *      ====> 예약가능한 날
 *    = ***형변환연산자 (데이터형)
 *       (int)10.5 => 소수점 제거 => 10
 *       (char)65 => 'A'
 *       =========================== downcasting (강제형변환)
 *       (int)'A' => 65
 *       (double)10 => 10.0
 *       =========================== upcasting (자동형변환)
 *       
 *       10.5 + 10 = 20.5 ==> 데이터형이 동일할때 연산이 가능
 *              ---(자동형변환)
 *       10.5 + 10.0 = 20.5
 *       
 *       int이하의 데이터형은 연산시에 결과값이 int다
 *       ------- byte/short/char
 *       
 *       int + double => double
 *       char + long => long
 *       int + long => long
 *       long + double => double
 *       
 *       byte + char => int
 *       
 *    = 반전연산자 (양수->음수) 음수표현 ~
 * 
 * 2. 이항연산자
 *    산술연산자 : +, -, *, /, %
 *      => +, -, * : 데이터형
 *      => +
 *         산술연산, 문자열 결합
 *      => /
 *         정수/정수 = 정수 ==> 10/3 => 3
 *         정수/실수 => 10/3.0 => 3.3333...
 *         0으로 나누면 오류발생
 *      => % 
 *         나머지계산
 *         10 % 2 => 0
 *         11 % 2 => 1
 *         ------------
 *         5 % 2 = 1
 *         -5 % 2 = -1
 *         5 % -2 = 1
 *         -5 % -2 = -1
 *         ------------부호는 왼쪽 편을 따라간다
 *         
 *      *****+연산자
 *         10 + 9 = 19
 *         + : 문자열 결합
 *         
 *         "7" + 77 = "777"
 *         7 + "7" + 7 = "777"
 *         7 + 7 + "7" = "147"
 *         7 + "7" + 7 + 7 = "7777"
 *         7 + "7" + (7+7) = "7714"
 */
public class 연산자의종류 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		byte b = 10;
//		char c = 'A';
//		int a = b+c;
//		System.out.println(a);
		
//		byte b = 10;
//		byte c = 20;
//		int d = b + c;
//		System.out.println(~10);
		
//		int a = 10;
//		int b = a++;
//		System.out.println("a=" + a);
//		System.out.println("b=" + b);
		
//		int a = 10;
//		int b = a-- + a-- + --a;
//		System.out.println(b);
		
//		boolean bCheck = false;
//		System.out.println(bCheck);
//		System.out.println(!bCheck);
		
//		int a = (int)(Math.random()*100) + 1;
//		System.out.println(a);
		
//		int a = 10;
//		System.out.println(a/3.0);
//		System.out.println(-5%2);
		
		System.out.println("7" + 7 + 7);
		
	}

}
