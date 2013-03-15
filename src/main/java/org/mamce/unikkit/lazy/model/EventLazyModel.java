package org.mamce.unikkit.lazy.model;

import java.util.Calendar;
import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;


public class EventLazyModel extends LazyScheduleModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public void loadEvents(Date start, Date end) {  
        clear();
        Calendar date = Calendar.getInstance();
        addEvent(new DefaultScheduleEvent("Lazy Event 1", date.getTime(), date.getTime()));  
    }
	
}
