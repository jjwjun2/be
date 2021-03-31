package com.example.demo.brd.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.brd.domain.Board;
import com.example.demo.brd.domain.BoardDto;
import com.example.demo.brd.repository.BoardRepository;
import com.example.demo.brd.repository.BoardRepositoryImpl;
import com.example.demo.cmm.service.AbstractService;
import com.example.demo.usr.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl extends AbstractService<Board> implements BoardService {
	@Autowired
	BoardRepository boardRepository;

	@Override
	public long save(Board t) {
		return 0;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public List<Board> findAll() {
		return boardRepository.findAll().stream()
				.sorted(Comparator.comparing(Board::getBrdWrtDate))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Board> findByWriter(String keyword) {
		return null;
	}

	@Override
	public long delete(Board t) {
		return 0;
	}

	@Override
	public Board getOne(long id) {
		return null;
	}

	@Override
	public Optional<Board> findById(long id) {
		return null;
	}

	@Override
	public boolean existsById(long id) {
		return false;
	}

	@Override
	public List<Board> findByTitle(String keyword) {
		return boardRepository.findByKeyword(keyword);
	}

	
	// 검색된 책들을 최신 순으로 정렬
	@Override
	public List<Board> sortByDate(String keyword) {
		return boardRepository.findByKeyword(keyword).stream()
				.sorted(Comparator.comparing(Board::getBrdWrtDate).reversed())
				.collect(Collectors.toList());
	}
	
	
	// 좋아요 높은 순으로 정렬
	@Override
	public List<Board> sortByLike(String keyword) {
		return boardRepository.findByKeyword(keyword).stream()
				.sorted(Comparator.comparing(Board::getBrdLike).reversed())
				.collect(Collectors.toList());
	}
	
	
	// 조회 수 높은 순
	@Override
	public List<Board> sortByCount(String keyword) {
		return boardRepository.findByKeyword(keyword).stream()
				.sorted(Comparator.comparing(Board::getCount).reversed())
				.collect(Collectors.toList());
	}






}