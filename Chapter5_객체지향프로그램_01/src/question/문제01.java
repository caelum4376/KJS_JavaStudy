package question;

class movie {
	int no;
	String poster;
	String titleKor;
	String titleEng;
	String rDate;
	String genre;
	String nation;
	String rating;
	String runningTime;
	double score;
	int rank;
	String content;
}

class 영화뉴스 {
	String poster;
	String title;
	String content;
	String regdate;
	String author;
}

class 카테고리 {
	String poster;
	String title;
	String subject;
	
}

class 레시피 {
	String poster;
	String title;
	String chef;
	String chef_img;
	int star;
	int hit;
}

class 멜론 {
	int rank;
	String state;
	String poster;
	String title;
	String singer;
	String album;
	int like;
}

class 만개의스토어 {
	int sale; // 25 "↓"+sale+"%"
	String poster;
	String title;
	int price;
}

class 연극 {
	String poster;
	String title;
	boolean isShow;
	String genre;
	String regdate;
	String loc;
	String actor;
	String grade;
	String time;
}
public class 문제01 {

	public static void main(String[] args) {
		movie JWorld = new movie();
		JWorld.no = 1;
		JWorld.poster = "https://t1.daumcdn.net/movie/5d3c3e6f0e2078681fb0f1a17240e901a8638bd3";
		JWorld.titleKor = "쥬라기월드:도미니언";
		JWorld.titleEng = "JURASSIC WORLD : DOMINION, 2022";
		JWorld.rDate = "2022-06-01";
		JWorld.genre = "액션/어드벤쳐/SF";
		JWorld.nation = "미국";
		JWorld.rating = "12세이상관람가";
		JWorld.runningTime = "147분";
		JWorld.score = 9.2;
		JWorld.rank = 3;
		JWorld.content = "이제 모든 것이 끝난다,\n지상 최대 블록버스터의 압도적 피날레!\n\n공룡들의 터전이었던 누블라 섬이 파괴된 후,\n"
				+ "마침내 공룡들은 섬을 벗어나 세상 밖으로 출몰한다.\n지상에 함께 존재해선 안 될 위협적 생명채인 공룡의 등장으로\n"
				+ "인류 역사상 겪어보지 못한 사상 최악의 위기를 맞이한 인간들.\n지구의 최상위 포식자 자리 걸고 인간과 공룡의 최후의 사투가 펼쳐진다";
		
		System.out.println(JWorld.titleKor);
		System.out.println(JWorld.titleEng);
		System.out.println("개봉 : " + JWorld.rDate);
		System.out.println("장르 : " + JWorld.genre);
		System.out.println("국가 : " + JWorld.nation);
		System.out.println("등급 : " + JWorld.rating);
		System.out.println("러닝타임 : " + JWorld.runningTime);
		System.out.println("★ " + JWorld.score);
		System.out.println("박스오피스 : " + JWorld.rank + "위");
		System.out.println("\n" + JWorld.content);
		
		
				
	}

}
