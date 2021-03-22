package com.example.dao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Plan")
@Table
@Setter
@Getter
@ToString
@Data
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long planId;
	private String planType;
	private long amount;
	private LocalDateTime validity;

}
