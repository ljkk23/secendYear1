package cn.edu.swu;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter extends HttpFilter {

	private static final long serialVersionUID = -2840770222932338931L;
	
	public final static String LOGIN_STATUS = "LOGIN_STATUS";	

	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {

		HttpSession session = request.getSession(true);
		Boolean status = (Boolean) session.getAttribute(LOGIN_STATUS);

		if (status == null || status.equals(Boolean.FALSE)) {
			response.sendRedirect("/myapp/login.html");
		} else {
			chain.doFilter(request, response);
		}
	}

}
