package org.jimzh.mini.events.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event {
	private UUID Id;
	private String Name;
	private Date EventDate = new Timestamp(System.currentTimeMillis());
	private String Address;
	
	public Event() {
	}
	
	public Event(UUID Id, String Name, Date EventDate, String Address) {
		this.Id = Id;
		this.Name = Name;
		this.EventDate = EventDate;
		this.Address = Address;
	}
	
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getEventDate() {
		return EventDate;
	}
	public void setEventDate(Date eventDate) {
		EventDate = eventDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	
	

}
