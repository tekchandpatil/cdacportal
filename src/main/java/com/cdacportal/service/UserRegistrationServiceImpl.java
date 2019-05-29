package com.cdacportal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.integrator.spi.Integrator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdacportal.dto.UserRegiDTO;
import com.cdacportal.entity.Address;
import com.cdacportal.entity.UserRegistration;
import com.cdacportal.entity.UserType;
import com.cdacportal.reprository.AddressReprository;
import com.cdacportal.reprository.UserRegistrationReprository;
import com.cdacportal.reprository.UserTypeReprository;

@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {
	public static Logger log = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
	@Autowired
	UserRegistrationReprository userReprository;
	
	@Autowired
	UserTypeReprository userTypeReprository;
	
	@Autowired
	AddressReprository addressReprository;

	public List<UserRegiDTO> findAllUserDetails(Long userId) {

		List<UserRegiDTO> userDetails = userReprository.findAllUser(userId);
		if (!userDetails.isEmpty()) {
			userDetails.stream().forEach((user) -> {
				UserRegiDTO useraddress = userReprository.findUserAddress(user.getId());
				user.setAddressid(useraddress.getAddressid());
				user.setCity(useraddress.getCity());
				user.setHouseNumber(useraddress.getHouseNumber());
				user.setPincode(useraddress.getPincode());
				user.setState(useraddress.getState());
				user.setStreet(useraddress.getStreet());
				user.setLandMark(useraddress.getLandMark());
			});
		}
		return userDetails;
	}
	
	public UserRegiDTO findLoginUser(String userName,String password) {

		UserRegiDTO userDetails = userReprository.findUser(userName,password);
			
				Address useraddress = addressReprository.findUserAddress(userDetails.getId());
				userDetails.setAddressid(useraddress.getId());
				userDetails.setCity(useraddress.getCity());
				userDetails.setHouseNumber(useraddress.getHouseNumber());
				userDetails.setPincode(useraddress.getPincode());
				userDetails.setState(useraddress.getState());
				userDetails.setStreet(useraddress.getStreet());
				userDetails.setLandMark(useraddress.getLandMark());
				log.debug(userDetails.toString());
		return userDetails;
	}
	
	@Override
	public List<UserType> getUserTypeList() {
		List<UserType> userTypeList = userTypeReprository.findAll();
		
		return userTypeList;
	}

	public String saveUserRegi(JSONObject jsonObj) {
		JSONObject jobj= jsonObj.getJSONObject("userRegi");
		JSONObject jobjadd= jsonObj.getJSONObject("address");
		JSONObject jobjuType= jobj.getJSONObject("usertype");
		UserRegistration user=new UserRegistration();
		UserType usertype=new UserType();
		Address a=new Address();
		a.setCity((String)jobjadd.get("city"));
		a.setHouseNumber((String)jobjadd.get("houseNumber"));
		a.setLandMark((String)jobjadd.get("landMark"));
		a.setPincode((String)jobjadd.get("pincode"));
		a.setStreet((String)jobjadd.get("street"));
		a.setState((String)jobjadd.get("state"));
		
	    usertype.setId(jobjuType.getLong("id"));
		user.setFirstName((String)jobj.get("firstName"));
		user.setMiddleName((String)jobj.get("middleName"));
		user.setLastName((String)jobj.get("lastName"));
		user.setUserName((String)jobj.get("userName"));
		user.setPassword((String)jobj.get("password"));
		user.setEmailId((String)jobj.get("emailId"));
		user.setMobileNo((String)jobj.get("mobileNo"));
		user.setFather_MobNo((String)jobj.get("father_MobNo"));
		user.setDob((String)jobj.get("dob"));
		user.setUserType(usertype);
		a.setUser_id(user);
		user.setAddress(a);
		log.debug(jobj.get("firstName").toString());
		userReprository.save(user);
		return "Save";
	}
	
	
	public String toUpdateUser(JSONArray jsonObj) {
		
		
		JSONObject jobj= jsonObj.getJSONObject(0);
		UserRegistration user=new UserRegistration();
		Address a=new Address();
		UserType usertype=new UserType();
		a.setId(jobj.getLong("addressid"));
		a.setCity((String)jobj.get("city"));
		a.setHouseNumber((String)jobj.get("houseNumber"));
		a.setLandMark((String)jobj.get("landMark"));
		a.setPincode((String)jobj.get("pincode"));
		a.setStreet((String)jobj.get("street"));
		a.setState((String)jobj.get("state"));
		user.setId(jobj.getLong("id"));
		user.setFirstName((String)jobj.get("firstName"));
		user.setMiddleName((String)jobj.get("middleName"));
		user.setLastName((String)jobj.get("lastName"));
		user.setUserName((String)jobj.get("userName"));
		user.setPassword((String)jobj.get("password"));
		user.setEmailId((String)jobj.get("emailId"));
		user.setMobileNo((String)jobj.get("mobileNo"));
		user.setFather_MobNo((String)jobj.get("father_MobNo"));
		user.setDob((String)jobj.get("dob"));
		String userttype= (String)jobj.get("userType");
		UserType usertype1 = userTypeReprository.find(userttype);
		user.setUserType(usertype1);
		a.setUser_id(user);
		user.setAddress(a);
		userReprository.save(user);
		return "Save";
	}
}
