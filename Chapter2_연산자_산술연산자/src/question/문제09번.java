package question;

public class 문제09번 {

	public static void main(String[] args) {

		int num1 = 2;
		int num2 = 7;
		int num3;
		int num4;
		num1++;
		num3 = --num1;
		--num2;
		num4 = num2++;
		
		// 2
		System.out.printf("%d\n", num3);
		
		// 6
		System.out.printf("%d\n", num4);
	}

}
