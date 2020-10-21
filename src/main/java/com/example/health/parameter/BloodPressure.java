package com.example.health.parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="BloodPressure")
public class BloodPressure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="bloodPressure")
	private String bloodPressurue;
	
	@Column(name="date")
	private String date;
	
	
	
	
	
	public BloodPressure(String bloodPressurue, String date) {
		super();
		this.bloodPressurue = bloodPressurue;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodPressurue() {
		return bloodPressurue;
	}
	public void setBloodPressurue(String bloodPressurue) {
		this.bloodPressurue = bloodPressurue;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BloodPressure [id=" + id + ", bloodPressurue=" + bloodPressurue + ", date=" + date + "]";
	}
	
	

}
