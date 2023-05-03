package com.sist.io;
// BufferedReader / BufferedWriter

import java.io.*;
public class 입출력_04 {

	public static void main(String[] args) throws Exception {
		FileWriter out = new FileWriter("c:\\java_datas\\movie_1.txt");
		FileReader in = new FileReader("c:\\javaDev\\movie.txt");
		BufferedReader br = new BufferedReader(in);
		BufferedWriter bw = new BufferedWriter(out);
		long start = System.currentTimeMillis();
		while(true) {
			String data = br.readLine();
			if (data==null) {
				break;
			}
			bw.write(data + "\n");
		}
		System.out.println("읽기/쓰기 완료");
		long end = System.currentTimeMillis();
		System.out.println("읽은 시간 : " + (end-start));
		in.close();
		out.close();
	}

}
