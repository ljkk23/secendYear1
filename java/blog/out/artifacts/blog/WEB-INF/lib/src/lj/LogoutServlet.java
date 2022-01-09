package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "logoutServlet",value = "/logout")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession(true);
        session.invalidate();

        Cookie CooikeUsername=new Cookie("logStatus", "0");

        //设置过期时间为2分钟
        CooikeUsername.setMaxAge(0);
        System.out.println(CooikeUsername.getName());
        response.addCookie(CooikeUsername);

        try {
            response.sendRedirect("./index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
