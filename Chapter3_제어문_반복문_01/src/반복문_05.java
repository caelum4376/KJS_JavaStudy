import java.util.Scanner;

// 사용자의 입력을 받아서 (구구단) => 3
public class 반복문_05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요 : ");
		int dan = scan.nextInt();
		
		System.out.println("======" + dan + "단======");
		for (int i = 1; i <= 9; i++ ) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}

}
