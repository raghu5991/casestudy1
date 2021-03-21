package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.RequestFriends;
import com.example.bean.ResponseFriends;
import com.example.dao.Friends;
import com.example.repository.FriendsRepository;

@Service
public class FriendsService {
	@Autowired
	private FriendsRepository customerRepository;

	public ResponseFriends addFriend(RequestFriends requestCustomer) {
		
		Friends customer=new Friends();
		customer.setCustId(requestCustomer.getCustId());
		customer.setFrdName(requestCustomer.getFrdName());
		customer.setFrdNum(requestCustomer.getFrdNum());
		
		Friends newcustomeradd=customerRepository.save(customer);
		ResponseFriends newCustomer=new ResponseFriends();
		newCustomer.setCustId(newcustomeradd.getCustId());
		newCustomer.setFrdName(newcustomeradd.getFrdName());
		newCustomer.setFrdNum(newcustomeradd.getFrdNum());
		newCustomer.setFrdId(newcustomeradd.getFrdId());
		return newCustomer;
	}


     public List<ResponseFriends> getFriendsById(long custId) {
 		// TODO Auto-generated method stub
     	ArrayList<ResponseFriends> rescalldatalist=new ArrayList<ResponseFriends>();
     	List<Friends> calldatalist=customerRepository.findById(custId);
 		
     	calldatalist.forEach((val)->{
     		ResponseFriends newCustomer=new ResponseFriends();
     		newCustomer.setCustId(val.getCustId());
     		newCustomer.setFrdId(val.getFrdId());
     		newCustomer.setFrdName(val.getFrdName());
     		newCustomer.setFrdNum(val.getFrdNum());
     		rescalldatalist.add(newCustomer);
     	});
 		
 		return rescalldatalist;
 	}
	
}
