package com.cdacportal.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdacportal.entity.PgDetails;
import com.cdacportal.service.PgDetailsServiceImpl;

/**
 * @author Tekchand
 *
 */
@RestController
@RequestMapping("/pgDetails")
public class PgDetailsAction {
	
	Logger log =LoggerFactory.getLogger(PgDetailsAction.class);
	
	@Autowired
	PgDetailsServiceImpl pgDetailsService;
	
	/*
	 * This method is getting Pgdetails List
	 * */
	
	@GetMapping(value = "/pgList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PgDetails>> pgList() {

		List<PgDetails> pgDetails = pgDetailsService.findAllPgDetails();
		log.debug("pgDetails=>" + pgDetails);
		if (pgDetails.isEmpty()) {
			return new ResponseEntity<List<PgDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PgDetails>>(pgDetails, HttpStatus.OK);
	}

}
