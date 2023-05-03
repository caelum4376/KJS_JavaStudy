package com.sist.io;
// 파일 쓰기


import java.io.*;
public class 입출력_03 {

	public static void main(String[] args) {
		

		FileWriter out = null;
		// BufferedWriter		

		FileReader in = null;
		// BufferedReader
			
		try {
			// 1. 파일만들기
			File file = new File("c:\\java_datas\\movie.txt");
			if (!file.exists()) { // 파일이 존재하지 않는다면
				
				// 파일을 생성
				file.createNewFile();
			}
			long start = System.currentTimeMillis();
			// 파일 읽기
			in = new FileReader("c:\\javaDev\\movie.txt");
			out = new FileWriter(file);
			
			// 생성된 파일쓰기
			int i=0;
			while ((i=in.read())!=-1) {
				out.write(i);
			}
			
			System.out.println("파일 읽기/쓰기 완료");
			long end = System.currentTimeMillis();
			System.out.println("읽은 시간 : " + (end-start));
			
		} catch (Exception e) {
			
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				
			}
		}
	}

}
