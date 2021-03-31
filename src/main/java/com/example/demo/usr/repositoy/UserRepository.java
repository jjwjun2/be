package com.example.demo.usr.repositoy;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.usr.domain.*;

interface IUserRepository {
	public List<User> findByName(String name);
	public boolean findByEmail(String email);
	public boolean checkId(String id);
	public String findIdByEmail(String email);
	public Optional<User> findUserById(String email);
	public Optional<User> findUserByEmail(String email);
	public Optional<User> findPassword(String password);
	public Optional<User> updateProfile(String email, String password);
	public Optional<User> updatePassword(String password);
	public void updateUserPassword(String id, String password);
	public List<User> findAllUser();
}


public interface UserRepository extends JpaRepository<User, Long>, IUserRepository {
	
}