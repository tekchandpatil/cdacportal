package com.cdacportal.actions;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdacportal.dto.UserRegiDTO;
import com.cdacportal.entity.UserType;
import com.cdacportal.service.UserRegistrationServiceImpl;


/**
 * @author Tekchand
 *
 */
@RestController
@RequestMapping("/api")
public class UserListAction {
	
	public static final Logger log = LoggerFactory.getLogger(UserListAction.class);
	@Autowired
	UserRegistrationServiceImpl userService;

	/*
	 * This method is getting all User List
	 * */
	
	@PostMapping(value = "/userList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserRegiDTO>> listAllUsers(@RequestBody String data) {
		JSONObject jObj=new JSONObject(data);
		
		List<UserRegiDTO> userDetails = userService.findAllUserDetails(jObj.getLong("user_id"));
		log.debug("userDetails=>" + userDetails);
		if (userDetails.isEmpty()) {
			return new ResponseEntity<List<UserRegiDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserRegiDTO>>(userDetails, HttpStatus.OK);
	}
	
	/*
	 * This method for getLogin
	 * */
	
	@PostMapping(value = "/getLogin", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserRegiDTO getLogin(@RequestBody String data) {
		JSONObject jObj=new JSONObject(data);
		
		UserRegiDTO userDetails = userService.findLoginUser(jObj.getString("userName"),jObj.getString("password"));
		log.debug("userDetails=>" + userDetails);
		
		return userDetails;
	}
	
	/*
	 * This method for getUserType List
	 * */
	
	@GetMapping(value = "/userTypeList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserType>> getuserTypeList() {

		List<UserType> userTypeList = userService.getUserTypeList();
		System.out.println(userTypeList);
		if(userTypeList.isEmpty()) {
			return new ResponseEntity<List<UserType>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserType>>(userTypeList, HttpStatus.OK);
	}
	
	/*
	 * This method for save UserDetails
	 * */
	
	@PostMapping(value="/toSaveUserRegi", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> toSaveUserRegi(@RequestBody String data) {
		String success=null;
		try {
			JSONObject jsonObj=new JSONObject(data);
			success=userService.saveUserRegi(jsonObj);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(success, HttpStatus.OK);
		}
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
	
	/*
	 * This method for Update user Profile
	 * */
	
	@PostMapping(value="/toUpdateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> toUpdateUser(@RequestBody String data) {
		String success=null;
		try {
			JSONArray jsonObj=new JSONArray(data);
			success=userService.toUpdateUser(jsonObj);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(success, HttpStatus.OK);
		}
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
	
}
