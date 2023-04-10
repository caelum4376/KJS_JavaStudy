import java.util.Scanner;

/*
 * 메소드
 *   1) 구조화된 프로그램 (문장을 기능별로 나눠서 작업)
 *   2) 반복제거 ==> Spring(AOP)
 *   3) 메소드는 한개의 기능만 수행
 *   ----------------------------------------------------
 *   리턴형 : 처리 후 결과값 (한개만 설정이 가능)
 *   매개변수 : 사용자가 요청하는 값 (여러개 보낼 수 있다)
 *             => 3개 이상이면 [], class
 *   형식)
 *      리턴형   메소드형(매개변수....)
 *                        -------- 갯수와 상관없다 (사용자의 요청값)
 *      ------   -------- 한 자바파일안에 모든 메소드명이 달라야 한다(X)
 *                        같은 메소드명이 있을 수도 있다(매개변수가 틀리면 된다)
 *      요청 결과값 (한개만) ==> 여러개 : int[], class
 *      
 *      
 *      정수 두개를 보내고 더한 값을 받는다
 *        => return a+b
 *        => System.out.println("a+b="+(a+b))
 *      단을 보내고 해당단의 구구단을 출력
 *        => 자체 출력히 편하다
 *        
 *      main메소드에서는 가급적이면 => 연결 (변수 선언(X))
 *      
 */
// void 사용
// 구구단 => 단을 입력을 받아서 => 자체에서 출력이 가능
public class 메소드_01 {
	static void gugudan(int dan) {
		for (int i=1; i<=9; i++) {
			System.out.printf("%d*%d = %d\n",dan, i, dan*i);
		}
	}
	
	static void process() {
		Scanner scan = new Scanner(System.in);
		System.out.print("단을 입력 : ");
		int dan = scan.nextInt();
		
		gugudan(dan);
	}
	public static void main(String[] args) {
		process();
	}

}
