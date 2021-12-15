package lj;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authFilter",urlPatterns = "/user/*")
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
        //HttpSession session=httpServletRequest.getSession();
        //Boolean status=(Boolean) session.getAttribute(LOG_AUTH_STAUS);


        Cookie[] cookies = null;
        // 获取与该域相关的 Cookie 的数组
        cookies = httpServletRequest.getCookies();
        //判断cooike中有没有user的cooike
        String userCooike="no";


        if (cookies!=null){//Session在跟踪用户时，是通过cooike跟踪的，所以如果创建了会话，就不能通过有没有cooike去判断
            for (Cookie cookie:cookies){
                System.out.println(cookie.getName());
                if (cookie.getName().equals("username")){
                    userCooike="yes";
                }
            }
            if (userCooike.equals("yes")){
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }else {
                httpServletResponse.sendRedirect("/blog/index.html");
            }
        }else {
            httpServletResponse.sendRedirect("/blog/index.html");
        }
    }

    @Override
    public void destroy() {

    }
}
