package com.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private Set events = new HashSet();
	private long id;
	private String firstName;
	private String lastName;
	private float age;
	private Set emailAddresses = new HashSet();

	public Set getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(Set emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	
	public void addToEvent(Event event){
		this.getEvents().add(event);
		event.getParticipants().add(this);
	}
	
	public void removeFromEvent(Event event){
		this.getEvents().remove(event);
		event.getParticipants().remove(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	protected Set getEvents() {
		return events;
	}

	protected void setEvents(Set events) {
		this.events = events;
	}
	

}
