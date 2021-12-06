package swu.lj;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "authFilter",urlPatterns = "/manager/*")
public class AuthFilter implements Filter {
    public static final String LOG_VERIFICATAION_STAUS="VERIFICATAION_STAUS";
    public static final String    LOG_AUTH_STAUS="LOG_AUTH_STAUS";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        HttpSession session=httpServletRequest.getSession();
        Boolean status=(Boolean) session.getAttribute(LOG_AUTH_STAUS);
        if (status==null || status.equals(Boolean.FALSE)){
            httpServletResponse.sendRedirect("./index.html");
        }else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
