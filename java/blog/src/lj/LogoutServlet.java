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

        Cookie CooikeUsername=new Cookie("username", "0");
        Cookie CooikePass=new Cookie("pass","0");
        //设置过期时间为2分钟
        System.out.println(CooikeUsername.getName());
        CooikeUsername.setMaxAge(60*1);
        CooikePass.setMaxAge(60*1);
        response.addCookie(CooikeUsername);
        response.addCookie(CooikePass);

//        try {
//            response.sendRedirect("./index.html");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
