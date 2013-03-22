package org.mamce.unikkit.lazy.model;

import java.util.Date;
import java.util.List;

import org.mamce.unikkit.event.manager.EventManager;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;

public class EventLazyModel extends LazyScheduleModel {

	private EventManager eventManager;
	
	/**
	 * @return the eventManager
	 */
	public EventManager getEventManager() {
		return eventManager;
	}

	/**
	 * @param eventManager the eventManager to set
	 */
	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public void loadEvents(Date start, Date end) {
        clear();
        getEvents().addAll(eventManager.getScheduledEvents());
    }
	
    @Override
    public boolean deleteEvent(ScheduleEvent event) {
    	// TODO Auto-generated method stub
    	return super.deleteEvent(event);
    }
    
    @Override
    public ScheduleEvent getEvent(String id) {
    	// TODO Auto-generated method stub
    	return super.getEvent(id);
    }
    
    @Override
    public void updateEvent(ScheduleEvent event) {
    	// TODO Auto-generated method stub
    	super.updateEvent(event);
    }
    
    @Override
    public List<ScheduleEvent> getEvents() {
    	// TODO Auto-generated method stub
    	return super.getEvents();
    }
}


