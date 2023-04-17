package com.sist.main;
import static java.lang.Math.random;
/*
 * import 패키지명.클래스명
 * import 패키지명.*
 * import static java.lang.Math.random;
 * java.lang.* => 자동로딩이 된다, import를 사용하지 않는다
 * ----------- String, Math
 * 
 * void method() {
 *   return; // 자동 설정 (생략이 가능) => void에서만
 *   ==> 중간에 존재할 때도 있다
 * }
 * class A {
 *   A(){}
 * }
 */
public class 클래스_메소드 {

	public static void main(String[] args) {
		
		int a = 10;
		if (a%2==0) {
			System.out.println("a=" + a);
			return;
		}
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
	}

}

