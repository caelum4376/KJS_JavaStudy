/*
 * 이항연산자
 * 피연산자가 2개 
 * ------------
 *   ***1) 산술연산자 (+, -, *, /, %)
 *   2) 쉬프트연산자 (비트이동연산자) (<<, >>)
 *   3) 비트연산자 (&, |, ^)
 *   ***4) 비교연산자 (==, !=, <, >, <=, >=)
 *   ***5) 논리연산자 (&&(직렬), ||(병렬)) : 효율적인 연산
 *         && => true
 *         (조건) && (조건)
 *         ----     ----
 *         false    수행x
 *         
 *         || => true
 *         (조건) || (조건)
 *         ----     ----
 *         true     수행x
 *   ***6) 대입연산자 (=, +=, -=, op=)
 *   
 *   38page => 산술연산자
 *   +, -, * => 형변환 *** 자바에서 모든 연산은 같은 데이터형끼리만 연산이 된다
 *              ----
 *              int + double
 *              ---- double
 *              double + double => double
 *              ex)
 *                 10+20.5
 *                 --
 *                 10.5+20.5 => 30.5
 *                 자동으로 큰 데이터형으로 변경 후에 연산을 한다(업스케일링)
 *                 ***char는 모든 연산자를 이용해서 연산처리하면 => 자동으로 int로 변환된다
 *                 'A' < 60
 *                 ---
 *                 65  < 60 => false
 *                 ***int이하(byte,short,char)데이터형 연산시에 결과값은 int
 *                 int+long => long
 *                 int+double => double
 *                 char+long => long
 *                 byte+int => int
 *                 char+char => int
 *                 byte+byte => int
 *   / : 정수/정수 = 정수
 *       5/2 = 2
 *       10/3 = 3
 *       => 평균 : 정수/실수
 *       0으로 나누면 에러 발생
 *       프로그램의 기본 (코테)
 *       ----------------
 *       1) 오류처리 
 *       ex) 문자열을 입력받아서 좌우대칭
 *       
 *   % : 결과값은 왼쪽 부호가 남는다
 *       5 % 2 = 1
 *       -5 % 2 = -1
 *       5 % -2 = 1
 *       -5 % -2 = -1
 */
// 사용자가 정수 세개를 입력 => 결과값(1.총점, 2.평균)
// 키보드로부터 입력된 값을 얻어오는 클래스 : Scanner (scanf())
// BufferdReader => 예외처리가 필요
import java.util.Scanner; // 외부에서 클래스를 불러옴

public class 산술연산자_1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // 클래스 선언
		//             ---동적 메모리 할당
		//                         ----------키보드 입력값
		
		System.out.print("국어 점수를 입력 :");
		int kor = scan.nextInt();
		System.out.println("kor = " + kor) ;
		System.out.print("수학 점수를 입력 :");
		int math = scan.nextInt();
		System.out.println("math = " + math) ;
		System.out.print("영어 점수를 입력 :");
		int eng = scan.nextInt();
		System.out.println("eng = " + eng) ;
		
		// 총점
		int total = kor + math + eng;
		System.out.println("총점 : " + total);
		
		// 평균
		double avg = total/3.0;
		System.out.printf("평균 : %.2f", avg);
		
	}

}
