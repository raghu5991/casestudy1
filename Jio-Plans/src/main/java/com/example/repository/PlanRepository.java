package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.dao.Plan;

@Repository
@EnableJpaRepositories
public interface PlanRepository extends JpaRepository<Plan, Long> {
	
	//@Query("FROM customer cu WHERE cu.custId=:id")
	//Customer customerFindById(@Param("id") long id);  

	
}
