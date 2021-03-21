package com.example.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "friends")
@Table
@Setter
@Getter
@ToString
@Data
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long frdId;
	private String frdName;
	private long custId;
	private long frdNum;

}
