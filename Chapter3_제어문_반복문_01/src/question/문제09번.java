package question;


// 9) 5,10,15,20,25,30,35,40,45,50을 출력하는 프로그램을 만들어라 (for 사용)
public class 문제09번 {

	public static void main(String[] args) {

		for (int i = 1; i <= 50; i++) {
			if (i % 5 == 0) {
				System.out.print(i + "\t");
			}
		}
		
	}

}
