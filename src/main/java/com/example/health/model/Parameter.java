
  package com.example.health.model;
  
  import javax.persistence.Entity; 
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id; 

  
  @Entity 
  public class Parameter {
  @Id 
 @GeneratedValue(strategy = GenerationType.AUTO) 
  private int id; 
  private String year; 
  private String petroleum_product;
  private String sale;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getPetroleum_product() {
	return petroleum_product;
}
public void setPetroleum_product(String petroleum_product) {
	this.petroleum_product = petroleum_product;
}
public String getSale() {
	return sale;
}
public void setSale(String sale) {
	this.sale = sale;
}
  
  
  
}