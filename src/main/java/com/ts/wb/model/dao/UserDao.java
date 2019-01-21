package com.ts.wb.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ts.wb.model.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	@Query(" SELECT u FROM User u WHERE u.account = ':account' AND u.password = ':password' ")
	User findByCondition(@Param("account") String account, @Param("password") String password);
	
}
