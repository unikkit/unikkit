package org.mamce.unikkit.web.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.mamce.unikkit.lazy.model.EventLazyModel;

@ManagedBean
@ApplicationScoped
public class ManageEventsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EventLazyModel eventsLazyModel = new EventLazyModel();

	/**
	 * @return the eventsLazyEventModel
	 */
	public EventLazyModel getEventsLazyModel() {
		return eventsLazyModel;
	}

}
