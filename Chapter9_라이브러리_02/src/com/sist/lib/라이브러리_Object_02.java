package com.sist.lib;
// clone => 복제할 때 사용 (메모리가 새롭게 생성) => prototype

class Sawon {
	private int sabun;
	private String name;
	
	public int getSabun() {
		return sabun;
	}


	public void setSabun(int sabun) {
		this.sabun = sabun;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	// 초기화
	public Sawon (int sabun, String name) {
		
		// 지역변수 우선순위 => 멤버변수와 지역변수의 구분 => this
		// this는 자신의 객체 => static 변수, 모든클래스는 this를 가진다
		this.sabun = sabun;
		
		/*
		 * 오버로딩
		 * 생성자 ==> 여러개 사용이 가능
		 * 생성자는 무조건 한개이상이 있다.
		 * 생성자를 사용하지 않으면 자동으로 기본생성자를 추가
		 * 시작과 동시에 필요한 내용을 서술
		 * ex) 데이터베이스 연결 => 드라이버 설정 (클래스로 만들어져 있다)
		 *     thin드라이버 (연결만 해주는 역할)
		 *     윈도우 모양 설정
		 * 필요시에만 사용
		 */
	}

	
	// 재정의 => 오버라이딩 (Object)

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void print() {
		System.out.println("사번 : " + sabun + ", 이름 : " + name);
	}
	
}
public class 라이브러리_Object_02{

	public static void main(String[] args) throws CloneNotSupportedException {
		Sawon s1 = new Sawon(1, "홍길동");
		s1.print();
		
		Sawon s2 = s1;
		s2.print();
		s1.setSabun(2);
		s1.setName("심청이");
		
		// 주소를 이용할 때는 같은 주소인 경우 => 다른 객체의 내용도 변경된다
		System.out.println("s1 = " + s1 + ", s2 = " + s2);
		
		// Spring, Game(아바타)
		// 복제
		Sawon s3 = (Sawon)s1.clone(); // 새로운 메모리를 만든다
		s3.print();
		System.out.println("s3 = " + s3);
		s3.setSabun(3);
		s3.setName("박문수");
		s3.print();
		
		s1.print();
		s2.print();
	}

}
