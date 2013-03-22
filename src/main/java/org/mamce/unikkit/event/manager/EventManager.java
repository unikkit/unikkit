package org.mamce.unikkit.event.manager;

import java.util.List;

import org.mamce.unikkit.model.event.Event;
import org.mamce.unikkit.model.event.UnikkScheduleEvent;

public interface EventManager {

	void saveEvent(Event event);
	void saveAllEvent(List<Event> events);
	List<Event> findAllEvents();
	List<Event> findLatestEvents();
	List<Event> findLatestEvents(int maxLatestEvents);
	List<UnikkScheduleEvent> getScheduledEvents();
	Event findEventById(long id);
}
