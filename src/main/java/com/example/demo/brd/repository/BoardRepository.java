package com.example.demo.brd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.brd.domain.Board;

interface IBoardRepository {
	
	// 기본 검색
	public List<Board> findByTitle(String keyword);
	
//	public List<Board> findByWriter(String keyword);
	
	// 제목, 글쓴이로 찾기 : 같은 제목이 여러개일 수 있기 때문에 List
	public List<Board> findByKeyword(String keyword);
	
	// 날짜별 정렬
	public List<Board> sortByDate(String keyword);
	
	// 좋아요(추천수 높은 순)
	public List<Board> sortByLike(String keyword);

	// 조회수 순
	public List<Board> sortByCount(String keyword);
	

}	

public interface BoardRepository extends JpaRepository<Board, Long>, IBoardRepository {

}
