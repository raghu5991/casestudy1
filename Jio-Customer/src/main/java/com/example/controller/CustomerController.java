package com.example.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.service.CustomerService;
import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<ResponseCustomer> addCustomer(@RequestBody RequestCustomer requestCustomer) {
		ResponseCustomer responseCustomer = customerService.addCustomer(requestCustomer);
		return new ResponseEntity<ResponseCustomer>(responseCustomer, HttpStatus.OK);

	}
	@GetMapping("/customer/{custId}")  
	public ResponseEntity<ResponseCustomer> getCustomerById(@PathVariable("custId") long custId)
	{

		try {
			ResponseCustomer responseCustomer = customerService.getCustomerById(custId);
			return new ResponseEntity<ResponseCustomer>(responseCustomer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseCustomer>(null, new HttpHeaders(), HttpStatus.FORBIDDEN);
		}

	}
	@GetMapping("/customers")  
	public List<ResponseCustomer> getCustomers() {
		return  customerService.getCustomers();
	}
	
	@PutMapping("/update/{custId}")
	public ResponseEntity<ResponseCustomer> updateCustomer(@PathVariable("custId") long custId,@RequestBody RequestCustomer requestCustomer) 
	{
		try {
		ResponseCustomer responseCustomer = customerService.updateCustomer(custId,requestCustomer);
		return new ResponseEntity<ResponseCustomer>(responseCustomer, HttpStatus.OK);
		}
		 catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<ResponseCustomer>(null, new HttpHeaders(), HttpStatus.FORBIDDEN);

	}
		
	}
}
