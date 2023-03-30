package question;

public class 문제06번 {

	public static void main(String[] args) {
		
		int num1 = 10, num2 = 10;
		int a, b;
		a = ++num1;
		b = num2++;

		// 11, 11, 10, 11
		System.out.printf("%d, %d, %d, %d \n", a, num1, b, num2);

	}

}
