package question;

import java.util.Scanner;

// 5) 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D,
// 60점 이하면 F를 출력하라 (다중 if 사용)
public class 문제05번 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("0 ~ 100점 사이의 성적을 입력하세요 : ");
		int num = scan.nextInt();
		
		if (num >= 0 && num <= 100) {
			
			if (num >= 90) {
				System.out.print(num + "는(은) A입니다");
			} else if (num >= 80) {
				System.out.print(num + "는(은) B입니다");
			} else if (num >= 70) {
				System.out.print(num + "는(은) C입니다");
			} else if (num >= 60) {
				System.out.print(num + "는(은) D입니다");
			} else {
				System.out.print(num + "는(은) F입니다");
			}
			
		} else {
			System.out.print("잘못된 입력입니다!!");
		}
		
	}

}
