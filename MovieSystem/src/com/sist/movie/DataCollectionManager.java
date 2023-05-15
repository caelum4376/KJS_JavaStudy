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
//			fos = new FileOutputStream("c:\\java_datas\\daum_movie.txt");
			fos = new FileOutputStream("/Users/caelum/Documents/java_datas/daum_movie.txt");
			oos = new ObjectOutputStream(fos);
			
			// 사이트연결
			String[] urls = {
					"https://movie.daum.net/ranking/reservation",
					"https://movie.daum.net/ranking/boxoffice/weekly",
					"https://movie.daum.net/ranking/ott"
			};
			
			// 고유번호 
						for (int i=0; i<urls.length; i++) {
							Document doc = Jsoup.connect(urls[i]).get();
							Elements title = doc.select("div.item_poster a.link_txt");
//							Elements rated = doc.select("span.txt_tag");
							Elements poster = doc.select("div.item_poster div.poster_movie img");
							Elements avg = doc.select("div.item_poster span.info_txt span.txt_grade");
							Elements reservationRate = doc.select("div.item_poster span.info_txt span.txt_num");
							Elements regDate = doc.select("div.item_poster span.txt_info span.txt_num");
							Elements contents = doc.select("div.item_poster a.link_story");
							Elements pk = doc.select("div.item_poster strong.tit_item a");
							
							if (i==0) {
								poster.add(11, new Element("<img src=\"https://t1.daumcdn.net/movie/movie2020/pc/ico_noimage.png\">"));
							}
							if (i==1) {
								regDate.add(13, new Element("<span class=\"txt_num\">미정</span>"));
							}
							int k=1;
							for (int j=0; j<title.size(); j++) {
								MovieVO vo = new MovieVO();
								
								// 랭킹
								System.out.println("랭킹 : " + k);
								
								System.out.println("카테고리 번호 : " + (i+1));
								
								// 타이틀
								System.out.println(title.get(j).text());
								
								// 포스터
								System.out.println(poster.get(j).attr("src"));
									
								
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

								// 예매율
								if (!reservationRate.isEmpty() && i==0) {
									System.out.println(reservationRate.get(j).text());
									vo.setReservationRate(reservationRate.get(j).text());
								}

								// 개봉일
								if (!regDate.isEmpty() && (i==0 | i==1)) {
									System.out.println(regDate.get(j).text());
									vo.setRegDate(regDate.get(j).text());
								}

								// 줄거리
								if (!contents.isEmpty()) {
									System.out.println(contents.get(j).text());
									vo.setContents(contents.get(j).text());
								}
								
								// 영화번호
								System.out.println(pk.get(j).attr("href").substring(pk.get(j).attr("href").lastIndexOf("=")+1));
								vo.setPk(Integer.parseInt(pk.get(j).attr("href").substring(pk.get(j).attr("href").lastIndexOf("=")+1)));
								
								System.out.println("===============================");
								
								vo.setRank(k);
								vo.setTitle(title.get(j).text());
								vo.setPoster(poster.get(j).attr("src"));
								vo.setYoutube(youtubeKeyData(title.get(j).text()));
								vo.setCno(i+1);
								list.add(vo);
								k++;
							}
						}
						System.out.println("hi");
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

	public static String youtubeKeyData(String title) {
		String key="";
		try {
			String url = "https://www.youtube.com/results?search_query="+URLEncoder.encode(title, "UTF-8");
			Document doc = Jsoup.connect(url).get();
			String data = doc.toString();
			Pattern p = Pattern.compile("/watch\\?v=[^가-힣]+");
			Matcher m = p.matcher(data);
			
			while(m.find()) {
				String s=m.group();
				s=s.substring(s.indexOf("=")+1, s.indexOf("\""));
				key = s;
				break;
			}
		} catch (Exception e) {
			
		}
		
		return key;
	}
}
