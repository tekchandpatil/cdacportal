package com.cdacportal.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cdac_user_registration", uniqueConstraints = @UniqueConstraint(columnNames = { "userName", "emailId" }))
public class UserRegistration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName")
	//@Size(min = 2, max = 20, message = "First Name should not be greater than 20")
	@NotBlank(message = "First Name is mandatory")
	private String firstName;

	@Column(name = "middleName")
//	@Size(min = 2, max = 20, message = "Middle Name should not be greater than 20")
	@NotBlank(message = "Middle Name is mandatory")
	private String middleName;

	@Column(name = "lastName")
	//@Size(min = 2, max = 20, message = "Last Name should not be greater than 20")
	@NotBlank(message = "Last Name is mandatory")
	private String lastName;

	@Column(name = "userName")
	//@Size(min = 5, max = 8, message = "UserName should not be greater than 8")
	//@Pattern(regexp = "^[a-zA-Z0-9]{8}", message = "User Name Should be eg. abc123")
	@NotBlank(message = "User Name is mandatory")
	private String userName;

	@Column(name = "password")
	//@Size(min = 2, max = 20, message = "Password should not be greater than 20")
	@NotBlank(message = "Password is mandatory")
	private String password;

	@Column(name = "dob")
	@NotBlank(message = "DOB is mandatory")
	private String dob;

	@Column(name = "emailId")
	//@Pattern(regexp = ".+@.+\\.[a-z]+")
	//@Email(message = "Email should be valid")
	private String emailId;

	@Column(name = "studMobNo")
//	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Please enter the Valid Number")
	//@Size(max = 10, message = "Mobile Number should not be greater than 10")
	@NotBlank(message = "Mobile No. is mandatory")
	private String mobileNo;

	@Column(name = "fatherMobNo")
	//@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Please enter the Valid Number")
	//@Size(max = 10, message = "Mobile Number should not be greater than 10")
	@NotBlank(message = "Mobile No. is mandatory")
	private String father_MobNo;


	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user_id")
	private Address address;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userType", nullable = false)
	private UserType userType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFather_MobNo() {
		return father_MobNo;
	}

	public void setFather_MobNo(String father_MobNo) {
		this.father_MobNo = father_MobNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
