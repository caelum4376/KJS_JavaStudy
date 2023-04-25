package com.sist.lib;
// equals => Object에서는 객체비교 String에서는 문자열
class Student2 {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student2(String name) {
		this.name = name;
	}

	// .형변환 보가 우선순위다
	// (10+2)*5 20
	// 재정의를 하지 않는 경우 ==동일하다
	// Object => equals는 사용빈도가 많지 않다 => 오버라이딩을 사용해야 된다
	// => String ... equals
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Student2) {
			return name == ((Student2)obj).name;
		} else {
			return false;
		}
	}
	
	public void print() {
		System.out.println("이름 : " + name);
	}
}
/*
 * String s = "Hello";
 * s.length();
 * ="Hello".length();
 * 
 */
public class 라이브러리_Object_04 {

	public static void main(String[] args) {
		Student2 s1 = new Student2("홍길동");
		Student2 s2 = new Student2("홍길동");
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		
		if (s1 == s2) {
			System.out.println("s1과 s2는 같습니다");
		} else {
			System.out.println("s1과 s2는 같지 않습니다");
		}
		
		// 주소 = default
		if (s1.equals(s2)) {
			System.out.println("s1과 s2는 같습니다");
		} else {
			System.out.println("s1과 s2는 같지 않습니다");
		}
		
		s1.print();
		new Student2("박문수").print();
		"Hello".length();
	}

}
