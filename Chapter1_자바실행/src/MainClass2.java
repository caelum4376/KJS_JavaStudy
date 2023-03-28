
public class MainClass2 {
	
	public static void main(String[] args) {
		// 프로그램의 시작점 / 끝점
		/*
		 * 정수
		 * ---
		 * 2진법
		 * 8진법
		 * 16진법
		 * 
		 * 29 => 2진법
		 * 32 16 8 4 2 0(1)
		 *     1 1 1 0 1	=> 11101
		 *     
		 * 76 => 2진법
		 * 64 32 16 8 4 2 0(1)
		 * 1  0  0  1 1 0 0		=> 1001100
		 */
		System.out.println(0b11101);
		System.out.println(0b1001100);
		
		// 10진법 -> 2진법 
		System.out.println(Integer.toBinaryString(29));
		
		// 10진법 -> 8진법
		System.out.println(Integer.toOctalString(29));
		
		// 10진법 -> 16진법
		System.out.println(Integer.toHexString(29));
		
		System.out.println("c:\\dev");
		System.out.print("Hello\n");
		System.out.println("Hello");
		
		// 10+20+30 표현법
		System.out.println(10+"+"+20+"+"+30);
		System.out.printf("%d+%d+%d", 10, 20, 30);
	}
	
}
