package com.sist.string;
import java.io.*;
public class 라이브러리_String_02 {

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i=0; // 문자 읽기 => int로 읽는다
			StringBuffer data = new StringBuffer();
			while ((i = fr.read()) != -1) {
				data.append((char)i);
			}
			long end = System.currentTimeMillis();
			
			fr.close();
			System.out.println(data);
			System.out.println("걸린 시간 : " + (end-start));
			
		} catch (IOException e) {
			e.printStackTrace(); // 에러메세지 확인 (위치o)
			// getMessage() => 에러만 확인 (위치x)
		}
	}

}
