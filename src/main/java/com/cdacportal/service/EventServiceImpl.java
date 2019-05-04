package com.cdacportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdacportal.entity.Event;
import com.cdacportal.reprository.EventReprository;

@Service
public class EventServiceImpl {

	@Autowired
	EventReprository eventReprository;
	
	public List<Event> getEventList(){
		
	   List<Event> eventList=eventReprository.findAll();		
	  return eventList;
	}
	
}
