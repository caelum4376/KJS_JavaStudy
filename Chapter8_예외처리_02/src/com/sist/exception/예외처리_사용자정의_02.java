package com.sist.exception;
import java.util.*;
/*
 * 자신 ===> 객체효율 (this), 생성자(this())
 * 상위클래스 ==> 객체 호출 (super), 생성자 (super())
 * 
 * class A {
 * 
 * }
 * class B extends A {
 * 
 * }
 * 
 * B b = new B(); ==> new A(), new B()
 *                    -------  -------
 *                     super     this
 */
class MyRuntimeException extends RuntimeException {
	public MyRuntimeException(String msg) {
		super(msg);
	}
}
public class 예외처리_사용자정의_02 {

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("정수 입력 : ");
			int score = scan.nextInt();
			if (score < 0) {
				throw new MyRuntimeException("음수는 사용할 수 없습니다");
				// 장점 => 에러위치 확인이 가능
				// 사용자 정의 클래스를 호출할 때 사용
			}
		} catch (MyRuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("--------------------에러 발생 위치 확인--------------------");
			e.printStackTrace();
		}
	}

}
