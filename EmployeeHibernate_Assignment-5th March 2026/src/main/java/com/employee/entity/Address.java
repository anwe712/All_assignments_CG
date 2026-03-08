package com.employee.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="address")
public class Address {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String street;
private String city;
private String state;
private String country;

@Pattern(regexp="\\d{6}")
private String pincode;

@OneToOne(mappedBy="address")
private Employee employee;

public Address(){}

public int getId(){return id;}
public void setId(int id){this.id=id;}

public String getStreet(){return street;}
public void setStreet(String street){this.street=street;}

public String getCity(){return city;}
public void setCity(String city){this.city=city;}

public String getState(){return state;}
public void setState(String state){this.state=state;}

public String getCountry(){return country;}
public void setCountry(String country){this.country=country;}

public String getPincode(){return pincode;}
public void setPincode(String pincode){this.pincode=pincode;}

}