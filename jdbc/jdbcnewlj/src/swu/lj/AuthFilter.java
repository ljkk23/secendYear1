package swu.lj;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName="AuthFilter",urlPatterns ="/admin/*")
public class AuthFilter implements Filter {
    public static final String LOG_STATUS="LOG-STAUS";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
            HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
            HttpSession session=httpServletRequest.getSession(true);
            Boolean status=(Boolean) session.getAttribute(LOG_STATUS);
            if (status==null || status.equals(Boolean.FALSE)){
                httpServletResponse.sendRedirect("./login");
            }else {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }
    }

    @Override
    public void destroy() {

    }
}
