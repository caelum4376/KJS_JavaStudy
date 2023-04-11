package question;

import java.util.Arrays;
import java.util.Scanner;
/*
 * method => 140page
 * 1) 메소드 형식 => 기능처리
 *    -----------
 *      웹 => 화면 변경
 *      --------------- 메뉴 클릭, 버튼 클릭, 이미지 클릭...
 *      검색, 글쓰기, 수정, 회원가입, 회원탈퇴...
 *      사용자의 동작과 관련
 *      리턴형 메소드형(매개변수...) { ==> 선언부
 *      	구현부
 *      }
 *    = 리턴타입 (리턴형)
 *      처리후 결과값 한개만 전송이 가능하다
 *      *** 여러개인 경우 : 배열, 클래스
 *      *** 한개인 경우 : 일반 기본형, String
 *      1) 결과값이 있는 경우
 *         리턴형 메소드명(매개변수...)
 *         ------
 *         {
 *         		return 값; 일치 ==> 리턴형이 클수도 있다
 *                     --
 *         }
 *         
 *         ex) int method() {
 *         		return (int)10.5; ==> 오류 발생
 *         }
 *         ==> int a = method(); ==> a=10
 *         double method() {
 *         		return 10;
 *         }
 *         ==> 결과값을 받아서 처리
 *             --------------------
 *             => 브라우저로 보낸다
 *             MVC
 *         ==> 자바 : 데이터 관리
 *         ==> 자바스크립트 : 이벤트 처리(브라우저)
 *             NodeJS / ReactJS / VueJS / Redux / Vuex / TypeScript / Ajax / Jquery
 *                     --------------------------------------------
 *         int[] method() {
 *         		int[] arr = {1,2,3,4,5};
 *         		return arr; // 배열 주소만 넘겨준다
 *         }
 *         ==> int[] arr = method()
 *         String method() {
 *         		return "";
 *         }
 *         ==> String s = method()
 *      2) 결과값이 없는 경우리턴
 *         void method() {
 *         ----
 *              return; // 메소드 종료
 *         }
 *         void method1() {
 *         		생략 => 컴파일러가 자동으로 추가 return
 *         }
 *         => import 추가
 *            import java.lang.* => 자동 추가
 *          ==> method()
 *    = 메소드명 => 식별자와 동일
 *                  길이에 제한이 없다 => 의미를 부여
 *                  
 *    = 매개변수 : 사용자 요청값
 *    
 *    메소드 유형
 *    -----------
 *    리턴형   매개변수
 *      O         O
 *      O         X
 *      X         O
 *      X         X
 */
public class 문제01 {

	static void process1() {

		int num = 0;
		
		// 정수 입력
		while (true) {
			System.out.print("0~32767까지의 정수 입력 : ");
			Scanner scan = new Scanner(System.in);

			num = scan.nextInt();
			
			if (num < 0 || num > 32767) {
				System.out.println("0~32767이외의 숫자입니다.");
				continue;
			}
			break;
		}
		
		// 이진법 처리
		// while
		int[] binary = new int[16];
		int index = 15;
		while(true) {
			binary[index] = num%2;
			num = num/2;
			if (num == 0) {
				break;
			}
			index--;
		}
		for (int i=0; i<binary.length; i++) {
			if (i%4 == 0 && i != 0) {
				System.out.print(" ");
			}
			System.out.print(binary[i]);
		}
		// API
		// System.out.println(Integer.toBinaryString(num));
	}
	
	// 임의의 정수를 배열로 생성해서 입력하고 정렬하는 프로그램
	static void process2() {
		int[] arr = new int[5];
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}

		System.out.println("정렬 전 : " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("정렬 후(ASC) : " + Arrays.toString(arr));
		

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("정렬 후(DESC) : " + Arrays.toString(arr));
	}
	
	// 윤년여부 판단하는 프로그램
	static void process3() {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
			System.out.println(year + "년도는 윤년입니다");
		} else {
			System.out.println(year + "년도는 윤년이 아닙니다");
		}
	}

	public static void main(String[] args) {
		process1();
		
		
	}

}
