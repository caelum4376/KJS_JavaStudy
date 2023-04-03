import java.util.Scanner;

/*
 * // 특별한 경우가 아니면 거의 사용빈도가 없다
 * switch() {
 *     case 값:
 *         switch() {
 *         
 *         }
 * }
 */
// 가위바위보
/*
 * 가위
 *     가위
 *     바위
 *     보
 * 바위
 *     가위
 *     바위
 *     보
 * 보
 *     가위
 *     바위
 *     보
 */
public class 선택문_04 {

	public static void main(String[] args) {
		
		// 컴퓨터가 먼저 가위바위보를 설정
		int com = (int)(Math.random()*3); // 0(가위), 1(바위), 2(보)
		
		// 사용자 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보(2) 입력 : ");
		int user = scan.nextInt();
		
		switch (com) {
		case 0: 
			System.out.println("컴퓨터 : 가위");
			break; // 종료
			// break밑에 소스 코딩이 있는 경우 오류 발생
		case 1: 
			System.out.println("컴퓨터 : 바위");
			break; // 종료
		case 2: 
			System.out.println("컴퓨터 : 보");
			break; // 종료
		}
		switch (user) {
		case 0: 
			System.out.println("플레이어 : 가위");
			break; // 종료
		case 1: 
			System.out.println("플레이어 : 바위");
			break; // 종료
		case 2: 
			System.out.println("플레이어 : 보");
			break; // 종료
		}

		// 비교(처리) => 결과값을 출력
		switch(com) {
		case 0: // 가위
			switch(user) {
			case 0: // 가위
				System.out.println("비겼다!!");
				break;
			case 1: // 바위
				System.out.println("사용자 Win!!");
				break;
			case 2: // 보
				System.out.println("컴퓨터 Win!!");
				break;
			}
			break;
		case 1: // 바위
			switch(user) {
			case 0: // 가위
				System.out.println("컴퓨터 Win!!");
				break;
			case 1: // 바위
				System.out.println("비겼다!!");
				break;
			case 2: // 보
				System.out.println("사용자 Win!!");
				break;
			}			
			break;
		case 2: // 보
			switch(user) {
			case 0: // 가위
				System.out.println("사용자 Win!!");
				break;
			case 1: // 바위
				System.out.println("컴퓨터 Win!!");
				break;
			case 2: // 보
				System.out.println("비겼다!!");
				break;
			}
			break;
		}
		
		// 변수 설정 => 변수에 대한 처리 => 결과값을 출력
		
		
	}

}
