package com.sist.movie;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
public class DataCollectionManager {

	public static void main(String[] args) {
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("c:\\java_datas\\daum_movie.txt");
			oos = new ObjectOutputStream(fos);
			
			// 사이트연결
			String[] urls = {
					"https://movie.daum.net/ranking/reservation",
					"https://movie.daum.net/ranking/boxoffice/weekly",
					"https://movie.daum.net/ranking/ott"
			};
			
			// 고유번호 
						int k=1;
						for (int i=0; i<urls.length; i++) {
							Document doc = Jsoup.connect(urls[i]).get();
							Elements title = doc.select("div.item_poster a.link_txt");
//							Elements rated = doc.select("span.txt_tag");
							Elements poster = doc.select("div.item_poster div.poster_movie img");
							Elements avg = doc.select("div.item_poster span.info_txt span.txt_grade");
							Elements reservationRate = doc.select("div.item_poster span.info_txt span.txt_num");
							Elements regDate = doc.select("div.item_poster span.txt_info span.txt_num");
							Elements contents = doc.select("div.item_poster a.link_story");
							if (i==0) {
								poster.add(9, new Element("<img src=\"https://t1.daumcdn.net/movie/movie2020/pc/ico_noimage.png\">"));
							}
							for (int j=0; j<title.size(); j++) {
								MovieVO vo = new MovieVO();
								
								// 랭킹
								if (i==0) {
									System.out.println("랭킹 : " + k);
									k++;
								}
								System.out.println("카테고리 번호 : " + (i+1));
								
								// 타이틀
								System.out.println(title.get(j).text());
								
								// 포스터
								if (!poster.isEmpty()) {
									System.out.println(poster.get(j).attr("src"));
									vo.setPoster(poster.get(j).attr("src"));
								} else {
									vo.setPoster("-");
								}
								
//								// 이용등급
//								if (!rated.isEmpty() && i==0) {
//									System.out.println(rated.get(j).text());
//									vo.setRated(rated.get(j).text());
//								}
								
								// 평점
								if (!avg.isEmpty() && i==0) {
									System.out.println(avg.get(j).text());
									vo.setAvg(avg.get(j).text());
								}

								// 평점
								if (!reservationRate.isEmpty()) {
									System.out.println(reservationRate.get(j).text());
									vo.setReservationRate(reservationRate.get(j).text());
								}

								// 개봉일
								if (!regDate.isEmpty()) {
									System.out.println(regDate.get(j).text());
									vo.setRegDate(regDate.get(j).text());
								}

								// 줄거리
								if (!contents.isEmpty()) {
									System.out.println(contents.get(j).text());
									vo.setContents(contents.get(j).text());
								}
								
								System.out.println("===============================");
								
								vo.setRank(k);
								vo.setTitle(title.get(j).text());
								
								list.add(vo);
							}
						}
						
						oos.writeObject(list);
						System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (Exception e) {
				
			}
		}
	}

}
