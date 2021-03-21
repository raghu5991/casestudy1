package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.RequestCustomer;
import com.example.bean.ResponseCustomer;
import com.example.dao.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public ResponseCustomer addCustomer(RequestCustomer requestCustomer) {
		
		Customer customer=new Customer();
		customer.setCustName(requestCustomer.getCustName());
		customer.setCustNum(requestCustomer.getCustNum());
		customer.setCustAddress(requestCustomer.getCustAddress());
		
		Customer newcustomeradd=customerRepository.save(customer);
		ResponseCustomer newCustomer=new ResponseCustomer();
		newCustomer.setCustId(newcustomeradd.getCustId());
		newCustomer.setCustName(newcustomeradd.getCustName());
		newCustomer.setCustNum(newcustomeradd.getCustNum());
		newCustomer.setCustAddress(newcustomeradd.getCustAddress());
		return newCustomer;
	}


     public ResponseCustomer getCustomerById(long custId) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(custId).get();
		ResponseCustomer newCustomer=new ResponseCustomer();
		newCustomer.setCustId(customer.getCustId());
		newCustomer.setCustName(customer.getCustName());
		newCustomer.setCustNum(customer.getCustNum());
		newCustomer.setCustAddress(customer.getCustAddress());
		return newCustomer;
	}
	public List<ResponseCustomer> getCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers=new ArrayList<Customer>();
		List<ResponseCustomer> newcustomers=new ArrayList<ResponseCustomer>();
		customers=customerRepository.findAll();
		customers.forEach((cust)->
		{
			ResponseCustomer resobj=new ResponseCustomer();
			resobj.setCustId(cust.getCustId());
			resobj.setCustName(cust.getCustName());
			resobj.setCustNum(cust.getCustNum());
			resobj.setCustAddress(cust.getCustAddress());
			newcustomers.add(resobj);
		});
		return newcustomers;
	}


	public ResponseCustomer updateCustomer(long custId,RequestCustomer requestCustomer) {
		
		Customer customer=customerRepository.findById(custId).get();
		//Customer customer=new Customer();
		customer.setCustName(requestCustomer.getCustName());
		customer.setCustNum(requestCustomer.getCustNum());
		customer.setCustAddress(requestCustomer.getCustAddress());
		
		Customer newcustomeradd=customerRepository.save(customer);
	
		ResponseCustomer newCustomer=new ResponseCustomer();
		newCustomer.setCustId(newcustomeradd.getCustId());
		newCustomer.setCustName(newcustomeradd.getCustName());
		newCustomer.setCustNum(newcustomeradd.getCustNum());
		newCustomer.setCustAddress(newcustomeradd.getCustAddress());
		
		return newCustomer;
		
	}

}
