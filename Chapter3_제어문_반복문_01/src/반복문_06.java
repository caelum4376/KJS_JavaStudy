import java.util.Scanner;

// updown 게임
/*
 * 컴퓨터 난수 발생 (1~100 사이의 난수)
 * => 사용자 입력
 * => 입력시에 힌트
 * => for문 횟수
 *     => 무한루프
 * 
 */
public class 반복문_06 {

	public static void main(String[] args) {
		
		// 난수 발생
		int com = (int)(Math.random()*100) + 1;
		int count = 0;
		
		// 사용자 입력
		Scanner scan = new Scanner(System.in);
		int user;
		
		// 무한루프는 while문을 주로 사용한다. => 종료시점이 필요
		for (;;) { 
			System.out.print("1 ~ 100 사이의 정답을 입력해주세요 : ");
			user = scan.nextInt();
			
			if (user >= 1 && user <= 100) {
				
				count++;
				
				if (com == user) {
					System.out.println("정답입니다!! 축하드립니다");
					System.out.println("입력 횟수 : " + count);
					System.exit(0);
				} else {
					if (com > user) {
						System.out.println("틀렸습니다. 정답보다 작습니다");
					} else {
						System.out.println("틀렸습니다. 정답보다 큽니다");
					}
				}
			} else {
				System.out.println("잘못된 입력입니다!!");
			}
		}
	}

}
