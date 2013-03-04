package org.mamce.unikkit.common.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
	
	public static Object getRequestAttribute(String key) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.getRequestMap().get(key);
	}
	
	public static Object getSessionAttribute(String key) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.getSessionMap().get(key);
	}
}
