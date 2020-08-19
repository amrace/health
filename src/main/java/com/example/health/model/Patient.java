package com.example.health.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   // @NotBlank(message = "first Name is mandatory")
    private String firstName;
    
   // @NotBlank(message = "lastname is mandatory")
    private String lastName;
    
    private int age;
    //private String sex;
    private String phone;
    private String address;
    private String historyOfPatient;

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

    public String getHistoryOfPatient() {
        return historyOfPatient;
    }

    public void setHistoryOfPatient(String historyOfPatient) {
        this.historyOfPatient = historyOfPatient;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
     * public String getSex() { return sex; } public void setSex(String sex) {
     * this.sex = sex; }
     */
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


}
