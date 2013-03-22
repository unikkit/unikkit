package org.mamce.unikkit.web.bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.mamce.unikkit.event.manager.EventManager;
import org.mamce.unikkit.lazy.model.EventLazyModel;
import org.mamce.unikkit.model.event.Event;
import org.mamce.unikkit.model.event.UnikkScheduleEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ApplicationScoped
public class ManageEventsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ERR_EVENT_NOT_FOUND = "Event could not be found in the database";
	private static final String MSG_TITLE_SCHEDULE_UPDATED = "Schedule updated";
	private static final String MSG_TITLE_EVENT_NOT_FOUND = "Event not found";
	
	public static final Logger LOGGER = Logger.getLogger(ManageEventsBean.class);

	@ManagedProperty(value=MP_EVENT_MANAGER)
	private EventManager eventManager;
	
	@ManagedProperty(value=MP_EVENT_MODEL)
	private EventLazyModel eventModel;
	
	private UnikkScheduleEvent event;
	
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
	 * @param eventsLazyModel the eventsLazyModel to set
	 */
	public void setEventModel(EventLazyModel eventModel) {
		this.eventModel = eventModel;
	}

	/**
	 * @return the eventsLazyEventModel
	 */
	public EventLazyModel getEventModel() {
		return eventModel;
	}

	/**
	 * @return the event
	 */
	public UnikkScheduleEvent getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(UnikkScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {  
		Event event = null;
		long id = getEvent().getUnikkId();
		try {
			
			if(id > 0) {
				event = eventManager.findEventById(id);
			}
			
			if(event == null) {
				event = new Event();
			}
			populateModel(event);
			eventManager.saveEvent(event);
			this.event.setUnikkId(event.getId());
			
		} catch (Exception e) {
			LOGGER.error("Error while saving new events", e);
		}
		
		if(id <=0) {
			eventModel.addEvent(this.event);
		} else {
			eventModel.updateEvent(this.event);
		}

        this.event = new UnikkScheduleEvent();
    }  
      
    public void onEventSelect(SelectEvent selectEvent) {  
        event = (UnikkScheduleEvent) selectEvent.getObject();
    }  
      
    public void onDateSelect(SelectEvent selectEvent) {
        event = new UnikkScheduleEvent(-1, "", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());  
    }
      
    public void onEventMove(ScheduleEntryMoveEvent event) {
    	setEvent((UnikkScheduleEvent) event.getScheduleEvent());
		long id = getEvent().getUnikkId();
		try {
			Event existingEvent = null;
			if(id > 0) {
				existingEvent = eventManager.findEventById(id);
			} else {
				addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, MSG_TITLE_EVENT_NOT_FOUND, ERR_EVENT_NOT_FOUND));
				return;
			}
			
			if(existingEvent == null) {
				addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, MSG_TITLE_EVENT_NOT_FOUND, ERR_EVENT_NOT_FOUND));
				return;
			}
			populateModel(existingEvent);
			eventManager.saveEvent(existingEvent);
			
		} catch (Exception e) {
			LOGGER.error("Error while moving event", e);
		}
		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Event moved successfully!");  
        addMessage(message);
    }
      
    public void onEventResize(ScheduleEntryResizeEvent event) {
    	setEvent((UnikkScheduleEvent) event.getScheduleEvent());
		long id = getEvent().getUnikkId();
		try {
			Event existingEvent = null;
			if(id > 0) {
				existingEvent = eventManager.findEventById(id);
			} else {
				addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, MSG_TITLE_EVENT_NOT_FOUND, ERR_EVENT_NOT_FOUND));
				return;
			}
			
			if(existingEvent == null) {
				addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, MSG_TITLE_EVENT_NOT_FOUND, ERR_EVENT_NOT_FOUND));
				return;
			}
			populateModel(existingEvent);
			eventManager.saveEvent(existingEvent);
			
		} catch (Exception e) {
			LOGGER.error("Error while updating event", e);
		}
		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, MSG_TITLE_SCHEDULE_UPDATED, "Event schedule updated!");  
        addMessage(message);
    }
      
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
    
    private void populateModel(Event event) {
    	event.setTitle(getEvent().getTitle());
    	event.setStartDate(getEvent().getStartDate());
    	event.setEndDate(getEvent().getEndDate());
    	event.setDescription(getEvent().getDescription());
    	event.setAllDay(getEvent().isAllDay());
    	event.setLocation(getEvent().getLocation());
    }
}
