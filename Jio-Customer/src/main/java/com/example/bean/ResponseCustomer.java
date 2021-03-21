package com.example.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class ResponseCustomer {

	private long custId;
	private String custName;
	private long custNum;
	private String custAddress;


}
