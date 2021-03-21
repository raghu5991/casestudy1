package com.example.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class RequestCustomer {
	private String custName;
	private long custNum;
	private String custAddress;

}
