package org.mamce.unikkit.web.bean;

import java.io.Serializable;

import org.mamce.unikkit.common.util.Constants;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static final String MP_STUDENT_MANAGER = "#{studentManager}";
	protected static final String MP_SEMESTER_MANAGER = "#{semesterManager}";
	protected static final String MP_MENU_MANAGER = "#{menuManager}";
	protected static final String MP_USER_MANAGER = "#{userManager}";
	protected static final String MP_STAFF_MANAGER = "#{staffManager}";
	protected static final String MP_EVENT_MANAGER = "#{eventManager}";
	protected static final String MP_QUOTE_MANAGER = "#{quoteManager}";
	protected static final String MP_EVENT_MODEL = "#{eventModel}";
	protected static final String MP_ROLE_MANAGER = "#{roleManager}";
	
	private long id = Constants.UNSAVED_ID;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
