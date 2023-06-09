package com.sist.manager;

import java.io.*;
import java.util.*;

public class MovieSystem {
	private static List<MovieVO> list = new ArrayList<MovieVO>();
	static
	{
		FileInputStream fis = null; //FileInputStream 파일 읽기
		ObjectInputStream ois = null;
		try
		{
			fis = new FileInputStream("/Users/caelum/Documents/java_datas/DaumMovie_kim.txt");
			ois = new ObjectInputStream(fis);
			list = (List<MovieVO>)ois.readObject();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				ois.close();
			}catch(Exception ex) {}
		}
	}
	public List<MovieVO> movieListData(int page)
	{
		List<MovieVO> mList = new ArrayList<MovieVO>();
		int j=0; // 20개씩 나눠주는 변수
		int rowSize = 20;
		int start =(page-1)* rowSize;
		/*
		 *    1page => 0~19
		 *    2page => 20~39
		 *    ...
		 */
		for(int i=0; i<list.size();i++)
		{
			if(j<rowSize && i>=start)
			{
				mList.add(list.get(i));
				j++;
			}
		}
		return mList;
	}
	public int movieTotalPage()
	{
		return (int)(Math.ceil(list.size())/20.0);
	}
	public List<MovieVO> movieCategoryData(int cno)
	{
		List<MovieVO> mList = new ArrayList<MovieVO>();
		for(MovieVO vo: list)
		{
			if(vo.getCno()==cno)
			{
				System.out.println(vo.getRank() + "." + vo.getTitle() + ", 영화번호 : " + vo.getPk() 
				+ ", 동영상url : " + vo.getKey() + "\n\t줄거리 : " + vo.getContent() + "\n\t평점 : " 
				+ vo.getGrade() + ", 예매율 : " + vo.getReservation() + ", 개봉일" + vo.getRegDate()
				+ "\n\t포스터 : " +vo.getPoster() + "\n\t연령제한 : " + vo.getAge());
				mList.add(vo);
			}
		}
		return mList;
		
	}
	public List<MovieVO> movieFindData(String title)
	{
		List<MovieVO> mList = new ArrayList<MovieVO>();
		for(MovieVO vo:list)
		{
			if(vo.getTitle().contains(title))
			{
				mList.add(vo);
			}
		}
		return mList;
	}
	public MovieVO movieDetailData(String title) {
		MovieVO vo = new MovieVO();
		for (MovieVO gvo:list) {
			if (gvo.getTitle().equals(title)) {
				vo = gvo;
				break;
			}
		}
		return vo;
	}
	public static void main(String[] args) {
		MovieSystem ms = new MovieSystem();
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("예매순위(1) 박스오피스(2) OTT(3) : ");
			String cno = in.readLine();
			ms.movieCategoryData(Integer.parseInt(cno));
		}catch(Exception ex) {}
	}
}
