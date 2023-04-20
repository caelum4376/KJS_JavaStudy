package com.sist.main;
/*
 * 232page
 * --------- 추상클래스 (abstract)
 *           => 메소드 관련 (구현이 안된 메소드)
 *              -------------------------------- 상속 관련 (오버라이딩)
 *              ** 오버라이딩
 *                 ----------
 *                  => 상속을 받아서 기존의 기능을 변경해서 사용하는 기법 (modify)
 *                  => 조건
 *                  1) 상속관계가 존재 
 *                     => 추상클래스는 단독으로 사용이 불가능
 *                        미완성된 클래스
 *                     => 사용법은 상속을 내린 후에 상속을 받을 클래스를 통해서 메모리 할당이 되는 상태
 *                        class A
 *                        class B extends A
 *                        => A a = new B();
 *                        => A a = new A(); => 오류
 *                  2) 메소드명 동일
 *                  3) 리턴형 동일
 *                  4) 매개변수가 동일
 *                  5) 접근지정어는 확대 / 축소하면 오류 발생
 *                     ----------
 *                     private < default < protected < public
 *              *** 기본목적 : 여러개의 클래스를 모아서 한개의 이름으로 제어
 *                             ------                   ----
 *              *** 프로그램 설계 (미완성된 클래스)
 *                  = 요구사항분석
 *                    벤치마킹 : 여러개 사이트를 참조
 *                    ex) 로그인 => 10000개의 레시피
 *                        회원가입 => 망고플레이트
 *                        예약 => CGV
 *                        결제 => 옥션
 *                    = 프로그램에 맞게 구현해서 사용
 *                      ex)
 *                         void getConnection();
 *                         => 데이터베이스 연결
 *                         => 오라클 / MS-SQL / MySQL / MariaDB...
 *                            ------            ---------------
 *                             | XE (단점 => 50이상X)
 *                 = 한개의 객체로 여러개를 제어하는 프로그램
 *                    게시판
 *                    갤러리게시판
 *                    댓글형게시판
 *                    묻고답하기
 *                    ------------
 *           추상클래스
 *           ==========
 *            ==> 공통적으로 사용하는 부분 (코딩 내용이 다르게 만들 경우)
 *            ex)
 *                  게시판 : 목록출력, 찾기, 글쓰기, 수정하기, 삭제하기
 *                  묻고답하기 : 목록출력, 찾기, 글쓰기, 수정하기, 삭제하기, 답변하기
 *                  댓글게시판 : 목록출력, 찾기, 글쓰기, 수정하기, 삭제하기, 댓글
 *                  후기게시판 : 목록출력, 찾기, 글쓰기, 수정하기, 삭제하기, 업로드
 *                  
 *                  abstract class Board {
 *                      목록출력();
 *                      찾기();
 *                      글쓰기();
 *                      내용보기();
 *                      수정하기();
 *                      삭제하기();
 *                  }
 *                  *** 권장 사항 ==> 한개 이상의 추상메소드를 포함한다
 *                                                ---------- 구현이 안된 메소드
 *                      abstract void find();
 *                      Board content() {}
 *                      void write() {}
 *                      
 *           추상클래스의 특징
 *           1) 단일상속 => extends
 *           2) 메소드가 구현이 안된 것이 있으면 미완성 클래스 => 메모리에 단독으로 저장이 불가능
 *              abstract class A
 *              => A a = new A() => X
 *           3) 상속을 내려서 구현된 클래스를 이용해서 메모리 할당
 *              abstract class A
 *              class B extends A
 *              ----------------- 구현이 안된 메소드를 구현한다
 *              => A a = new B(); 묵시적 형변환
 *                 double d = 10; 자동형변환
 *              => A a = new B();
 *                 B b = (B)a; ==> 명시적 형변환
 *              *** 클래스는 상속관계, 포함관계 => 크기를 잴 수 있다
 *              상속을 내리는 클래스 > 상속을 받는 클래스
 *              포함하고 있는 클래스 > 포함되는 클래스
 *              
 *              class A
 *              class B extends A ==> A>B ==> is-a
 *              
 *              class A {
 *                B b = new B();
 *              }
 *              class B ==> A>B ==> has-a
 *           4) 목적 : 관련된 여러 클래스를 묶어서 한개의 이름으로 관리
 *                     ------------------
 *                      => 공통적인 기능
 *                      => 버스, 마을버스, 고속버스, 좌석
 *                         ------------------------------ 버스 (추상클래스)
 *                      => 개, 돼지, 말...
 *                         ------------------------------ 동물
 *                      => 선, 네모, 삼각형, 원...
 *                         ------------------------------ 도형
 *                      => red, green, blue...
 *                         ------------------------------ color
 *           5) 선언된 메소드가 있는 경우 => 상속시 반드시 구현해야 된다 (강제성)
 *                      
 */

abstract class A {
	public abstract void aaa();
	public void bbb() {}
	public void ccc() {}
	public void ddd() {}
	public abstract void eee();
}

class B extends A {

	@Override
	public void aaa() {
	}

	@Override
	public void eee() {
	}

	
}

abstract class 도형 {
	public abstract void draw();
	public void color() {
		System.out.println("검정색");
	}
}

class 선 extends 도형 {

	@Override
	public void draw() {
		System.out.println("선을 그린다");
	}
	
}

class 원 extends 도형 {

	@Override
	public void draw() {
		System.out.println("원을 그린다");
	}
	
}

class 네모 extends 도형 {

	@Override
	public void draw() {
		System.out.println("네모를 그린다");
	}
	
}

/*
 * 1. 일반 클래스 => new (O)
 * 2. 추상 클래스 => 구현 후 사용
 * 3. 인터페이스 => 추상클래스와 동일 (O)
 * 4. 종단 클래스 => 상속해서 확장이 불가능
 * 5. static => 메모리 => 클래스명으로 접근
 */
public class 추상클래스 {

	public static void main(String[] args) {
		// 오버라이딩 기법
		도형 a = new 선();
		a.draw();
		a = new 원();
		a.draw();
		a = new 네모();
		a.draw();
		// OutputStream out;
	}

}
