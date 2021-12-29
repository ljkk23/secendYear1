package lj;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authFilter",urlPatterns = "/*")
public class AuthFilter implements Filter {
    public static final String LOG_VERIFICATAION_STAUS="VERIFICATAION_STAUS";
    public static final String    LOG_AUTH_STAUS="LOG_AUTH_STAUS";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //HttpSession session=httpServletRequest.getSession();
        //Boolean status=(Boolean) session.getAttribute(LOG_AUTH_STAUS);
        //不拦截静态资源（js、css以及一些Servlet）
        if (httpServletRequest.getRequestURI().equals("/blog/") || httpServletRequest.getRequestURI().equals("/blog/index.jsp") ||
                httpServletRequest.getRequestURI().indexOf("/blog/assets/")>=0
        || httpServletRequest.getRequestURI().equals("/blog/yanzheng")
        ||  httpServletRequest.getRequestURI().indexOf("/blog/login")>=0
        || httpServletRequest.getRequestURI().indexOf("/blog/register")>=0
        || httpServletRequest.getRequestURI().indexOf("/blog/css")>=0
                || httpServletRequest.getRequestURI().indexOf("/blog/fonts")>=0
                || httpServletRequest.getRequestURI().indexOf("/blog/images")>=0
                || httpServletRequest.getRequestURI().indexOf("/blog/js")>=0
                || httpServletRequest.getRequestURI().indexOf("/blog/upload")>=0
        ) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            //误退出网页
            int i = 0;
            Cookie[] cookies = null;
            // 获取与该域相关的 Cookie 的数组
            cookies = httpServletRequest.getCookies();
            //判断cooike中有没有user的cooike
            String userCooike = "no";
            if (cookies != null) {//Session在跟踪用户时，是通过cooike跟踪的，所以如果创建了会话，就不能通过有没有cooike去判断
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("logStatus") && cookie.getValue().equals("1")) {
                            Cookie newcookie = new Cookie("logStatus", "1");
                            newcookie.setMaxAge(50* 60);
                            httpServletResponse.addCookie(newcookie);
                            System.out.println("logtime new");
                        filterChain.doFilter(httpServletRequest, httpServletResponse);
                    }
                if (cookie.getName().equals("logStatus") && cookie.getValue().equals("0")){
                    httpServletResponse.sendRedirect("/blog/index.jsp");
                    }
                }
            } else {
                httpServletResponse.sendRedirect("/blog/index.jsp");
            }
        }
    }
    @Override
    public void destroy() {

    }
}
