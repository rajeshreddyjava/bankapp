package com.hibernate.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {
	private Long id;
	private String title;
	private Date date;
	private Set participants = new HashSet();

	public Set getParticipants() {
		return participants;
	}

	public void setParticipants(Set participants) {
		this.participants = participants;
	}

	public Event() {
	}

	public Long getId() {
		return id;
	}



	private void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
