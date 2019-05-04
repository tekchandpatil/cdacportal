package com.cdacportal.service;

import java.util.List;

import com.cdacportal.dto.UserRegiDTO;
import com.cdacportal.entity.UserType;



public interface UserRegistrationService 
{
	List<UserRegiDTO> findAllUserDetails(Long userId);
	List<UserType> getUserTypeList();
}
