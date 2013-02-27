package org.mamce.unikkit.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 * @author Ramesh
 *
 */
@ManagedBean
public class DashboardBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DashboardModel model;  

	public DashboardBean() {  
		model = new DefaultDashboardModel();  
		DashboardColumn column1 = new DefaultDashboardColumn();  
		DashboardColumn column2 = new DefaultDashboardColumn();  

		column1.addWidget("quotesOfTheDay");  
		column1.addWidget("studentStatistics");  

		column2.addWidget("staffStatistics");  
		column2.addWidget("events");  

		model.addColumn(column1);  
		model.addColumn(column2);  
	}  

	public void handleReorder(DashboardReorderEvent event) {  
		FacesMessage message = new FacesMessage();  
		message.setSeverity(FacesMessage.SEVERITY_INFO);  
		message.setSummary("Reordered: " + event.getWidgetId());  
		message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());  

		addMessage(message);  
	}  


	private void addMessage(FacesMessage message) {  
		FacesContext.getCurrentInstance().addMessage(null, message);  
	}  

	public DashboardModel getModel() {  
		return model;  
	}  
}
