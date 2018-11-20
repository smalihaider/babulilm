package com.babulilm.webapp.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.babulilm.webapp.dao.EventDao;
import com.babulilm.webapp.dto.EventDto;

@Component
public class EventConverter {
	@Autowired
	private ModelMapper modelMapper;

	public EventDto getEventDto(EventDao eventDao) {
		return modelMapper.map(eventDao, EventDto.class);
	}

	public EventDao getEventDao(EventDto eventDto) {
		return modelMapper.map(eventDto, EventDao.class);
	}

	public List<EventDto> getEventDtos(List<EventDao> eventDaos) {
		List<EventDto> eventDtos= new ArrayList<EventDto>();
		for (EventDao eventDao: eventDaos) {
			eventDtos.add(getEventDto(eventDao));
		}
		return eventDtos;
	}
}
