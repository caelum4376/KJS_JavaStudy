package question;

public class 문제10번 {

	public static void main(String[] args) {
		int i = 0;
		int re = 0;
		i = 3;
		re = ++i;
		
		// re : 4, i : 4
		System.out.println("re : " + re + ", i : " + i);
		
		i = 3;
		re = i++;
		
		// re : 3, i : 4
		System.out.println("re : " + re + ", i : " + i);
	}

}
