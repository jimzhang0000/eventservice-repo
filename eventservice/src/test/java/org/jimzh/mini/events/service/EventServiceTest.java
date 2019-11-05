package org.jimzh.mini.events.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import org.jimzh.mini.events.model.Event;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.jimzh.mini.events.database.*;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.InjectMocks;

@RunWith(JUnitPlatform.class)
public class EventServiceTest {
		
	@Mock
	@Autowired
    Event event;
	
	@Mock
	@Autowired
	DbClass dbclass;
	
	@InjectMocks
	@Autowired
    EventService eventservice;
    
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	public EventServiceTest() {
	}
	
	@Test
	final void testGetEvent() {
		Date date = new Timestamp(System.currentTimeMillis());		
		Event event = new Event();		
		event.setAddress("Address of Nike");
		event.setName("Event Name");
		event.setEventDate(date);	
		eventservice.addEvent(event);
		UUID id=event.getId();
		event = eventservice.getEvent(id);	
		assertNotNull(event);
		assertEquals(id, eventservice.getEvent(id).getId());
		assertEquals("Address of Nike", event.getAddress());
		assertEquals("Event Name", event.getName());
		assertEquals(date, event.getEventDate());
	}
	
	@Test
	final void testAddEvent() {
		Date date = new Timestamp(System.currentTimeMillis());		
		Event event = new Event();		
		event.setAddress("Address of Event");
		event.setName("Event Name: Lunch");
		event.setEventDate(date);	
		eventservice.addEvent(event);
		assertNotNull(event);
		Event event1 = new Event();
		UUID id=event.getId();
		event1 = DbClass.getEvents().get(id);		
		assertEquals(event1, eventservice.getEvent(id));
		assertEquals(id, eventservice.getEvent(id).getId());
		assertEquals("Address of Event", eventservice.getEvent(id).getAddress());
		assertEquals("Event Name: Lunch", eventservice.getEvent(id).getName());
		assertEquals(date, eventservice.getEvent(id).getEventDate());
	}
	
	@Test
	final void testGetAllEvents() {	
		Date date = new Timestamp(System.currentTimeMillis());		
		Event event = new Event();		
		event.setAddress("Address1");
		event.setName("Event1: Lunch");
		event.setEventDate(date);	
		eventservice.addEvent(event);		
		UUID id=event.getId();
		Date date2 = new Timestamp(System.currentTimeMillis());		
		Event event2 = new Event();		
		event2.setAddress("Address2");
		event2.setName("Event2: Dinner");
		event2.setEventDate(date2);	
		eventservice.addEvent(event2);	
		UUID id2=event2.getId();
		Map<UUID, Event> map = new HashMap<>();
		
		map = DbClass.getEvents();
		assertEquals(event, map.get(id));
		assertEquals(event2, map.get(id2));		
		assertEquals("Address1", map.get(id).getAddress());
		assertEquals("Event1: Lunch", map.get(id).getName());
		assertEquals(date, map.get(id).getEventDate());
		assertEquals("Address2", map.get(id2).getAddress());
		assertEquals("Event2: Dinner", map.get(id2).getName());
		assertEquals(date, map.get(id2).getEventDate());
	}
}
