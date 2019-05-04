package com.cdacportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="cdac_pgdetails")
public class PgDetails
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="broker_name")
	@Size(min=8,max=40,message = "Event Name should not be greater than 40")
	@NotBlank(message = "Broker Name is mandatory")
	private String broker_name;
	
	@Column(name="broker_mob_no")
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Please enter the Valid Number")
	@Size(max=10,message = "broker_mob_noshould not be greater than 10")
	@NotBlank(message = "Broker Mobile Number is mandatory")
	private String broker_mob_no;
	
	@Column(name="location")
	@Size(min=2,max=40,message = "Location should not be greater than 40")
	@NotBlank(message = "Location is mandatory")
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBroker_name() {
		return broker_name;
	}
	public void setBroker_name(String broker_name) {
		this.broker_name = broker_name;
	}
	public String getBroker_mob_no() {
		return broker_mob_no;
	}
	public void setBroker_mob_no(String broker_mob_no) {
		this.broker_mob_no = broker_mob_no;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
