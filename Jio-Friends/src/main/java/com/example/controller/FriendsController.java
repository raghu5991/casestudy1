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

import com.example.bean.RequestFriends;
import com.example.bean.ResponseFriends;
import com.example.service.FriendsService;

@RestController
@RequestMapping("/friend")
public class FriendsController {
	
	@Autowired
	private FriendsService customerService;
	
	@PostMapping("/addfriend")
	public ResponseEntity<ResponseFriends> addFriend(@RequestBody RequestFriends requestCustomer) {
		ResponseFriends responseCustomer = customerService.addFriend(requestCustomer);
		return new ResponseEntity<ResponseFriends>(responseCustomer, HttpStatus.OK);

	}
	@GetMapping("/friends/{custId}")  
	public ResponseEntity<List<ResponseFriends>> getFriendsById(@PathVariable("custId") long custId)
	{
		List<ResponseFriends> list=customerService.getFriendsById(custId);
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	}
