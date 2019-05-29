package com.cdacportal.service;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdacportal.entity.PortalImages;
import com.cdacportal.reprository.PortalImagesReprository;
import com.cdacportal.util.UploadImageInterface;

@Service
public class PortalImagesServiceImpl implements PortalImagesService {

	public static final Logger log=LoggerFactory.getLogger(PortalImagesServiceImpl.class);
	
	@Autowired
	PortalImagesReprository portalImagesReprository;

	public List<PortalImages> getPortalImages() {
		List<PortalImages> portalImages = portalImagesReprository.findAll();
		if(portalImages.isEmpty()) {
			return portalImages;
		}
		return portalImages;
	}

	@Override
	public String UploadPortalImage(MultipartFile file, String uploadDirectory){

		byte[] fileName = UploadImageInterface.uploadImage(file, uploadDirectory);
		PortalImages pImg = new PortalImages();
		if (fileName != null) {
			String filename=new String(fileName);
			log.debug(filename);
			SerialBlob blob;
			try {
				blob = new SerialBlob(fileName);
				pImg.setImage(blob);
				portalImagesReprository.save(pImg);
				return filename;
			} catch (SQLException e) {
				return null;
			}	
		}
			return null;
	}
}