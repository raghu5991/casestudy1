package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dao.Friends;

@Repository
@EnableJpaRepositories
public interface FriendsRepository extends JpaRepository<Friends, Long> {
	
	//@Query("FROM customer cu WHERE cu.custId=:id")
	//Customer customerFindById(@Param("id") long id);  
	@Query("select fd FROM friends fd WHERE fd.custId=:id")
	public List<Friends> findById(@Param("id") long id);  

	
}
