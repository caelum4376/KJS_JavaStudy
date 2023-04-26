package com.sist.lang;
// delete, insert => 원본 변경
// substring => 원본 변경이 없다
public class 라이브러리_StringBuffer_02 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("홍길동입니다");
		
		sb.delete(3, 6); // delete(int s, int e) => e-1
		System.out.println(sb.toString());
		
		sb.insert(3, "입니다");
		System.out.println(sb.toString());
		
		// substring은 자체변경이 아닌 새로운 메모리에 리턴한다
		sb.substring(3);
		System.out.println(sb.toString());
		System.out.println(sb.substring(3).toString());
	}

}
