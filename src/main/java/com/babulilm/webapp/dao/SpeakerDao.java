package com.babulilm.webapp.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "speaker")
public class SpeakerDao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 250)
	private String name;
	
	@NotNull
	@Size(max = 500)
	private String address;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "speaker")
    private Set<EventDao> event;
	
	public void Speaker() {
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<EventDao> getEvent() {
		return event;
	}

	public void setEvent(Set<EventDao> event) {
		this.event = event;
	}
}
