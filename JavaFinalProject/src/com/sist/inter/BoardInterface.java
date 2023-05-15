package com.sist.inter;
import java.util.*;
import com.sist.manager.*;
public interface BoardInterface {
	// 1. 목록 출력
	public List<BoardVO> boardListData(int page);

	// 2. 글쓰기
	public void boardInsert(BoardVO vo);
	
	// 3. 상세보기
	public BoardVO boardDetailData(int no);
	
	// 4. 수정하기
	public BoardVO boardUpdateDate(int no);
	
	// 5. 실제 수정
	public String boardUpdate(BoardVO vo);
	
	// 6. 삭제
	public String boardDelete(int no, String pwd);
	
	// 7. 자동증가 번호
	public int noIncrement();
}
