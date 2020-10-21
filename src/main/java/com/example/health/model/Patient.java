package com.example.health.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
   @Size(min=4, max=10)
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
   
   
@OneToMany(cascade = CascadeType.ALL) 
@JoinColumn(name = "pb_fid", referencedColumnName = "id")
List<BloodPressure> bloodpressure = new ArrayList<>();
   
   
   
   
   private String weight;
   private String bloodPressure;
   private String temperature;
   private String humidity;
   
   
public List<BloodPressure> getBloodpressure() {
	return bloodpressure;
}
public void setBloodpressure(List<BloodPressure> bloodpressure) {
	this.bloodpressure = bloodpressure;
}
public int getId() {
	return id;
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
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getBloodPressure() {
	return bloodPressure;
}
public void setBloodPressure(String bloodPressure) {
	this.bloodPressure = bloodPressure;
}
public String getTemperature() {
	return temperature;
}
public void setTemperature(String temperature) {
	this.temperature = temperature;
}
public String getHumidity() {
	return humidity;
}
public void setHumidity(String humidity) {
	this.humidity = humidity;
}
@Override
public String toString() {
	return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone="
			+ phone + ", address=" + address + ", historyOfPatient=" + historyOfPatient + ", date=" + date + ", weight="
			+ weight + ", bloodPressure=" + bloodPressure + ", temperature=" + temperature + ", humidity=" + humidity
			+ "]";
}
   
   
   
}
