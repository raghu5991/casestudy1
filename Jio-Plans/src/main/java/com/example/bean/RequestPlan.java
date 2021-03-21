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
public class RequestPlan {
	private String planType;
	private long amount;
	private LocalDateTime validity;

}
