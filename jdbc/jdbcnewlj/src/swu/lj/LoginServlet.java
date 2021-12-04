package swu.lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
       this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            String username=request.getParameter("username");
            String pass=request.getParameter("pass");

            if (username!=null && pass!=null){
                if (username.equals("lj") && pass.equals("liujian")) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute(AuthFilter.LOG_STATUS, Boolean.TRUE);
                        response.sendRedirect("./admin/listbook");
                    System.out.println("if");

                }else {
                    System.out.println("else");
                    response.sendRedirect("./login.html");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
