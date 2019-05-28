package com.cdacportal.actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cdacportal.constants.Constants;
import com.cdacportal.entity.Event;
import com.cdacportal.entity.PortalImages;
import com.cdacportal.service.EventServiceImpl;
import com.cdacportal.service.PortalImagesServiceImpl;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/portal")
public class PortalAction {
	
	public static final Logger log = LoggerFactory.getLogger(PortalAction.class); 
	
	@Autowired
	PortalImagesServiceImpl portalImagesService;
	
	@Autowired
	EventServiceImpl eventService;
	
	@GetMapping(value = "/portalImgList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PortalImages>> portalImgList() {

		List<PortalImages> portalImages = portalImagesService.getPortalImages();
		List<PortalImages> portalImgWithPathList = new ArrayList<PortalImages>();
		log.debug("portalImages=>" + portalImages);
		if (portalImages.isEmpty()) {
			return new ResponseEntity<List<PortalImages>>(HttpStatus.NO_CONTENT);
		} else {
			 ObjectMapper objectMapper = new ObjectMapper();
			 objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			portalImages.stream().forEach((pImg) -> {
				byte[] fileNameBytes=null;
				try {
					fileNameBytes = pImg.getImage().getBytes(1l, (int)pImg.getImage().length());
				} catch (SQLException e) {
					log.info("Can Convert Blob to Bytes");
				}
				String filename=new String(fileNameBytes);
				pImg.setImagePath(Constants.PORTAL_IMG_PATH + filename);
				portalImgWithPathList.add(pImg);
			});
		}
		return new ResponseEntity<List<PortalImages>>(portalImgWithPathList, HttpStatus.OK);
	}

	@PostMapping(value = "/portalImgSave", produces = MediaType.APPLICATION_JSON_VALUE)
	public String portalImgSave(@RequestParam("file") MultipartFile file) {
		String fileName = null;
		try {
			fileName = portalImagesService.UploadPortalImage(file, Constants.PORTAL_IMG_PATH1);
			if (fileName == null) {
				return file.getOriginalFilename() + " Image not Uploaded SuccessFully ";
			}
		} catch (Exception e) {
			return file.getOriginalFilename() + " Image not Uploaded SuccessFully ";
		}
		return fileName + " Image Uploaded SuccessFully ";
	}

	@GetMapping(value = "/noticeList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> noticeList() {
		List<Event> eventList = eventService.getEventList();
		log.debug("eventList=>" + eventList);
		if (eventList.isEmpty()) {
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
	}
}
