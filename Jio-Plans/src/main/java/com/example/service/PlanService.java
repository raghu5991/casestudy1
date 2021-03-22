package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.RequestPlan;
import com.example.bean.ResponsePlan;
import com.example.dao.Plan;
import com.example.repository.PlanRepository;

@Service
public class PlanService {
	@Autowired
	private PlanRepository customerRepository;

	public ResponsePlan addPlan(RequestPlan requestCustomer) {
		// TODO Auto-generated method stub
		Plan plan=new Plan();
		plan.setPlanType(requestCustomer.getPlanType());
		plan.setAmount(requestCustomer.getAmount());
		plan.setValidity(requestCustomer.getValidity());
		
		Plan newcustomeradd=customerRepository.save(plan);
		ResponsePlan newCustomer=new ResponsePlan();
		newCustomer.setPlanId(newcustomeradd.getPlanId());
		newCustomer.setPlanType(newcustomeradd.getPlanType());
		newCustomer.setAmount(newcustomeradd.getAmount());
		newCustomer.setValidity(newcustomeradd.getValidity());
		
		return newCustomer;
	
	}
	
     public ResponsePlan getPlanById(long custId) {
		// TODO Auto-generated method stub
    	//List<Plan> plansList=new ArrayList<Plan>();
		Plan customer=customerRepository.findById(custId).get();
		ResponsePlan newCustomer=new ResponsePlan();
		newCustomer.setPlanId(customer.getPlanId());
		newCustomer.setPlanType(customer.getPlanType());
		newCustomer.setAmount(customer.getAmount());
		newCustomer.setValidity(customer.getValidity());
		return newCustomer;
	}
	public List<ResponsePlan> getPlans() {
		// TODO Auto-generated method stub
		List<Plan> customers=new ArrayList<Plan>();
		List<ResponsePlan> newcustomers=new ArrayList<ResponsePlan>();
		customers=customerRepository.findAll();
		customers.forEach((cust)->
		{
			ResponsePlan newCustomer=new ResponsePlan();
			newCustomer.setPlanId(cust.getPlanId());
			newCustomer.setPlanType(cust.getPlanType());
			newCustomer.setAmount(cust.getAmount());
			newCustomer.setValidity(cust.getValidity());
			newcustomers.add(newCustomer);
		});
		return newcustomers;
	}

	public List<ResponsePlan> getPlanByType(String custId) {
		// TODO Auto-generated method stub
    	ArrayList<ResponsePlan> rescalldatalist=new ArrayList<ResponsePlan>();
    	List<Plan> calldatalist=customerRepository.getPlanByType(custId);
		
    	calldatalist.forEach((val)->{
    		ResponsePlan newCustomer=new ResponsePlan();
    		newCustomer.setPlanId(val.getPlanId());
    		newCustomer.setPlanType(val.getPlanType());
    		newCustomer.setAmount(val.getAmount());
    		newCustomer.setValidity(val.getValidity());
    		
    		rescalldatalist.add(newCustomer);
    	});
		
		return rescalldatalist;
	}

	


}
