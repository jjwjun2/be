package com.example.demo.usr.repositoy;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.usr.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.example.demo.usr.domain.QUser.user;
import static com.example.demo.pay.domain.QPayment.payment;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements IUserRepository {

	private final JPAQueryFactory queryFactory;
	private final EntityManager entityManager;

	public UserRepositoryImpl(EntityManager entityManager, JPAQueryFactory queryFactory) {
		super(User.class);
		this.entityManager = entityManager;
		this.queryFactory = queryFactory;
	}
	
	@Override
	public List<User> findAllUser() {
		return queryFactory.selectFrom(user)
				.orderBy(user.usrName.desc())
				.fetch();	
	}
	
	
	@Override
	public List<User> findByName(String name) {
		return queryFactory.selectFrom(user)
				.where(user.usrName.eq(name)).fetch();
	}

	
	@Override
	public boolean findByEmail(String email) {
		return queryFactory.selectFrom(user)
				.where(user.usrEmail.eq(email))
				.fetchOne() != null ? true : false;
	}
	
	@Override
	public boolean checkId(String id) {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.map(modelMapper, null)
		return queryFactory.selectFrom(user)
				.where(user.usrId.eq(id))
				.fetchOne() != null ? true : false;
	}
	
	
	@Override
	public String findIdByEmail(String email) {
		return queryFactory.select(user.usrId).from(user).fetchOne();
	}
	
	@Override
	public Optional<User> findUserById(String email) {
		return Optional.ofNullable(queryFactory.selectFrom(user)
				.where(user.usrEmail.eq(email))
				.fetchOne());
	}
	
	@Override
	public Optional<User> findUserByEmail(String email) {
		return Optional.ofNullable(queryFactory.selectFrom(user)
				.where(user.usrEmail.eq(email)).fetchOne());
	}
	
	
	@Override
	public Optional<User> updatePassword(String password) {
		return Optional.ofNullable(queryFactory
				.selectFrom(user)
				.where(user.usrPwd.eq(password))
				.fetchOne());
	}

	@Override
	public Optional<User> updateProfile(String email, String password) {
		queryFactory.select(user, payment)
		.from(payment)
		.join(payment.user, user)
		.where(user.usrEmail.eq("aa")).fetch();
		
		return Optional.ofNullable(
				queryFactory.selectFrom(user)
					.where(user.usrEmail.eq(email).and(user.usrPwd.eq(password)))
					.fetchOne());
	}

	@Override
	public Optional<User> findPassword(String password) {
		return Optional.ofNullable(queryFactory.selectFrom(user)
				.where(user.usrPwd.eq(password))
				.fetchOne());
	}

	

	
	

	

	@Override
	public void updateUserPassword(String id, String password) {
		
	}
	
}