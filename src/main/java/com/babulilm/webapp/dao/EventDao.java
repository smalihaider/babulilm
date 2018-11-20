package com.babulilm.webapp.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "event")
public class EventDao {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 250)
	private String name;
	
	@NotNull
	@Size(max = 3000)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@Size(max = 250)
	private String venue;
	
	@Size(max = 250)
	private String type;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "event_speaker",
            joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "speaker_id") })
	private Set<SpeakerDao> speaker;
	
	public EventDao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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

	public Set<SpeakerDao> getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Set<SpeakerDao> speaker) {
		this.speaker = speaker;
	}
}
