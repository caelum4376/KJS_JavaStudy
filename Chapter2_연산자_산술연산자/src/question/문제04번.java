package question;

public class 문제04번 {

	public static void main(String[] args) {

		int num1 = 1, num2 = 2, num3 = 3, num4 = 4, num5 = 5;
		num1 = num1 + num2;
		num2 = num2 - 2;
		num3 = num3 * 2;
		num4 = num4 / 2;
		num5 = num5 % 2;
		
		// 3, 0, 6, 2, 1
		System.out.printf("%d, %d, %d, %d, %d \n", num1, num2, num3, num4, num5);

	}

}
