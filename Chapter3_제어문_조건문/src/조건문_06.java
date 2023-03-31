import java.util.Scanner;

// 년도를 입력을 받아서 윤년여부를 확인
// 1. 4년마다
// 2. 100년마다 제외
// 3. 400년마다
// (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) 윤년조건
public class 조건문_06 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 사용자로 부터 입력받음
		System.out.print("년도를 입력하세요 : ");
		int year = scan.nextInt();
		
		// 윤년여부 연산
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(year + "년도는 윤년입니다.");
		}
		if (!(((year % 4 == 0 && year % 100 != 0)) || (year % 400 == 0))) {
			System.out.println(year + "년도는 윤년이 아닙니다.");
		}
		
	}

}
