
// 1-2+3-4+5-6+7-8+9-10 ==> 값
public class 반복문_04 {

	public static void main(String[] args) {
	
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				sum += i;
			} else if (i % 2 == 0) {
				sum -= i;
			}
		}
		
		System.out.println("======최종결과값======");
		System.out.println("0~10까지의 수열의 합 : " + sum);
	}

}
