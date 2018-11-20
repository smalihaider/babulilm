package com.babulilm.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babulilm.webapp.converter.EventConverter;
import com.babulilm.webapp.dao.EventDao;
import com.babulilm.webapp.dto.EventDto;
import com.babulilm.webapp.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private EventConverter eventConverter;
	
	public EventDto createEvent(EventDto eventDto) {
		EventDao eventDao = eventConverter.getEventDao(eventDto);
		EventDao newlyCreatedEventDao = eventRepo.save(eventDao);
		return eventConverter.getEventDto(newlyCreatedEventDao);
	}
	
	public EventDto getEventById(String id) {
		EventDao eventDao = eventRepo.getOne(new Long(id));
		return eventConverter.getEventDto(eventDao);
	}
	
	public List<EventDto> getAllEvents() {
		List<EventDao> eventDaos = eventRepo.findAll();
		return eventConverter.getEventDtos(eventDaos);
	}
	
	public boolean deleteEventById(String id) {
		boolean gotDeleted = true;
		try {
			eventRepo.deleteById(new Long(id));
		} catch (Exception ex) {
			gotDeleted = false;
			ex.printStackTrace();
		}
		return gotDeleted;
	}
}
