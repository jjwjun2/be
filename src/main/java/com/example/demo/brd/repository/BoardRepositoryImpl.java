package com.example.demo.brd.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.brd.domain.Board;
import com.example.demo.brd.domain.QBoard;
import com.example.demo.usr.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.example.demo.brd.domain.QBoard.board;
import static com.example.demo.usr.domain.QUser.user;

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements IBoardRepository {
	private final JPAQueryFactory queryFactory;
	private final EntityManager em;

	public BoardRepositoryImpl(EntityManager em, JPAQueryFactory queryFactory) {
		super(Board.class);
		this.em = em;
		this.queryFactory = queryFactory;
	}
//
//	@Override
//	public List<Board> findByTitle(String title) {
//		QBoard qBoard = QBoard.board;
//		List<Board> result = queryFactory.selectFrom(qBoard).where(qBoard.brdTitle.eq(title)).fetch();
//		return result;
//	}

	// Basic Method
	@Override
	public List<Board> findByKeyword(String keyword) {
		List<Board> result = queryFactory.selectFrom(board).where(board.brdTitle.eq(keyword)).fetch();
		return result;
	}

	@Override
	public List<Board> sortByDate(String keyword) {
		return queryFactory.selectFrom(board).fetch();
	}
	
	
	// 좋아요 순
	@Override
	public List<Board> sortByLike(String keyword) {
		return queryFactory.selectFrom(board)
				.where(board.brdTitle.eq(keyword).or(board.brdContent.contains(keyword)))
				.orderBy(board.brdLike.asc())
				.fetch();
	}

	@Override
	public List<Board> sortByCount(String keyword) {
		return queryFactory.selectFrom(board)
				.where(board.brdTitle.eq(keyword).or(board.brdContent.contains(keyword)))
				.orderBy(board.count.asc())
				.fetch();
	}

	@Override
	public List<Board> findByTitle(String keyword) {
		return null;
	}

//	@Override
//	public List<Board> findByWriter(String keyword) {
//		return queryFactory.selectFrom(board)
//				.where(boa)
//				.join(user.usrName)
//				
//	}
	

}