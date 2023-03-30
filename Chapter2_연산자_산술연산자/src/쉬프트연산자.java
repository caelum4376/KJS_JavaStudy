/*
 * <<, >>
 * 
 *    10<<2 => 0을 뒤에 2개 채운다
 *    1010 => 1010(00) => 40
 *    
 *    7<<3
 *    111(000) => 56
 *    
 *    8<<2
 *    1000(00) => 32
 *    
 *    x<<y ==> x*2^y
 *    ---------------
 *    9<<3
 *    
 *    ===============
 *    10>>2
 *    1010        10
 *      --제거  ==> 2
 *    10>>3
 *    1(010) ==> 1
 *    
 *    15>>3
 *    1(111) ==> 1
 *    
 *    27>>3
 *    11(011) ==> 3
 *    
 *    27 / 2^3 ==> 27/8 ==> 3
 *    
 *    x>>y ==> x/2^y
 *    
 */
public class 쉬프트연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(10<<2);
		System.out.println(7<<3);
		System.out.println(8<<2);
		
		System.out.println(10>>2);
		System.out.println(10>>3);
		System.out.println(15>>3);
		System.out.println(27>>3);
	}

}
