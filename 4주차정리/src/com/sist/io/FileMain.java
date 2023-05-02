package com.sist.io;

import java.io.*;
public class FileMain {

	public static void main(String[] args) {
		
		try {
			/*
			// file 설정
			File file = new File("c:\\javaDev\\school.txt");

			// file 존재여부확인
			if (!file.exists()) { // 파일이 존재하지 않는 경우
				file.createNewFile();
			}
			System.out.println("파일 만들기 성공...");
			*/
			
			/*
			File dir = new File("c:\\java_datas");
			if (!dir.exists()) {
				dir.mkdir();
				System.out.println("폴더 만들기 완성");
			}
			*/
			
			File dir = new File("c:\\javaDev");
			File[] files = dir.listFiles();
			for (File f:files) {
				if (f.isFile()) {
					System.out.println(f.getName() + " " + f.length());
				} else if (f.isDirectory()) {
					System.out.println(f.getName() + " DIR");
				}
			}
		} catch (Exception e) {
			
		}
	}

}
