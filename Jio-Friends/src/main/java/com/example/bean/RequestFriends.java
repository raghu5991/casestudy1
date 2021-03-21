package com.example.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class RequestFriends {
	private String frdName;
	private long custId;
	private long frdNum;

}
