package com.cdacportal.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cdacportal.entity.PgDetails;

public interface PgDetailsReprository extends JpaRepository<PgDetails, Long> {

	List<PgDetails> findAll();
}
