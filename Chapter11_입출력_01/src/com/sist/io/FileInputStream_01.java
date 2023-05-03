package com.sist.io;
/*
 *    FileInptStream : 단위 byte (1byte씩 읽어준다)
 *      => 한글포함된 데이터는 읽을 수 있는데 한글이 깨진다
 *         ----------------- FIleReader
 *         .zip, .ppt, .png... => 업로드/다운로드
 *         ----------------- 웹에서 자료실, 갤러리 게시판 만들기
 *      => 주요메소드
 *         read() => 1byte => 리턴형 => int
 *         close() 닫기
 *      => 생성자
 *         new FileInputStream(File file)
 *         new FileInputStream(String path)
 *    
 */

import java.util.*;
import java.io.*;
public class FileInputStream_01 {

	public static void main(String[] args) {
		
		try {
			
			// 파일 읽기
			// System.in / System.out
			// 표준 입출력
			FileInputStream fis = new FileInputStream("c:\\javaDev\\javaStudy\\Ch");
			
			// 문자번호를 받는 변수
			int i=0; // 1개의 문자를 읽어 온다 => 문자번호를 넘겨준다
			
			// -1은 더이상 읽을 데이터가 없을때까지 => EOF(End Of File) -1
			while((i=fis.read())!=-1) {
				System.out.println((char)i);
			}
		
		} catch (Exception e) {
			
		}
	}

}
