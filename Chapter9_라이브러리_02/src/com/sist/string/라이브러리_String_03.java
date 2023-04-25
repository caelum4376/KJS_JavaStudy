package com.sist.string;

import java.util.Scanner;

// String메소드 (문자열 제어하는 기능)
/*
 *    String은 문자열 배열
 *    ------ 문자마다 인덱스 번호를 가지고 있다 (0부터 시작)
 *    String s = "Hello Java"
 *                0123456789  ==> 오라클은 1번
 *                자바 => == != substring(0, 3) => 0123
 *                오라클 => = <> substr(1, 5)
 *                자바스크립트 === !==
 *    주요기능 (310page)
 *    1) 문자열에서 문자 한개 추출 => char charAt(int index)
 *    
 */
public class 라이브러리_String_03 {

	public static void main(String[] args) {
		String msg = "Hello Java";
//		for (int i=0; i<msg.length(); i++) {
//			System.out.println((i+1)+"번째 문자 : " + msg.charAt(i));
//		}
		
		// 코딩 테스트 문제 => msg를 거꾸로 출력하는 프로그램을 작성
//		String msg1 = "Hello Java";
//		for (int i=msg.length()-1; i>=0; i--) {
//			System.out.println((i+1)+"번째 문자 : " + msg.charAt(i));
//		}
		
		// 알파벳 문자열을 입력받아서 대문자 몇개, 소문자 몇개를 출력하는 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.print("알파벳 문자 입력 : ");
		String user = scan.nextLine(); // 공백으로 자르면 next(), 공백을 자르지 않고 전부 가져오면 nextLine()
		int upper=0;
		int lower=0;
		
		for (int i=0; i<user.length(); i++) {
			if (user.charAt(i) >= 'A' && user.charAt(i) <= 'Z') {
				upper++;
			} else if (user.charAt(i) >= 'a' && user.charAt(i) <= 'z'){
				lower++;
			}
		}
		System.out.println(user + "의 대문자는 " + upper + "개, 소문자는 " + lower + "개입니다.");
	}

}
