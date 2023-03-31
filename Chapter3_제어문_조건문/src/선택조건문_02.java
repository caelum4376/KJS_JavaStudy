import java.util.Scanner;

// 한개의 점수를 받아서 60이상 합격, 그렇지아니면 불합격
public class 선택조건문_02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		if (num >= 60) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
		}
		
	}

}
