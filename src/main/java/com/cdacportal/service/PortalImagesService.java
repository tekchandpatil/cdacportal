package com.cdacportal.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import com.cdacportal.entity.PortalImages;

public interface PortalImagesService {
	
	List<PortalImages> getPortalImages();

	String UploadPortalImage(MultipartFile file, String uploadDirectory);
}
