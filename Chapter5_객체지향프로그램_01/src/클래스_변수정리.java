/*
 * 1. 클래스 구성 요소
 * class ClassName {
 *     ----------------------
 *     변수 (인스턴스, 멤버, 공유)
 *      = 따로 저장되는 변수 (인스턴스 변수 => new)
 *      = 공통 저장 변수 (컴파일러에 의해 자동 생성) => 한 개의 메모리만 생성
 *     ----------------------
 *     메소드 (멤버메소드) => static이 없는 메소드
 *     ----------------------
 *     생성자 : 멤버변수의 초기화, 객체 생성시에 호출되는 메소드
 *     ----------------------
 * }
 * 
 * ******** class블럭에서는 연산자, 제어문을 사용할 수 없다
 *          선언만 가능하다 변수값을 지정할 때는 선언과 동시에 설정한다
 *          int i = 100;
 *          int i; i=100; ==> 오류 => 변수를 사용할 수 없다
 *          
 * ---------------------------------------------------------------------------
 * 1. 객체지향프로그램 (OOP)
 *   = 여러개의 클래스를 만들어서 => 조립하는 프로그램 => CBD
 *   ex) 웹사이트
 *       회원 : 회원가입, 회원탈퇴, 회원수정, 로그인, 로그아웃, 아이디찾기...
 *       게시판 : 글쓰기, 수정, 상세보기, 삭제, 찾기...
 *       맛집 : 목록, 상세보기, 댓글, 찾기, 추천, 예약
 * ---------------------------------------------------------------------------
 *       메뉴
 * 2. 객체 (객체지향의 객체, 객체지향의 특성(캡슐화, 다형성, 추상화, 상속))
 *    ----
 *    물리적으로 존재하는 것 (눈에 보인다)
 *     ex) 자동차, 사람, 책...
 *         자동차
 *          = 차량종류, 속도, 색상 ... 번호(속성) => 변수
 *          = 달린다, 속도높이기, 속도줄이기(동작) => 메소드
 *    추상적인 것(회사, 날씨, 동물.. 게임)
 *    
 *    사람
 *    이름
 *    성별		==> class 사람{String name, sex, jumin; int age;}
 *    주민번호
 *    나이
 *    먹는다
 *    달린다
 *    걷는다
 *    말한다
 *    
 *    2. 객체지향 => 클래스끼리 상호작용을 한다
 *           결과값 응답 (메소드)
 *       사람 ==> 계산기
 *       ---- actor
 *            요청 (메소드)
 *       웹사이트 => user
 *    class 사람 { // actor
 *      계산기
 *    }
 *    class 계산기 {
 *    
 *    }
 *    
 *    객체와 클래스
 *    
 *    집 만들기
 *    설계 ===> 집완성
 *    설계 ===> 완성(활용)(메모리에 저장)
 *    ----      ----------
 *    클래스       객체
 *                 new className() ==> 객체.메소드/변수
 *    class {
 *      변수, 메소드...
 *    }
 *    
 *    클래스로부터 객체 생서하기 위해서는 변수/메소드가 정의
 *                                        ------------
 *    클래스를 저장하면 인스턴스 (객체)
 *    A a = new A()
 *      -객체명
 *    int a = 10
 *        - 변수명
 *        
 *    => 하둡 (아들의 장난감 = 노란코끼리)
 *    => 안드로이드 : JVM(달빅)
 *    => IBM => MainFrame
 *       => 네트워크 (C/S)
 *       => 그리드 (클라우드)
 *       => 감성 (AI)
 *       1986년 ==> 스마트
 *       
 *    => 하나의 클래스로부터 여러개의 객체를 생성이 가능하다
 *    => 클래스는 한개에 대한 정보를 가지고 있다
 *    => 데이터를 따로 저장하기 위해서는 new연산자를 이용한다
 *       => new는 새로운 메모리 공간을 만들어 준다
 *       => 사용법
 *           new 클래스명()
 *       class A
 *       A a = new A()
 *       A a;
 *       a = new A()
 *       
 *       class A {
 *          int a;
 *          int b;
 *          String s; // 주소는 4byte
 *          static int d; // 12byte
 *       }
 *       
 *       변수
 *       이름
 *       성별
 *       나이
 *       --------
 *           class Human {
 *               String name;
 *               String sex;
 *               int age;
 *           }
 *    
 *    
 */
public class 클래스_변수정리 {

	public static void main(String[] args) {

	}

}
