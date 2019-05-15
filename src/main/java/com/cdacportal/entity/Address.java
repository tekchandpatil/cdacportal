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
	
	private String city;
	
	@Column(name="stateName")
	private String state;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="streetName")
	private String street;
	
	@Column(name="landMark")
	private String landMark;
	
	@Column(name="houseNumber")
	private String houseNumber;


	@OneToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserRegistration user_id;

	public Address() {
		
	}

	public Address(Long id, String city, String state, String pincode, String street, String landMark,
			String houseNumber) {
		
		this.id = id;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.street = street;
		this.landMark = landMark;
		this.houseNumber = houseNumber;
	}


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
