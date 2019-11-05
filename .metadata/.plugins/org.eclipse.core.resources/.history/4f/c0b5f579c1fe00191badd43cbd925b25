package org.jimzh.mini.events.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import org.jimzh.mini.events.model.Event;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
    DbClass dbclass;
    
	@InjectMocks
    EventService eventservice;
    
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	public EventServiceTest() {
	}
	
	@Test
	public void testAddEvent() {
		UUID id = UUID.randomUUID();
		Date date = new Timestamp(System.currentTimeMillis());		
		Event event = new Event();
		event.setId(id);
		event.setAddress("Address1");
		event.setName("Event1");
		event.setEventDate(date);	
		EventService eventservice = new EventService();
		eventservice.addEvent(event);	
		Map<UUID, Event> map = new HashMap<>();
		map = (HashMap<UUID, Event>) DbClass.getEvents();
		Event event1 = new Event();
		event1 = map.get(id);
		assertNull(event1);
	}

	@Test
	public void testGetEvent() {
		UUID id = UUID.randomUUID();
		Date date = new Timestamp(System.currentTimeMillis());		
		Event event = new Event();
		EventService eventservice = new EventService();	
		event.setId(id);
		event.setAddress("Address1");
		event.setName("Event1");
		event.setEventDate(date);	
		eventservice.addEvent(event);
		Map<UUID, Event> map = new HashMap<>();
		map = (HashMap<UUID, Event>) DbClass.getEvents();
		Event event1 = new Event();
		event1 = map.get(id);
		assertNull(event1);
	}
	
	@Test
	public void testGetAllEvents() {
		Map<UUID, Event> map = new HashMap<>();
		map = (HashMap<UUID, Event>) DbClass.getEvents();
		assertNotNull(map);
	}
}
