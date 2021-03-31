package com.example.demo.brd.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.brd.domain.Board;
import com.example.demo.usr.domain.User;

interface IBoardRepository {

}

public interface BoardService {

	// 제목 : 같은 제목이 여러개일 수 있기 때문에 List
	public List<Board> findByTitle(String keyword);
	
	// 글쓴이로 찾기
	public List<Board> findByWriter(String keyword);
	
	// 날짜별 정렬
	public List<Board> sortByDate(String keyword);

	// 좋아요(추천)
	public List<Board> sortByLike(String keyword);

	// 조회수 순
	public List<Board> sortByCount(String keyword);

}