package org.mamce.unikkit.event.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.event.dao.EventDao;
import org.mamce.unikkit.model.event.Event;
import org.mamce.unikkit.model.event.UnikkScheduleEvent;

/**
 * @author Ramesh
 *
 */
public class EventManagerImpl implements EventManager {

	private EventDao eventDao;
	
	/**
	 * @return the eventDao
	 */
	public EventDao getEventDao() {
		return eventDao;
	}

	/**
	 * @param eventDao the eventDao to set
	 */
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public void saveEvent(Event event) {
		eventDao.saveEvent(event);
	}

	@Override
	public void saveAllEvent(List<Event> events) {
		eventDao.saveAllEvents(events);
	}

	@Override
	public List<Event> findAllEvents() {
		return eventDao.findAllEvents();
	}

	@Override
	public Event findEventById(long id) {
		return eventDao.findEventById(id);
	}

	@Override
	public List<UnikkScheduleEvent> getScheduledEvents() {
		List<Event> allEvents = findAllEvents();
		List<UnikkScheduleEvent> scheduledEvents = new ArrayList<>();
		
		if(allEvents != null && allEvents.size() > Constants.ZERO) {
			for (Iterator<Event> iterator = allEvents.iterator(); iterator.hasNext();) {
				Event event = (Event) iterator.next();
				UnikkScheduleEvent scheduledEvent = new UnikkScheduleEvent(event.getId(), event.getTitle(), event.getStartDate(), event.getEndDate());
				scheduledEvent.setAllDay(event.isAllDay());
				scheduledEvent.setLocation(event.getLocation());
				scheduledEvent.setDescription(event.getDescription());
				scheduledEvent.setId(String.valueOf(event.getId()));
				
				scheduledEvents.add(scheduledEvent);
			}
		}
		
		return scheduledEvents;
	}

	@Override
	public List<Event> findLatestEvents() {
		return eventDao.findLatestEvents();
	}
	
	@Override
	public List<Event> findLatestEvents(int maxLatestEvents) {
		return eventDao.findLatestEvents(maxLatestEvents);
	}
}
