package com.cdacportal.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="cdac_user_address")
public class Address implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="city")
	//@Size(min=2,max=20,message = "City should not be greater than 20")
	@NotBlank(message = "City is mandatory")	
	private String city;
	
	@Column(name="stateName")
	//@Size(min=2,max=20,message = "State should not be greater than 20")
	@NotBlank(message = "State is mandatory")
	private String state;
	
	@Column(name="pincode")
	//@Size(max=6,message = "Pincode should not be greater than 20")
	@NotBlank(message = "Pincode is mandatory")
	private String pincode;
	
	@Column(name="streetName")
	//@Size(min=2,max=30,message = "Street should not be greater than 30")
	@NotBlank(message = "Street is mandatory")
	private String street;
	
	@Column(name="landMark")
	//@Size(min=2,max=30,message = "LandMark should not be greater than 30")
	@NotBlank(message = "LandMark is mandatory")
	private String landMark;
	
	@Column(name="houseNumber")
//	@Size(min=2,max=20,message = "House Number should not be greater than 20")
	@NotBlank(message = "House Number is mandatory")
	private String houseNumber;


	@OneToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserRegistration user_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getLandMark() {
		return landMark;
	}


	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public UserRegistration getUser_id() {
		return user_id;
	}


	public void setUser_id(UserRegistration user_id) {
		this.user_id = user_id;
	}


	
}
