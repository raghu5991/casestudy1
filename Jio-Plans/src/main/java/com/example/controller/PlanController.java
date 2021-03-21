package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.RequestPlan;
import com.example.bean.ResponsePlan;
import com.example.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private PlanService customerService;
	
	
	@GetMapping("/plan/{planId}")  
	public ResponseEntity<ResponsePlan> getPlanById(@PathVariable("planId") long planId)
	{

		try {
			ResponsePlan responseCustomer = customerService.getPlanById(planId);
			return new ResponseEntity<ResponsePlan>(responseCustomer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponsePlan>(null, new HttpHeaders(), HttpStatus.FORBIDDEN);
		}

	}
	@GetMapping("/plans")  
	public List<ResponsePlan> getPlans() {
		return  customerService.getPlans();
	}
}