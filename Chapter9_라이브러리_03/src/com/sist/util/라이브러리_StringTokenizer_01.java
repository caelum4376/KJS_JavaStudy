package com.sist.util;
import java.util.*;
/*
 *   StringTokenizer : 문자열 관리
 *    1) split() => 대체
 *    2) 빅데이터 / 네트워크 / 웹
 *    ----------------------------
 *    기능 
 *     = 생성자
 *       StringTokenizer st = new StringTokenizer ("구분할 문자열", 구분자)
 *       StringTokenizer st = new StringTokenizer ("구분할 문자열")
 *       
 *       ex)
 *       String s1 = "애니메이션/어드벤처/코미디"
 *       String s2 ="박서준 아이유 김종수 고창석 정승길 이현우"
 *       StringTokenizer st = new StringTokenizer (s1, "/") => /
 *       StringTokenizer st = new StringTokenizer (s2) => 공백
 *       
 *     = 기능
 *       1) countTokens() : 분리된 데이터 갯수
 *       2) nextToken() : 분리된 데이터 읽기
 *       3) hasMoreTokens() : 분리 갯수만큼 루프수행
 *       
 */
public class 라이브러리_StringTokenizer_01 {

	public static void main(String[] args) {
		String s1 = "애니메이션/어드벤처/코미디";
		StringTokenizer st = new StringTokenizer(s1, "/");
		System.out.println(st.countTokens());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
		String s2 ="박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 남민우 이승준 김남우 주광현 박성준"
				+ " 박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 남민우 이승준 김남우 주광현 박성준"
				+ " 박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 남민우 이승준 김남우 주광현 박성준"
				+ " 박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 남민우 이승준 김남우 주광현 박성준"
				+ " 박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 남민우 이승준 김남우 주광현 박성준"
				+ " 박서준 아이유 김종수 고창석 정승길 이현우 양현민 홍완표 허준석 이하늬 남민우 이승준 김남우 주광현 박성준";
		StringTokenizer st2 = new StringTokenizer(s2);
//		System.out.println(st2.countTokens());
//		int a = st2.countTokens();
//		for (int i=0; i<a; i++) {
//			System.out.println(st2.nextToken());
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		
		}
	}

}
