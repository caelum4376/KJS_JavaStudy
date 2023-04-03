/*
 * 자바에서 지원하는 반복문
 * -----------------------------
 * for : 반복 횟수가 지정된 경우에 주로 사용 => 2차(중첩) => 코테
 *   = 일반 for
 *   = for-each : 출력용 (웹에서 가장 많이  등장 : 향상된 for) *** 배열, 컬렉션
 * while : 반복 횟수를 모르는 경우 (선 조건)
 * do~while : 반복 횟수를 모르는 경우 (후 조건) => 무조껀 1이상은 수행이 가능하다
 * 
 * => 유사한 내용을 여러번 출력을 할때 주로 사용
 *       합계구하기, 통계... 목록 출력...
 * => 형식)
 *       for
 *       for (int i = 1; i <= 10; i++) {			=> 10번 수행
 *           for (초기값; 조건식; 증감식) {
 *               반복 실행문장
 *           }
 *       }
 *       초기값 : 시작점 ==> 한번만 수행
 *       조건식 : 수행을 중단할 때 (종료점)
 *       증감식 : 초기값 ~ 조건식 => false 일때까지 수행
 *       ------ 감소도 가능
 *       for (int i=10; i >= 1; i--) 
 *       
 *       증가는 여러개 증가도 가능하다
 *       for (int i=1; i<10; i+=2) i=1, i=3, i=5...
 *       										------- 복합 대입연산자 i+=5, i+=10...
 *       
 *       실행순서 (****프로그램에서 가장 많이 사용되는 제어문 : for, if)
 *       
 *       => for문은 한문장 만 수행이 가능
 *            여러문장 사용시에는 {}을 이용해서 처리한다
 *        => for (초기값; 조건식; 증감식) {
 *        				반복실행문장(sir)
 *        
 *        초기값 (초기
 *        }
 *        
 *        
 *        
 *       
 */
public class 반복문_01 {

	public static void main(String[] args) {
		
		System.out.println("===========for문 이용===========");
		
			for (int i = 1; i <= 10; i++) {
			
				System.out.println(i + ". Hello Java");
			
			}
			
			System.out.println("===========for문 이용===========");
			
			for (int i = 0; i < 10; i++) {
				
				System.out.println(i + ". Hello Java");
				
			}
				
			// 번복문 이용
		}

}
