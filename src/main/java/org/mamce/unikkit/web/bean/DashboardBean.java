package org.mamce.unikkit.web.bean;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.event.manager.EventManager;
import org.mamce.unikkit.model.event.Event;
import org.mamce.unikkit.model.quote.Quote;
import org.mamce.unikkit.quote.manager.QuoteManager;
import org.mamce.unikkit.staff.manager.StaffManager;
import org.mamce.unikkit.student.manager.StudentManager;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 * @author IT09B007 - Ganesh
 *
 */
@ManagedBean
public class DashboardBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DashboardModel model;  
	
	@ManagedProperty(value=MP_EVENT_MANAGER)
	private EventManager eventManager;
	
	@ManagedProperty(value=MP_QUOTE_MANAGER)
	private QuoteManager quoteManager;
	
	@ManagedProperty(value=MP_STAFF_MANAGER)
	private StaffManager staffManager;
	
	@ManagedProperty(value=MP_STUDENT_MANAGER)
	private StudentManager studentManager;
	
	private Event selectedEvent;
	
	private List<Quote> featuredQuotes;
	
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
	 * @return the quoteManager
	 */
	public QuoteManager getQuoteManager() {
		return quoteManager;
	}

	/**
	 * @param quoteManager the quoteManager to set
	 */
	public void setQuoteManager(QuoteManager quoteManager) {
		this.quoteManager = quoteManager;
	}

	/**
	 * @return the staffManager
	 */
	public StaffManager getStaffManager() {
		return staffManager;
	}

	/**
	 * @param staffManager the staffManager to set
	 */
	public void setStaffManager(StaffManager staffManager) {
		this.staffManager = staffManager;
	}

	/**
	 * @return the studentManager
	 */
	public StudentManager getStudentManager() {
		return studentManager;
	}

	/**
	 * @param studentManager the studentManager to set
	 */
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	/**
	 * @return the selectedEvent
	 */
	public Event getSelectedEvent() {
		return selectedEvent;
	}

	/**
	 * @param selectedEvent the selectedEvent to set
	 */
	public void setSelectedEvent(Event selectedEvent) {
		this.selectedEvent = selectedEvent;
	}

	/**
	 * @param featuredQuotes the featuredQuotes to set
	 */
	public void setFeaturedQuotes(List<Quote> featuredQuotes) {
		this.featuredQuotes = featuredQuotes;
	}

	public DashboardBean() {  
		model = new DefaultDashboardModel();  
		DashboardColumn column1 = new DefaultDashboardColumn();  
		DashboardColumn column2 = new DefaultDashboardColumn();  

		column1.addWidget("studentStatistics");  
		column2.addWidget("staffStatistics");  
		
		column1.addWidget("quotesOfTheDay");
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
	
	public List<Event> getCurrentEvents() {
		return eventManager.findLatestEvents(UnikkUtils.getMaxLatestEventCount());
	}
	
	public CartesianChartModel getStudentsStats() {
		CartesianChartModel studentStats = new CartesianChartModel();  

		ChartSeries boys = new ChartSeries();  
		boys.setLabel("Boys");  
		List<Object> totalBoysByBatch = studentManager.findTotalBoysByBatch();
		if(totalBoysByBatch != null && !totalBoysByBatch.isEmpty()) {
			for (Iterator iterator = totalBoysByBatch.iterator(); iterator
					.hasNext();) {
				Object[] row = (Object[]) iterator.next();
				boys.set(String.valueOf((Integer) row[1]), (Long) row[0]);

			}
		}

		ChartSeries girls = new ChartSeries();  
		girls.setLabel("Girls");  
		List<Object> totalGirlsByBatch = studentManager.findTotalGirlsByBatch();
		
		if(totalGirlsByBatch != null && !totalGirlsByBatch.isEmpty()) {
			for (Iterator iterator = totalGirlsByBatch.iterator(); iterator
					.hasNext();) {
				Object[] row = (Object[]) iterator.next();
				girls.set(String.valueOf((Integer) row[1]), (Long) row[0]);

			}
		}
		studentStats.addSeries(boys);  
		studentStats.addSeries(girls); 
		
		return studentStats;
	}
	
	public PieChartModel getStaffStats() {
		PieChartModel staffStats = new PieChartModel();  
		  
        staffStats.set("Male Staff", staffManager.findTotalMaleStaffs());
        staffStats.set("Female Staff", staffManager.findTotalMaleStaffs());  
        
        return staffStats;
	}
	
	public List<Quote> getFeaturedQuotes() {
		featuredQuotes = quoteManager.findFeaturedQuotes();
		
		return featuredQuotes;
	}
}
