/*
 * 단항연산자 (++, --)
 * 산술연산자 (쉬프트, 비트) *, / => +, - 순으로
 * ---------------------> 왼쪽에서 오른쪽으로
 * 
 * 대입연산자, 삼항연산자
 * <--------------------- 오른쪽에서 왼쪽으로
 * 
 * ()
 * ====================== 최우선 순위
 * 
 * 비교연산자 => 결과값 (boolean) => true/false
 *   == 같다
 *   != 같지 않다
 *   <  작다
 *   >  크다
 *   <= 작거나 같다
 *   >= 크거나 같다
 *   
 *   7==6 false
 *   7!=6 true
 *   ---- byte, int, short, long, float, double, boolean, char
 *   "a"=="a" => equals() *** 문자열은 별개 메소드 필요
 *   'A'<'B' 65<66 ==> true
 *   10>5 true
 *   10<=10 true 10<10 || 10==10
 */
public class 비교연산자_1 {

	public static void main(String[] args) {
		
		int a = (int)(Math.random()*100)+1;
		/*
		 * (int)(Math.random()*100)+1;
		 *       -------------
		 *        1(0.00~0.99)
		 *                   ------
		 *                   2 => 0.0~99.0
		 * --------
		 * 3 0~99
		 *                        ----
		 *                        4 1~100           
		 */
		
		int b = (int)(Math.random()*100)+1;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//1. ==
		boolean b1 = a==b;
		System.out.println("a==b : " + b1);
		
		//2. !=
		b1 = a!=b;
		System.out.println("a!=b : " + b1);
		
		//3. <
		b1 = a<b;
		System.out.println("a<b : " + b1);
		
		//4. >
		b1 = a>b;
		System.out.println("a>b : " + b1);
		
		//5. <=
		b1 = a<=b;
		System.out.println("a<=b : " + b1);
		
		//6. >=
		b1 = a>=b;
		System.out.println("a>=b : " + b1);
	}

}
