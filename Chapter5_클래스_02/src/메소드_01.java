/*
 *  변수      연산자   제어문     출력
 *  ----      ------   ------     ----
 *   |           |        |         |
 *  배열       명령문             Application
 *  클래스    -------             -----------
 *             메소드             Web Application
 *  ---------------------------------------------
 */
public class 메소드_01 {
	static void isYea(int year) {
		if ((year%4 == 0 && year %100 != 0) || (year % 400 == 0)) {
			System.out.println(year + "년도는 윤년입니다!!");
		} else {
			System.out.println(year + "년도는 윤년이 아닙니다!!");
		}
	}
	public static void main(String[] args) {

	}

}
