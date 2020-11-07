package com.example.health.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.health.parameter.BloodPressure;
import com.example.health.parameter.BodyWeight;
import com.example.health.parameter.PulseRate;
import com.example.health.parameter.RespiratoryRate;
import com.example.health.parameter.SPO2;
import com.example.health.parameter.Temperature;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

   @NotBlank (message = "Please enter a valid name")
   @Column(name="firstName")
    private String firstName;
    
   @NotBlank
   @Column (name="lastName")
    private String lastName;
   
   
   //private String gender;
    
   @NotNull
   @Column(name="age")
    private int age;
    //private String sex;
   
   @NotNull
   //@Size(min=9, max=10, message="Mobile should not exceed 10 digit.")
   @Column(name="phone")
    private String phone;
   
   @NotBlank
   @Column(name="address")
    private String address;
   
   @NotBlank
   @Column(name="historyOfPatient")
    private String historyOfPatient;
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="date")
   private Date date;
   
   @Column(name="gender")
   private String gender;
   
   
@OneToMany( mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JsonManagedReference
//@JoinColumn(name = "pb_fid", referencedColumnName = "id")
private List<BloodPressure> bloodpressure = new ArrayList<>();

@OneToMany( mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)   
private List<BodyWeight> bodyweight = new ArrayList<>();   

@OneToMany( mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)   
private List<PulseRate> pulserate = new ArrayList<>();   

@OneToMany( mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)   
private List<RespiratoryRate> respiratoryrate = new ArrayList<>();   

@OneToMany( mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)   
private List<SPO2> spo2 = new ArrayList<>();   

@OneToMany( mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)   
private List<Temperature> temperature = new ArrayList<>();   

     
   //Constructors
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}



//getters and setters

public int getId() {
	return id;
}

public List<BloodPressure> getBloodpressure() {
	return bloodpressure;
}



public void setBloodpressure(List<BloodPressure> bloodpressure) {
	this.bloodpressure = bloodpressure;
}

public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHistoryOfPatient() {
	return historyOfPatient;
}
public void setHistoryOfPatient(String historyOfPatient) {
	this.historyOfPatient = historyOfPatient;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}



public List<BodyWeight> getBodyweight() {
	return bodyweight;
}



public void setBodyweight(List<BodyWeight> bodyweight) {
	this.bodyweight = bodyweight;
}



public List<PulseRate> getPulserate() {
	return pulserate;
}



public void setPulserate(List<PulseRate> pulserate) {
	this.pulserate = pulserate;
}



public List<RespiratoryRate> getRespiratoryrate() {
	return respiratoryrate;
}



public void setRespiratoryrate(List<RespiratoryRate> respiratoryrate) {
	this.respiratoryrate = respiratoryrate;
}



public List<SPO2> getSpo2() {
	return spo2;
}



public List<Temperature> getTemperature() {
	return temperature;
}



public void setTemperature(List<Temperature> temperature) {
	this.temperature = temperature;
}



public void setSpo2(List<SPO2> spo2) {
	this.spo2 = spo2;
}



}
