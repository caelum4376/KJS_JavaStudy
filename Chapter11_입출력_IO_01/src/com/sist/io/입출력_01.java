package com.sist.io;
/*
 *    = 변수, 연산자, 제어문
 *    = 객체지향프로그램
 *    = 예외처리
 *    --------------------------------- 문법 사항
 *    = 라이브러리
 *      => 자바 라이브러리
 *      => 오라클 관련 (라이브러리)
 *      => Web 관련 라이브러리
 *      => 스프링 관련 라이브러리
 *      => 외부업체 라이브러리 (Jsoup, JSON, MyBatis, JPA)
 *    --------------------------------- Back-End
 *    Front-End
 *    --------- HTML/CSS/JavaScript(ES6)
 *                            |
 *                       JQuery(AJAX)
 *                       ***VueJS ----------> Vue3, VueX
 *                       ***ReactJS --------> Redux, Mobx
 *                       NodeJS
 *                       TypeScript
 *                       ----------
 *    ---------------------------------
 *    IO => InputStream / OutputStream
 *          ---------------------------
 *              |              |
 *             입력           출력
 *        => 입출력시 사용하는 라이브러리
 *           ======
 *           1) 메모리 입출력 => 표준입출력
 *                               System.in, System.out
 *           2) 파일 입출력 => 웹) 업로드 / 다운로드
 *              => XML(SpringFramework), JSON(JavaScript연동), Properties(Spring-Boot)
 *              => 외부에서 데이터 읽기 임시 저장용(txt)
 *              => CSV => 오라클 데이터 백업
 *                 --- MySQL, MsSQL, MariaDB
 *              => MySQL => 오라클 => CSV
 *                 ------------------------ seoul.go.kr, data.go.kr
 *           3) 네트워크 입출력 : 웹서버 이미 구현 (톰캣)
 *           -------> 저장/읽기/수정/삭제 => CURD
 *           
 *           자바 => 입출력을 하기 위한 장치
 *                   ----------------------- 스트림 (데이터가 이동하는 통로)
 *           데이터 이동
 *           -----------
 *            1byte 이동         /         2byte 이동
 *            ----------                   ----------
 *            ~InputStream                  ~Reader
 *            ~OutputStream                 ~Writer
 *            -------------                 -------
 *            바이트 스트림                 문자 스트림
 *            => byte                       => char ==> 메소드(read(), write())
 *            => read(), write()
 *            => IO => CheckedException => 예외처리가 기본
 *                  => IO 라이브러리 사용시 => 반드시 닫기 => close()
 *                  
 *        = 지원하는 라이브러리
 *          FileInputStream FileOutputStream
 *          FIleReader      FileWriter
 *          --------------------------------
 *          ObjectInputStream ObjectOutputStream => 객체단위 저장
 *          => 속도가 느리다 => 속도를 빠르게 => Buffer
 *        = Buffer => 데이터를 모아서 한번에 전송
 *                    => 속도가 빠르다
 *                    입출력 : BufferedReader, BufferedWriter
 *                             --------------  --------------
 *                             String          String
 *                    => 이사 => 관련된 데이터를 묶어서 한번에 이동
 */
import java.util.*;
import java.io.*;
public class 입출력_01 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		try {
			
			long start = System.currentTimeMillis();
			
			// 파일 복사 ==> 업로드
			// BufferedInputStream
			fis = new FileInputStream("C:\\util\\eclipse-jee-2023-03-R-win32-x86_64.zip");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// BufferedOutputStream
			fos = new FileOutputStream("c:\\java_datas\\eclipse-b.zip");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int i=0;
			byte[] buffer = new byte[1024];
			while((i=fis.read(buffer, 0, 1024)) != -1) {
				bos.write(buffer, 0, i);
			}
			
			
			
			long end = System.currentTimeMillis();
			System.out.println("파일복사 시간 : " + (end-start));
		} catch (Exception e) {
			
			// 오류 확인 (모니터링)
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				
			}
		}
	}

}
