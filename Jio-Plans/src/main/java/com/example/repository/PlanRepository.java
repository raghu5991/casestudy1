package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dao.Plan;

@Repository
@EnableJpaRepositories
public interface PlanRepository extends JpaRepository<Plan, Long> {
	
	//@Query("FROM customer cu WHERE cu.custId=:id")
	//Customer customerFindById(@Param("id") long id);  
	@Query("select cd FROM Plan cd WHERE cd.planType=:id")
	public List<Plan> getPlanByType(@Param("id") String id);  
	
}
