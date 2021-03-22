package com.example.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerFriends {
	private long custId;
	private String custName;
	private long custNum;
	private String custAddress;
	private Friends friendslist[];

}
