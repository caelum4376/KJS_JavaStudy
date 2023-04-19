package com.sist.main3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MelonMusicSystem extends GenieMusicSystem {
	// musics / musicAllData / musicFindData
	protected static String title = "멜론 Top50";
	{
		
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			
			// 타이틀명 <div class="wrap_song_info">
			Elements title = doc.select("div.wrap_song_info div.rank01");

			// 가수명
			Elements artist = doc.select("div.wrap_song_info div.rank02");

			// 앨범명
			Elements album = doc.select("div.wrap_song_info div.rank03");

			for (int i = 0; i < title.size(); i++) {
				
				
//				System.out.println(i+1);
//				System.out.println(title.get(i).text());
//				System.out.println(artist.get(i).text());
//				System.out.println(album.get(i).text());
//				System.out.println("=====================================");
				
				musics[i] = new Music();
				musics[i].setRank(i + 1);
				musics[i].setTitle(title.get(i).text());
				musics[i].setSinger(artist.get(i).text());
				musics[i].setAlbum(album.get(i).text());
				
			}
		} catch (Exception e) {

		}
	}
	
//	public static void main(String[] args) {
//		MelonMusicSystem m = new MelonMusicSystem();
//	}
}
