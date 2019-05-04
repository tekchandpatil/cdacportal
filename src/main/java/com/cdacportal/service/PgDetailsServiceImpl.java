package com.cdacportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdacportal.entity.PgDetails;
import com.cdacportal.reprository.PgDetailsReprository;

@Service
public class PgDetailsServiceImpl implements PgDetailsService{
	@Autowired
	PgDetailsReprository pgDetailsReprository;
	
	public List<PgDetails> findAllPgDetails() {
		List<PgDetails> pgList = pgDetailsReprository.findAll();
		return pgList;
	}

}
