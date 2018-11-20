package com.babulilm.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.babulilm.webapp.dto.EventDto;
import com.babulilm.webapp.service.EventService;
import com.babulilm.webapp.util.ResponseEntityGenerator;

@Controller
@RequestMapping("events")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> createEvent(@RequestBody EventDto eventDto) {
		EventDto createdEventDto = eventService.createEvent(eventDto);
		return ResponseEntityGenerator.generateResponseEntity(createdEventDto, null, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Object> getEvent(@PathVariable String id) {
		EventDto eventDto = eventService.getEventById(id);
		return ResponseEntityGenerator.generateResponseEntity(eventDto, null, HttpStatus.OK);
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<Object> getEvents() {
		List<EventDto> eventDtos = eventService.getAllEvents();
		return ResponseEntityGenerator.generateResponseEntity(eventDtos, null, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Object> deleteEvent(@PathVariable String id) {
		if (eventService.deleteEventById(id)) {
			return ResponseEntityGenerator.generateResponseEntity(null, null, HttpStatus.ACCEPTED);
		} else {
			return ResponseEntityGenerator.generateResponseEntity(null, null, HttpStatus.NO_CONTENT);
		}
	}
}
