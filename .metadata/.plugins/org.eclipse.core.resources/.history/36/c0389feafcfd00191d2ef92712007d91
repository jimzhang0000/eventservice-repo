package org.jimzh.mini.events.service;

import java.util.UUID;
import org.jimzh.mini.events.database.DbClass;
import org.jimzh.mini.events.exception.DataNotFoundException;
import org.jimzh.mini.events.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.sql.Timestamp;

public class EventService {

	private Map<UUID, Event> events = DbClass.getEvents();
	
	public EventService() {
//		final UUID id1 = UUID.randomUUID();
//		final UUID id2 = UUID.randomUUID();
//		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
//		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
//		events.put(id1, new Event(id1, "Breakfast", timestamp1, "address1 "));
//		events.put(id2, new Event(id2, "Lunch", timestamp2, "address2  "));	
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
	
	public Event addEvent(Event event) {
		event.setId(UUID.randomUUID());
		events.put(event.getId(), event);
		return event;
	}	
}
