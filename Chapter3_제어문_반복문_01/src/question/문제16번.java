package question;

import java.util.Scanner;

// 숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 
// 12,1,2는 겨울, 그 외의 숫자를 입력한 경우 잘못입력을 
// 출력하는 프로그램을 작성하라. if-else 문과 switch 둘 다 이용해 볼 것.
public class 문제16번 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("달(1~12)을 입력하세요 : ");
		int num = scan.nextInt();
		
		if (num == 3 || num == 4 || num == 5) {
			System.out.println(num + "는(은) 봄입니다.");
		} else if (num == 6 || num == 7 || num == 8) {
			System.out.println(num + "는(은) 여름입니다.");
		} else if (num == 9 || num == 10 || num == 11) {
			System.out.println(num + "는(은) 가을입니다.");
		} else if (num == 12 || num == 1 || num == 2) {
			System.out.println(num + "는(은) 겨울입니다.");
		} else {
			System.out.println(num + "는(은) 잘못된 입력입니다!.");
		}
		
		switch (num) {
		case 3: case 4: case 5:
			System.out.println(num + "는(은) 봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println(num + "는(은) 여름입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println(num + "는(은) 가을입니다.");
			break;
		case 12: case 1: case 2:
			System.out.println(num + "는(은) 겨울입니다.");
			break;
		default:
			System.out.println(num + "는(은) 잘못된 입력입니다!.");
			break;
		
		}
	
		
	}

}
