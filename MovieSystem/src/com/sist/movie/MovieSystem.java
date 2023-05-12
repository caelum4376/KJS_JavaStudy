package com.sist.movie;

import java.io.*;
import java.util.*;

public class MovieSystem {

	// 데이터 읽기
	private static List<MovieVO> list = new ArrayList<MovieVO>();

	// 초기화 블럭
	static {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
//			fis = new FileInputStream("C:\\java_datas\\daum_movie.txt");
			fis = new FileInputStream("/Users/caelum/Documents/java_datas/daum_movie.txt");
			ois = new ObjectInputStream(fis);

			list = (List<MovieVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (Exception e) {

			}
		}

	}

	public void movieCategoryData(int cno) {
		for (MovieVO vo : list) {
			if (vo.getCno() == cno) {
				System.out.println(vo.getRank() + "." + vo.getTitle() + ", 영화번호 : " + vo.getPk() + ", 동영상url : " + vo.getYoutube() );
			}
		}
	}

	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("예매순위(1) 박스오피스(2) OTT(3) : ");
			String cno = in.readLine();
			ms.movieCategoryData(Integer.parseInt(cno));
		} catch (Exception e) {

		}
	}

}
