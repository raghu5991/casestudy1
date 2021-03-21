package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.ResponseCallData;
import com.example.service.CallDataService;

@RestController
@RequestMapping("/calldata")
public class CallDataController {
	
	@Autowired
	private CallDataService customerService;
	
	@GetMapping("/calldata/{custId}")  
	public ResponseEntity<List<ResponseCallData>> getCustomerById(@PathVariable("custId") long custId)
	{
			return new ResponseEntity<>(customerService.getCustomerById(custId),HttpStatus.OK);
		
	}
	
}
