package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
import org.springframework.web.client.RestTemplate;

import com.example.bean.RequestCustomer;
import com.example.bean.ResponseCustomer;
import com.example.dao.CustomerFriends;
import com.example.dao.Friends;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity<ResponseCustomer> addCustomer(@RequestBody RequestCustomer requestCustomer) {
		ResponseCustomer responseCustomer = customerService.addCustomer(requestCustomer);
		return new ResponseEntity<ResponseCustomer>(responseCustomer, HttpStatus.OK);

	}
	@GetMapping("/customer/{custId}")  
	public CustomerFriends getCustomerById(@PathVariable("custId") long custId)
	{

		List<ServiceInstance> instance=discoveryClient.getInstances("jio-friends");
		ServiceInstance serviceInstance=instance.get(0);
		String baseUrl=serviceInstance.getUri().toString()+"/friend/friends/"+custId;
		RestTemplate template=new RestTemplate();
		ResponseEntity<Friends[]> response=template.getForEntity(baseUrl, Friends[].class);
		Friends[] friendslist=response.getBody();
		
		ResponseCustomer responseCustomer = customerService.getCustomerById(custId);
		CustomerFriends customerfriends=new CustomerFriends();
		customerfriends.setCustId(responseCustomer.getCustId());
		customerfriends.setCustName(responseCustomer.getCustName());
		customerfriends.setCustAddress(responseCustomer.getCustAddress());
		customerfriends.setCustNum(responseCustomer.getCustNum());
		customerfriends.setFriendslist(friendslist);
		return customerfriends;
		

	}
	@GetMapping("/customers")  
	public List<ResponseCustomer> getCustomers() {
		return  customerService.getCustomers();
	}
	
	@PutMapping("/update/{custId}")
	public ResponseEntity<ResponseCustomer> updateCustomer(@PathVariable("custId") long custId,@RequestBody RequestCustomer requestCustomer) 
	{
		ResponseCustomer responseCustomer = customerService.updateCustomer(custId,requestCustomer);
		return new ResponseEntity<ResponseCustomer>(responseCustomer, HttpStatus.OK);
		
	}
}
