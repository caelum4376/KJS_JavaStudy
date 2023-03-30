// 조건문 (if)

public class 비교연산자_2 {
	
	public static void main(String[] args) {
		
		// 'A' = 65, 'a' = 97 => char은 연산시 정수로 변경 후에 처리
		char c1 = (char)((Math.random() * 26) + 65);
		char c2 = (char)((Math.random() * 26) + 65);
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);

		boolean b1 = c1==c2;
		System.out.println("c1==c2 = " + b1);
		
		b1 = c1!=c2;
		System.out.println("c1!=c2 = " + b1);

		b1 = c1<c2;
		System.out.println("c1<c2 = " + b1);

		b1 = c1>c2;
		System.out.println("c1>c2 = " + b1);

		b1 = c1<=c2;
		System.out.println("c1<=c2 = " + b1);

		b1 = c1>=c2;
		System.out.println("c1>=c2 = " + b1);
	}
}
