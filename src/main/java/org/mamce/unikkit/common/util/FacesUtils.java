package org.mamce.unikkit.common.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.mamce.unikkit.model.user.User;

/**
 * @author Ramesh
 *
 */
public class FacesUtils {
	
	public static void setRequestAttribute(String key, Object value) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.getRequestMap().put(key, value);
	}
	
	public static void setSessionAttribute(String key, Object value) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.getSessionMap().put(key, value);
	}
	
	public static void invalidateSession() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.removeAttribute(Constants.USER_SESSION_KEY);
		if(session != null) {
			session.invalidate();
		}
	}
	
	public static Object getRequestAttribute(String key) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.getRequestMap().get(key);
	}
	
	public static Object getSessionAttribute(String key) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.getSessionMap().get(key);
	}
	
	public static User getLoggedInUser() {
		return (User) getSessionAttribute(Constants.USER_SESSION_KEY);
	}
	
	public static void addErrorMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR,":( Oops!  ", msg));
	}
	
	public static void addInfoMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO,"", msg));
	}
	
	public static void addFatalMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_FATAL,":( Oops! ", msg));
	}
	
	public static void addWarnMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_WARN,"", msg));
	}
}
