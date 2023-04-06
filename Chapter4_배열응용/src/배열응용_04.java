import java.util.Scanner;

/*
 * 숫자 야구게임
 * 1. 컴퓨터 => 임의의 숫자 3개 발생 (1~9까지 중복없는 난수)
 *    3 6 9
 * 2. 사용자 숫자를 입력해서 발생된 난수를 맞추는 게임
 * 3. 힌트
 *    2 9 6
 *    ---> 0S-2B
 *    3 7 8
 *    ---> 1S-0B
 *    3 9 8
 *    ---> 1S-1B
 */
public class 배열응용_04 {

	public static void main(String[] args) {
		
		int[] com = new int[3]; // 난수 => 저장
		int[] user = new int[3]; // 입력
		for (int i=0; i<com.length; i++) {
			com[i] = (int)(Math.random()*9)+1;
			for (int j=0; j<i; j++) {
				if (com[i] == com[j]) {
					i--;
					break;
				}
			}
		}
		
		// 사용자가 입력
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("세 자리 정수입력 : ");
			int input = scan.nextInt();
			
			if (input < 100 || input > 999) {
				System.out.println("잘못된 입력값입니다!!");
				continue; // 처음부터 다시 수행(while)
			}
			
			// 세 자리 정수를 입력했다면
			user[0] = input/100;  // 369/100 => 3
			user[1] = (input%100)/10;  // 369%100 => 69/10 => 6
			user[2] = input%10;  // 369%10 => 9
			
			// 1. 같은 정수를 입력하면 안된다
			if (user[0] == user[1] || user[1] == user[2] || user[0] == user[2]) {
				System.out.println("중복된 수는 사용하 수 없습니다");
				continue;
			}
			
			// 2. 0을 포함할 수 없다
			if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
				System.out.println("0은 사용할 수 없습니다");
				continue;
			}
			
			
			// 힌트 준비
			int s = 0, b = 0;
			for (int i=0; i<com.length; i++) {
				for (int j=0; j<user.length; j++) {
					if (com[i] == user[j]) {
						if (i == j) {
							s++;
						} else {
							b++;
						}
					}
				}
			}
			
			// 힌트 제공
			// System.out.printf("Input : %d, Result : %dS - %dB\n", input, s, b);
			
			System.out.println("========");
			System.out.print("S : ");
			for (int i=0; i<s; i++) {
				System.out.print("●");
			}
			System.out.print("\nB : ");
			for (int i=0; i<b; i++) {
				System.out.print("○");
			}
			System.out.println("\n========");
			// 종료 시점 ==> S=>
			if (s == 3) {
				System.out.println("Game Over!!");
				break;
			}
					
		}
	}

}
