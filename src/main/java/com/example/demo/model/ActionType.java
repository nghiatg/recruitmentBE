package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actionType")
public class ActionType {
	@Id
	@Column(name="actionTypeId")
	private long actionTypeId;
	
	@Column(name="actionTypeName")
	private String tenHanhDong;
}
