package com.sist.io;
// 파일읽기
// FileInputStream (1byte) / FileReader (2byte)
// 한글이 포함 ==> 반드시 2byte씩 읽어야 => 한글깨짐 방지가 가능

import java.io.*;
public class 입출력_02 {

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("C:\\javaDev\\movie.txt");
			BufferedReader in = new BufferedReader(reader);
			
			int i=0; // 한글자씩 읽기 => read()
			// int read() => 글자의 ASC코드를 읽어온다 (정수)
			// A => read() => 65
			// int read(byte[], int, int) => 읽은 바이트수
			
			long start = System.currentTimeMillis();
			

			// -1 => 읽을 데이터가 없는 경우 => 전체 데이터를 읽은 경우
			// EOF
/*			while((i=in.read())!=-1) {
				
				System.out.print((char)i);
			}
*/
			while(true) {
				String data = in.readLine();
				if (data==null) {
					break;
				}
				System.out.println(data);
			}
			long end = System.currentTimeMillis();
			System.out.println("읽은 시간 : " + (end-start));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				
			}
		}
	}

}
