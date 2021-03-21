package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dao.CallData;

@Repository
@EnableJpaRepositories
public interface CallDataRepository extends JpaRepository<CallData, Long> {
	
	@Query("select cd FROM calldata cd WHERE cd.custId=:id")
	public List<CallData> callDataById(@Param("id") long id);  

	
}
