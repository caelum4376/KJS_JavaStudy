package com.sist.util;
import java.util.*;
/*
 *   Calendar : Date클래스를 보완해서 새롭게 만든 클래스
 *   1) Calendar 생성
 *      Calendar cal = Calendar.getInstance();
 *      -------- 추상클래스
 *   2) 날짜 설정 => set()
 *   3) 날짜 읽기 => get()
 *   4) 각달의 마지막날
 *      getActualMaxium()
 *   5) 요일 읽기
 *      get()
 */
public class 라이브러리_Calendar_01 {

	public static void main(String[] args) {
		
		// 필요시에는 오버라이딩을 해서 사용한다
		// new를 사용하지 않는 경우 => 추상클래스, 인터페이스
		/*
		 *   기능을 가지고 있다 => 추상클래스 (구현된 메소드, 구현이 안된 메소드)
		 *   기능을 가지고 있지 않다 => 인터페이스 (구현이 안된 메소드)
		 *   List list = new ArrayList() => 인터페이스
		 *   
		 */
		Calendar cal = Calendar.getInstance(); // 오늘날짜를 읽어온다
		
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		
		// System.out.println("년도 : " + cal.get(1));
		// Month는 0번부터 시작
		System.out.println("월 : " + (cal.get(Calendar.MONTH)+1));
		
		System.out.println("일 : " + cal.get(Calendar.DATE));
		
		System.out.println("시간 : " + cal.get(Calendar.HOUR));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("이번 달의 마지막날 : " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		// week => 1~7
		String[] week = {"","일","월","화","수","목","금","토"};
		
		System.out.println("요일 : " + week[cal.get(Calendar.WEEK_OF_MONTH)-1]);
	}

}
