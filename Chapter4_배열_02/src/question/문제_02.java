package question;
/*
 * 1에서 50까지의 합을 더하는 while문이다. 빈칸에 적절한 코드를 넣어라
 * 
 */
public class 문제_02 {

	public static void main(String[] args) {
		
		int sum = 0, i=1;
		while (true) {
			if (i>50) break;
			sum+=i;
			i++;
		}

		System.out.println(sum);
	}
}
