package com.sist.movie;

import java.io.Serializable;

public class MovieVO implements Serializable {
	private int rank;					// 랭킹
	private String title;				// 제목
	private String rated;				// 이용등급
	private String poster;				// 포스터
	private String avg;					// 평점
	private String reservationRate;		// 예매율
	private String regDate;				// 개봉일
	private String contents;			// 줄거리(정보)
	private int cno; 					// 구분자
	private int pk;						// 영화번호
	private String youtube;				// 유튜브링크
	
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getReservationRate() {
		return reservationRate;
	}
	public void setReservationRate(String reservationRate) {
		this.reservationRate = reservationRate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
