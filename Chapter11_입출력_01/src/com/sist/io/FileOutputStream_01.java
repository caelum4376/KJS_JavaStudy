package com.sist.io;

import java.util.*;
import java.io.*;
public class FileOutputStream_01 {

	public static void main(String[] args) {
		try {
			
			// 파일 지정
			File file = new File("c:\\java_datas\\school.txt");
			
			// 파일존재여부 확인
			if (!file.exists()) {
				file.createNewFile(); // 파일만들기 명령
			}
			
			// 파일이 존재할때 사용
			FileOutputStream fos = new FileOutputStream(file);
			String msg = "안녕하세요 지금은 파일입출력하고 있습니다\r\n";
//			System.out.println((int)'안');
			
			// String => byte[]로 변경 => getBytes()
			fos.write(msg.getBytes());
			
			fos.close();
			System.out.println("저장 완료!!");
			
		} catch (Exception e) {
			
		}
	}

}
