package com.cdacportal.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdacportal.entity.PortalImages;

public interface PortalImagesReprository extends JpaRepository<PortalImages, Long> {
	
	List<PortalImages> findAll();

}
