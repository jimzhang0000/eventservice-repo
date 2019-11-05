package org.jimzh.mini.events.service;

import java.util.UUID;
import org.jimzh.mini.events.database.DbClass;
import org.jimzh.mini.events.exception.DataNotFoundException;
import org.jimzh.mini.events.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventService {

	private Map<UUID, Event> events = DbClass.getEvents();
	
	public EventService() {
		
	}
	
	public Event addEvent(Event event) {
		event.setId(UUID.randomUUID());
		events.put(event.getId(), event);	
		return event;
	}
	
	public Event getEvent(UUID Id) {
		Event event =  events.get(Id);
		if (event == null)
		{
			throw new DataNotFoundException("Event of Id " + Id + " was not found");
		}
		return event;
	}
	
	public List<Event> getAllEvents() {
		return new ArrayList<Event>(events.values());
	}	
}
