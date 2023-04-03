
// 1~100 사이의 반복 수행
// 11, 22, 33, 44, 55...
// 두 개는 같은 정수입니다. / 두 개는 다른 정수입니다. => 메세지 출력
public class 반복문_07 {

	public static void main(String[] args) {

		for (int i = 10; i <= 99; i++) {
			if (i % 11 == 0) {
				System.out.println(i + "두 개는 같은 정수입니다.");
			} else {
				System.out.println(i + "두 개는 다른 정수입니다.");
			}
		}
		
	}

}
