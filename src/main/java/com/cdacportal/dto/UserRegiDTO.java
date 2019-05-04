package com.cdacportal.dto;



public class UserRegiDTO 
{
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String userName;
	private String password;
	private String dob;
	private String emailId;
	private String mobileNo;
	private String father_MobNo;
	private Long addressid;
	private String city;
	private String state;
	private String pincode;
	private String street;
	private String landMark;
	private String houseNumber;
	private String userType;

	
	
	
	public UserRegiDTO(Long addressid,String city, String state, String pincode, String street, String landMark, String houseNumber) {
		this.addressid = addressid;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.street = street;
		this.landMark = landMark;
		this.houseNumber = houseNumber;
	}
	public UserRegiDTO(Long id, String firstName, String middleName, String lastName, String userName, String password,
			String dob, String emailId, String mobileNo, String father_MobNo, String userType) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.father_MobNo = father_MobNo;
		this.userType=userType;
	}
	public Long getId() {
		return id;
	}
	public Long getAddressid() {
		return addressid;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getDob() {
		return dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getFather_MobNo() {
		return father_MobNo;
	}

	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPincode() {
		return pincode;
	}
	public String getStreet() {
		return street;
	}
	public String getLandMark() {
		return landMark;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setFather_MobNo(String father_MobNo) {
		this.father_MobNo = father_MobNo;
	}
	public void setAddressid(Long addressid) {
		this.addressid=addressid;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
}
