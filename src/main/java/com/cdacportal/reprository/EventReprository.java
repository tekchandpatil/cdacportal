package com.cdacportal.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdacportal.entity.Event;

public interface EventReprository extends JpaRepository<Event, Long>{
	
	List<Event> findAll();
}
