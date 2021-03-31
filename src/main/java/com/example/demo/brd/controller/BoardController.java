package com.example.demo.brd.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.brd.domain.Board;
import com.example.demo.brd.domain.BoardDto;
import com.example.demo.brd.repository.BoardRepository;
import com.example.demo.brd.service.BoardService;
import com.example.demo.brd.service.BoardServiceImpl;
import com.example.demo.usr.domain.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	BoardService boardService;



	@GetMapping("/find/{title}")
	public ResponseEntity<List<Board>> findByTitle(@RequestBody Board board) {
		logger.info("Find board by title: " + board.getBrdTitle());
		return ResponseEntity.ok(boardService.findByTitle(board.getBrdTitle()));
	}
	
	
	

}
