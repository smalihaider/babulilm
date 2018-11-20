package com.babulilm.webapp.dto;

import java.util.Date;
import java.util.Set;

public class EventDto {
	private String id;
	private String name;
	private String description;
	private Date dateAndTime;
	private String venue;
	private String type;
	private Set<SpeakerDto> speakers;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<SpeakerDto> getSpeakers() {
		return speakers;
	}
	public void setSpeakers(Set<SpeakerDto> speakers) {
		this.speakers = speakers;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
