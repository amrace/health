package com.example.health.parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.health.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="BloodPressure")
public class BloodPressure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="bloodPressure")
	private String bloodPressure;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;
	
	@ManyToOne (optional = false ,fetch =FetchType.LAZY)
	//@JsonBackReference
	@JoinColumn(name="patient_id", referencedColumnName = "id")
	private Patient patient;
	
	//to insert many bloodpressure value to a single patient
	//private int patientid;
	
	  
	 
	
	
	@Autowired 
	public BloodPressure() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	//parameter constructors
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	
	public Date getDate() {
		return date;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	
		
	
}
