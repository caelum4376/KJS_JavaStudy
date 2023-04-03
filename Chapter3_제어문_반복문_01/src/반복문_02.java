// 1~100까지의 합
public class 반복문_02 {

	public static void main(String[] args) {

		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum = sum + i; // sum+=i
			System.out.println("sum = " + sum + ", i = " + i);
		}
		
		System.out.println("======최종결과값======");
		System.out.println("1~100까지의 합 : " + sum);

		sum = 0; // 값을 변경 => 다시 누적
		
		for (int i = 2; i <= 100; i+=2) {
			sum = sum + i;
		}
		
		System.out.println("======최종결과값======");
		System.out.println("0~100까지의 짝수의 합 : " + sum);

		sum = 0;
		
		for (int i = 1; i <= 100; i+=2) {
			sum = sum + i;
		}
		
		System.out.println("======최종결과값======");
		System.out.println("0~100까지의 홀수의 합 : " + sum);

		sum = 0;
		
		for (int i = 3; i <= 100; i+=3) {
			sum = sum + i;
		}
		
		System.out.println("======최종결과값======");
		System.out.println("0~100까지의 3의 배수의 합 : " + sum);
	
	}

}
