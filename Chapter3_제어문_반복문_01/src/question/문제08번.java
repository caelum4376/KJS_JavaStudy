package question;

// 8) 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
public class 문제08번 {

	public static void main(String[] args) {

		int sum = 0;
		
		for (int i = 2; i <= 100; i+=2) {
			sum += i;
		}
		System.out.print("2 + 4 +...+ 100의 합 : " + sum);
		
	}

}
