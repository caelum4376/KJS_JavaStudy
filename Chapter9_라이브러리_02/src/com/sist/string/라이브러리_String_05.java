package com.sist.string;

// concat : 문자열 결합 (+)
/*
 * String s1 = "Hello ";
 * String s2 = "Java";
 * s1.concat(s2) ==> "Hello Java";
 * 
 * ===> concat ==> MySQL LIKE 문장을 만들 때
 *      WHERE name LIKE CONCAT('%', '홍', '%')
 *      WHERE name LIKE '%'||홍||'%'
 * 
 * endsWith : 끝나는 문자열이 같은 경우에 사용
 * boolean endsWith(String s)
 * String concat(String s)
 * -------------------------------------------------
 * charAt()
 * equals() : 대소문자 구분, equalsIgnorcase() : 대소문 구분없이 비교,
 * -------- ID, PWD          ------ 영어검색, 영문이름
 * indxOf(), lastIndexOf(), --- 뒤에서부터 찾는다
 * ------ 위치확인 (문자/문자열)
 * ------ 앞에서부터 찾기
 * length() : 문자의 갯수
 * startsWith() : 시작문자열이 같은 경우 => 서제스트
 * endsWith() : 끝문자열이 같은 경우
 * substring() : 원하는 문자열을 자르는 경우
 * trim() : 공백 제거
 * split() : 특정문자로 자르는 경우
 * contains() : 포함문자열인지 확인 
 * valueOf() : 모든 데이터형을 문자열 변환
 */
public class 라이브러리_String_05 {

