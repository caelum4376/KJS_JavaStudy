package question;

// 13) 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 
public class 문제13번 {

	public static void main(String[] args) {

		int sum = 0;
		
		for (int i = 1; i <=10; i++) {
			if (i % 2 == 0) {
				sum -= i;
			} else {
				sum += i;
			}
		}
		System.out.println("합계는 : " + sum);
	}

}
