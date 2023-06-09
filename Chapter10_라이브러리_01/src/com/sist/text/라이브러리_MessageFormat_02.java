package com.sist.text;

import java.text.MessageFormat;

/*
 *   국어 : 90
 *   영어 : 90
 *   수학 : 90
 *   총점 : 270
 *   평균 : 90.0
 *   ---------------
 *   국어  영어  수학  총점  평균
 *    90    90    90    270  90.0
 *    
 *   MessageFormat ==> 오라클 SQL문장 작성
 *                              SQL
 *       브라우저 ======> 자바 ======> 오라클
 *                <======      <======
 *                  HTML
 */
public class 라이브러리_MessageFormat_02 {

	public static void main(String[] args) {
		
//		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
//		String msg = "{0}\t{1}\t{2}\t{3}\t{4}\t{5}\t";
		
		String msg = "이름 : {0}\n국어 : {1}\n영어 : {2}\n수학 : {3}\n총점 : {4}\n평균 : {5}";
		
		Object[] obj1 = {"홍길동", 90, 90, 90, 270, 90.0};
		Object[] obj2 = {"심청이", 90, 90, 90, 270, 90.0};
		Object[] obj3 = {"박문수", 90, 90, 90, 270, 90.0};
		
		System.out.println(MessageFormat.format(msg, obj1));
		System.out.println("=======================");
		System.out.println(MessageFormat.format(msg, obj2));
		System.out.println("=======================");
		System.out.println(MessageFormat.format(msg, obj3));
	}

}
