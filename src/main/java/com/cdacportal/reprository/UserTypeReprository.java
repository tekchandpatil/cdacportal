package com.cdacportal.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdacportal.entity.UserRegistration;
import com.cdacportal.entity.UserType;

public interface UserTypeReprository extends JpaRepository<UserType, Long>{
	
	List<UserType> findAll();
	
	@Query("select u from UserType u where u.userType =:userttype")
	UserType find(@Param("userttype") String usertype);
}
