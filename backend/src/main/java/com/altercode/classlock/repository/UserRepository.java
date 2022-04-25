package com.altercode.classlock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altercode.classlock.dto.XpDTO;
import com.altercode.classlock.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
	User findByEmail(String email);

}
