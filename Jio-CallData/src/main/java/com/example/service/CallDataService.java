package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.ResponseCallData;
import com.example.dao.CallData;
import com.example.repository.CallDataRepository;

@Service
public class CallDataService {
	@Autowired
	private CallDataRepository customerRepository;

     public List<ResponseCallData> getCustomerById(long custId) {
		// TODO Auto-generated method stub
    	ArrayList<ResponseCallData> rescalldatalist=new ArrayList<ResponseCallData>();
    	List<CallData> calldatalist=customerRepository.callDataById(custId);
		
    	calldatalist.forEach((val)->{
    		ResponseCallData newCustomer=new ResponseCallData();
    		newCustomer.setId(val.getId());
    		newCustomer.setCallType(val.getCallType());
    		newCustomer.setLocalTime(val.getLocalTime());
    		newCustomer.setDuration(val.getDuration());
    		newCustomer.setCustId(val.getCustId());
    		rescalldatalist.add(newCustomer);
    	});
		
		return rescalldatalist;
	}
	
}
