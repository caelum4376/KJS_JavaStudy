/*
 * 1. 클래스의 구성요소
 * class ClassName {
 * -------------------
 * 1) 변수 설정
 * -------------------
 * 3) 생성자 설정 => 필요시에만 사용 
 *                => 설정하지 않을 경우에는 컴파일러가 자동으로 생성자를 만들어 준다
 * -------------------
 * 2) 메소드 설정
 * -------------------
 * }
 * 
 * 1) 변수의 종류
 *    -----------
 *    클래스 영역에 선언하는 변수 (멤버변수) ==== heap
 *      = 인스턴스 변수 : new를 사용할때 저장되는 변수 (new설정에 따라 따로 저장)
 *        = 클래스객체명.변수명
 *        Card c1 = new Card()
 *            --- 변수 여러개 저장 (. => 주소 접근연산자)
 *        c1.number
 *      = 정적 변수 : 한개의 공간에 저장되는 변수
 *        Card c1 = new Card()
 *        c1.number
 *        Card.number (*******)
 *      ------------ 프로그램 종료시까지 사용되는 변수
 *    메소드 영역에 선언하는 변수 (지역변수) ==== stack
 *      ------------ 메소드가 종료되면 사라지는 변수
 *      1) 메소드 영역에 선언되는 변수
 *         void aaa() {
 *             int a=10;
 *         }
 *      2) 매개변수
 *         void aaa(int a) {
 *         }
 *         
 *   자바 메모리 구조
 *  -------------------------------
 *   Method Area => method, static
 *  -------------------------------
 *   Stack : 메모리 자체에서 관리 (생성/소멸) => 블럭변수
 *           매개변수, 지역변수
 *           => 변수의 초기화가 안된다 (반드시 초기화 후 사용)
 *  ------------------------------- => 메모리에서 자동으로 저장
 *   Heap : 프로그래머 영역 (직접 메모리 크기를 지정해서 저장)
 *          자동소멸이 안된다 => GC (System.gc())
 *  -------------------------------
 *    heap, method area => 변수 저장시에 자동 초기화가 된다
 *    class ClassName {
 *        int a; => 0
 *        double d; => 0.0
 *        boolean b; => false
 *        char c; => '\u00000'
 *        long l; => 0L
 *        String s; => null
 *        **null은 참조타입 => 주소를 가지고 있지 않은 상태
 *        ex)
 *           String s; String s=""; "" => 주소
 *           int[] arr;
 *    }
 *  -------------------------------------------------------------------------------------
 *    변수유형			선언위치			메모리 저장						사용범위		
 *  -------------------------------------------------------------------------------------
 *    인스턴스변수     클래스블럭          new : 새로운 저장공간을 만든다	클래스 전체
 *                    class ClassName {    heap메모리에 저장
 *                        int a;
 *                    }
 *  -------------------------------------------------------------------------------------
 *    정적변수         클래스블럭          컴파일시 자동 저장
 *                    class ClassName {
 *                        static int a;
 *                        => 많이 사용되는 변수는 아님
 *                    }
 *  -------------------------------------------------------------------------------------
 *    지역변수        class ClassName {     메소드 호출시마다               메소드 안에서만 사용
 *                        void display() {
 *                            int a=10;
 *                        }
 *                    }
 *                    반드시 초기화
 *  -------------------------------------------------------------------------------------
 *  1) 메모리 저장
 *     메모리에 저장된 상태 : 인스턴스 (객체)
 *     설계 (어떤 데이터를 저장) ==> 메모리에 저장 =================> 활용 ============> 소멸(메모리 해제)
 *     class ClassName {             ClassName c = new ClassName()    c.변수명          c = null gc()
 *         String s;                                   ----------     c.메소드명()
 *         int a;                                        생성자
 *     }
 *     
 *     String s ="";
 *     s.substring()
 *     s.trim()
 *     
 *     Scanner scan = new Scanner(System.in)
 *     scan.nextInt()
 *     
 *     *** 클래스는 한개에 대한 정보 설계
 *     맛집 : 5000개
 *     --------------- new
 *     
 */
class Student {
	String name;
	int kor;
	int eng;
	int math;
	
}
public class 사용자정의_데이터형_01 {

	public static void main(String[] args) {
		Student s1 = new Student();
		// s1 = name, kor, eng, math
		System.out.println("s1 = " + s1);
		s1.name = "홍길동";
		s1.kor = 90;
		s1.eng = 80;
		s1.math = 78;
		
		Student s2 = new Student();
		// s2 = name, kor, eng, math
		System.out.println("s2 = " + s2);
		s2.name = "심청이";
		s2.kor = 80;
		s2.eng = 70;
		s2.math = 68;
		
		Student s3 = new Student();
		// s3 = name, kor, eng, math
		System.out.println("s3 = " + s3);
		s3.name = "강감찬";
		s3.kor = 90;
		s3.eng = 70;
		s3.math = 88;
		
		System.out.println(s1.name + " " + s1.kor + " " + s1.eng + " " + s1.math);
		System.out.println(s2.name + " " + s2.kor + " " + s2.eng + " " + s2.math);
		System.out.println(s3.name + " " + s3.kor + " " + s3.eng + " " + s3.math);
		
	}

}
