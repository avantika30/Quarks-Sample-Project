package org.acme.quarkus.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usersfood")
public class UserFood {
	
	public UserFood () {
		/**/
	}
	
	public UserFood(int userid , String name , Timestamp time , int amount ) {
		this.userid = userid;
		this.name= name;
		this.time= time ;
		this.amount= amount;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	
	@Column(name="name")
	private String name ;
	
	@Column(name="time")
	private Timestamp time ;
	
	@Column(name="amount")
	private int amount ;
	
	@Column(name="userid")
	private int userid ;
	
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
	
	
}
