package com.cdacportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdacportal.entity.Event;
import com.cdacportal.reprository.EventReprository;

@Service
public class EventServiceImpl {

	public static Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
	
	@Autowired
	EventReprository eventReprository;
	
	public List<Event> getEventList(){
		
	   List<Event> eventList=eventReprository.findAll();
	   log.debug(eventList.toString());
	  return eventList;
	}
	
}
