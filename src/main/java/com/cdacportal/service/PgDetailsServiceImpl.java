package com.cdacportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdacportal.entity.PgDetails;
import com.cdacportal.reprository.PgDetailsReprository;

@Service
public class PgDetailsServiceImpl implements PgDetailsService{
	
	public static Logger log = LoggerFactory.getLogger(PgDetailsServiceImpl.class);
	
	@Autowired
	PgDetailsReprository pgDetailsReprository;
	
	public List<PgDetails> findAllPgDetails() {
		List<PgDetails> pgList = pgDetailsReprository.findAll();
		log.debug(pgList.toString());
		return pgList;
	}

}
