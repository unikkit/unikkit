package org.mamce.unikkit.event.dao;

import java.util.List;

import org.mamce.unikkit.model.event.Event;

public interface EventDao {

	List<Event> findAllEvents();
	List<Event> findLatestEvents();
	Event findEventById(long id);
	List<Event> findLatestEvents(int maxLatestEvents);
	void saveEvent(Event event);
	void saveAllEvents(List<Event> events);
}