	public static void main(String[] args) {
//		String s1 = "Hello ";
//		String s2 = "Java!!";
//		System.out.println(s1.concat(s2));
//		System.out.println(s1 + s2);
//		
//		if (s1.endsWith("o ")) {
//			System.out.println(s1 + "는 o로 끝났다");
//		} else {
//			System.out.println(s1 + "는 o로 끝나지 않았다");
//		}

//		String[] data = {"JAVA", "java", "Java", "JAva", "JAVa", "jaVA", "javA"};
//		for (String s:data) {
//			if (s.equals("java")) { // equals는 대소문자를 구분해서 비교
//				System.out.println(s);
//			}
//		}

		// 원형 : boolean equals(String s)
		// 라이브러리 => 1) 기능 2) 리턴형 3) 매개변수 4) 사용처 => 로그인, 상세보기
//		System.out.println("===== equalsIgnorcase() =====");
//		for (String s:data) {
//			if(s.equalsIgnoreCase("java")) {
//				System.out.println(s);
//			}
//		}

		// equalsIgnoreCase : 대소문자를 구분하지 않고 비교
		// 원형 : boolean equalsIgnoreCase(String s)
		// 사용처 : 검색, 영문이름, 영문으로 된 데이터를 찾는 경우
		// 한글 => equals
		// 한글 => 자동으로 찾기 => 사용자 정의 (자바, 오라클)
		System.out.println("=========== length() ==========");
		String[] data2 = { "apple 사과", "avocado 아보카도", "banana 바나나", "blackberry 블랙베리", "blueberry 블루베리",
				"cherry tomato 체리 토마토, 방울 토마토", "cherry 체리", "coconut 코코넛", "grape 포도", "kiwi 키위", "lemon 레몬",
				"lime 라임", "mango 망고", "melon 멜론", "orange 오렌지", "papaya 파파야", "peach 복숭아", "pear 배", "persimmon 곶감",
				"pineapple 파인애플", "plum 자두", "strawberry 딸기", "tangerine 귤", "tomato 토마토", "watermelon 수박" };

		// length() : 문자갯수
		// 원형 : int length()
		// 사용처 : 문자제한이 있는 경우, 비밀번호
		// 오라클 => VARCHAR2(10) let a="" let a=10 val var
		// 1. 각 과일명의 문자길이를 출력
		for (String s : data2) {
			System.out.println(s + " : " + s.length());
		}
		System.out.println("=========================");
		System.out.println("가장 긴 이름의 과일명을 출력하시오");

		int max = 0;

		for (int i = 1; i < data2.length; i++) {
			if (data2[i].length() > data2[max].length()) {
				max = i;
			}
		}

		System.out.println("가장 긴 이름을 가진 과일은 " + data2[max] + "입니다");

		// startsWith => 시작문자열이 같은 경우
		// 원형 : boolean startsWith(String s)
		// 사용처 : 자동 완성기 (검색기), 쿠키 검색
		// 쿠키 => key는 중복없이 => 구분 : hotel1 hotel2...
		System.out.println("========= startsWith =========");

		for (String s : data2) {
			if (s.startsWith("p")) {
				System.out.println(s);

//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//					
//				}
			}
		}

		// 좌우 공백 제거
		// 원형 : String trim()
		// 사용처 : 로그인, 회원가입, 검색...
		// 사용자가 입력시 => space
		// String id = "admin" => " admin"
		System.out.println("========= trim() =========");

		String id = "admin";
		if (id.equals(" admin")) {
			System.out.println("같은 ID입니다");
		} else {
			System.out.println("다른 ID입니다");
		}

		// contains : 포함문자열을 찾을 경우
		// 원형 : boolean contains(String s)
		// 사용처 : 검색, 추천
		// 추천 => 네이버블로그, 카페 => 포함된 영화명...
		System.out.println("========= contains =========");
		for (String s : data2) {
			if (s.contains("w")) {
				System.out.println(s);
			}
		}

		// valueOf : String에서 유일한 static메소드
		// 모든 데이터형을 문자열로 변환
		// 원형 : static String valueOf((type)) => 오버로딩된 상태
		// 사용처 : 자바에서 윈도우 전송, 네트워크 전송, 웹(String만 인식)
		System.out.println("========= valueOf() =========");

		System.out.println(String.valueOf(10) + String.valueOf(30));

		// substring(), indexOf(), lastIndexOf()
		// substring() : 문자열을 자르는 경우
		// 오버로딩
		// substring(int s) => s번째부터 마지막까지 잘라온다
		// substring(int s, int e) => s번째부터 e-1까지 잘라온다
		// 원형 : String substring(int s)
		// String substring(int s, inte)
		// 사용처 : URL주소 제어, 주소 제어, 문자열이 긴 경우...
		System.out.println("========= substring =========");

		String ss = "http://localhost:8080/JSPProject/main/main.do";
		String res = ss.substring(ss.lastIndexOf("/") + 1);

		System.out.println(res);
		ss = ss.substring(ss.indexOf("//") + 2);
		System.out.println(ss);
		res = ss.substring(0, ss.indexOf("/"));
		System.out.println(res);

		ss = "서울특별시 용산구 소월로2길 27지번 서울시 용산구 후암동 445-8";
		res = ss.substring(0, ss.indexOf("지"));

		System.out.println(res.trim());

		res = ss.substring(ss.indexOf("지") + 2);
		System.out.println(res.trim());

		ss = "홍길동, 이순신, 강감찬, 박문수, 을지문덕, 심청이, 춘향이";

		// 특수문자별로 잘라서 배열에 저장
		// 원형 : String[] split(String regexp)
		// 구분이 되어있는 문자열이 있는 경우 분리
		String[] names = ss.split(",");

		for (String s : names) {
			System.out.println(s);
		}

		ss = "1인사시미" + "22,000원" + "항정살구이" + "22,000원" + "토마토스튜" + "22,000원" + "브루스게타" + "18,000원" + "닭다리살숯불구이"
				+ "18,000원";
		String[] menu = ss.split("원");
		
		for (String m:menu) {
			System.out.println(m + "원");
		}
		
		ss = "red|blue|green|black|shite|yellow";
		String[] colors = ss.split("\\|"); // 정규식에서 사용하는 기호
		
		for (String color:colors) {
			System.out.println(color);
		}
		
		// replace() : 문자/문자열 변경
		// 원형 : String replace(char old, char new)
		//        String replace(String old, String new)
		System.out.println("========= replace =========");
		
		// 오라클에 저장 ==> & (Scanner)
		ss = "https://i.namu.wiki/i/i6I4KWDaGF-RsnX0DJL5BsPp6T3--5kPLBtImi4e38Bh9nUR141VsjSWegXQ-obchty81Vj7gMWBf2Dcr0-S-d9iveQQ1Qe1bOTGjBysUF_r2zFkCF8J64-4B3OJQTKRMMRa0ZTZE-4wRdwYm7vsrQ.webp";
		res = ss.replace("&", "@");
		System.out.println(res);
		System.out.println(res.replace("@", "&"));
		
		// 데이터 수집 => html을 제거...
	}

}
