package com.sist.exception;
/*
 * 배열에 데이터를 저장 ==> 배열범위 초과
 * 나누기를 처리
 * 기타 예외처리
 */
public class 예외처리_예외복구_04 {

	public static void main(String[] args) {
		try {
			int[] arr = new int[2];
			arr[0] = 10;
			arr[1] = 2;
			System.out.println(arr[0] / arr[1]);
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("배열범위 초과");
			
		} catch (ArithmeticException e) {
			
			System.out.println("0으로 나눌 수 없다");
			
		} catch (RuntimeException e) { // 가장 상위의 예외처리는 가장 마지막에 캐치해야한다
			
			System.out.println("예측 못한 에러!!!");
			
		}
		System.out.println("프로그램 종료");
	}

}
