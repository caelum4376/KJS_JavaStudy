package question;

/*
 * 반복제어문
 * => 특정부분을 제외 반복 수행 (continue)
 *    while	: 조건식
 *    for	
 * => 반복 종료 (break)
 */
public class 문제_01 {

	public static void main(String[] args) {
		int sum = 0, i = 1;
		while (i < 100) {
			if (i % 3 != 0) {
				i++;
				continue;
			} else {
				sum += i;
				i++;
			}
		}
	}

}
