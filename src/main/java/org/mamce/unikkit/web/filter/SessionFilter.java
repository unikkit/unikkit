package org.mamce.unikkit.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mamce.unikkit.common.util.Constants;
import org.mamce.unikkit.model.user.User;

public class SessionFilter implements Filter {
	// Constants
	// ----------------------------------------------------------------------------------

	/**
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) {

	}

	/**
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Check PathInfo.
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

//		String pathInfo = httpRequest.getRequestURI().substring(
//				httpRequest.getContextPath().length());
//		System.out.println(pathInfo);

		// Get UserSession from HttpSession.
		HttpSession httpSession = httpRequest.getSession();
		User user = (User) httpSession.getAttribute(Constants.USER_SESSION_KEY);
		
		if (user == null) {
			//httpSession.removeAttribute(Constants.USER_MENU_MODEL);
			httpResponse.sendRedirect(httpRequest.getContextPath()
					+ "/login.jsf");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// Apparently there's nothing to destroy?
	}

	// Helpers (may be refactored to some utility class)
	// ------------------------------------------

	/**
	 * Retrieve the cookie value from the given servlet request based on the
	 * given cookie name.
	 * 
	 * @param request
	 *            The HttpServletRequest to be used.
	 * @param name
	 *            The cookie name to retrieve the value for.
	 * @return The cookie value associated with the given cookie name.
	 */

	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie != null && name.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * Set the cookie value in the given servlet response based on the given
	 * cookie name and expiration interval.
	 * 
	 * @param response
	 *            The HttpServletResponse to be used.
	 * @param name
	 *            The cookie name to associate the cookie value with.
	 * @param value
	 *            The actual cookie value to be set in the given servlet
	 *            response.
	 * @param maxAge
	 *            The expiration interval in seconds. If this is set to 0, then
	 *            the cookie will immediately expire.
	 */
	public static void setCookieValue(HttpServletResponse response,
			String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

}
