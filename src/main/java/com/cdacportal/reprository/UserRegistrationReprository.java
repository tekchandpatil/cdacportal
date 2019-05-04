package com.cdacportal.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdacportal.dto.UserRegiDTO;
import com.cdacportal.entity.UserRegistration;

public interface UserRegistrationReprository extends JpaRepository<UserRegistration, Long> {
	
	@Query("select new com.cdacportal.dto.UserRegiDTO(u.id,u.firstName,u.middleName,u.lastName,u.userName,u.password,u.dob,u.emailId, u.mobileNo, u.father_MobNo,u1.userType) from UserRegistration u inner join u.userType u1 on u.id =:userId")
	List<UserRegiDTO> findAllUser(@Param("userId") Long userId);
	
	@Query("select new com.cdacportal.dto.UserRegiDTO(a.id,a.city,a.state,a.pincode,a.street,a.landMark,a.houseNumber) from Address a where a.user_id.id =:userid")
	UserRegiDTO findUserAddress(@Param("userid") Long userid);
}
