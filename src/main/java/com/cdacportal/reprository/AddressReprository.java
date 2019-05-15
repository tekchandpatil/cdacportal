package com.cdacportal.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdacportal.entity.Address;

public interface AddressReprository extends JpaRepository<Address, Long>{
	@Query("select new com.cdacportal.entity.Address(a.id,a.city,a.state,a.pincode,a.street,a.landMark,a.houseNumber) from Address a where a.user_id.id =:userid")
	Address findUserAddress(@Param("userid") Long userid);
}
