package org.jimzh.mini.events.resources;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jimzh.mini.events.model.Event;
import org.jimzh.mini.events.service.EventService;

@Path("/events")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class EventsResource {

	EventService eventservice = new EventService();
	
	@POST
	public Event addEvent(Event event) {
		return eventservice.addEvent(event);		
	}
	
	@GET
	public List<Event> getEvents() {
		return eventservice.getAllEvents();
	}
	
	@GET
	@Path("/{eventId}")
	public Event getEvent(@PathParam("eventId") UUID id) {
		return eventservice.getEvent(id);
	}
}
