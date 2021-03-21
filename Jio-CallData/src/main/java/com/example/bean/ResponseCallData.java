package com.example.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class ResponseCallData {
	private long id;
	private String callType;
	private LocalDateTime localTime;
	private double duration;
	private long custId;


}
