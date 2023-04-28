package com.sist.lib;
import java.util.*;
class Student {
	
	// 데이터 보호 => 은닉화
	private String name;
	private int age;
	
	// 캡슐화
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// 주소값은 hashCode와는 다르다
	@Override
	public int hashCode() {
		return (name+age).hashCode();
	}
	
	// 주소가 아닌 값으로 같음을 판정
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Student) {
//			Student s = (Student)obj;
//			return name.equals(s.name) && age==s.age;
//		}
//		return false;
//	}
	
//	@Override
//	public String toString() {
//		return name + "(" + age + ")";
//	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
}
public class 라이브러리_Set_02 {

	public static void main(String[] args) {
		Set set = new HashSet();
		Student s1 = new Student("홍길동", 25);
		Student s2 = new Student("홍길동", 25);
		
		System.out.println(s1);System.out.println(s2);
		
		// equals를 오버라이딩해서 값을 비교 했기 때문에 같음으로 판정
		if (s1.equals(s2)) {
			System.out.println("s1==s2");
		} else {
			System.out.println("s1!=s2");
		}
		
		set.add(new Student("홍길동", 25));
		set.add(new Student("홍길동", 25));
		
		System.out.println(set);
	}

}
