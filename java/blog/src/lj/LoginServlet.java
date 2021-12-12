package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        String code=request.getParameter("code");
        String sql=sql="select * from userinfo where username='"+username+
                "' and password='"+pass+"'";
        User user=dbTools.getUser(sql);
        HttpSession session=request.getSession(true);
        String codestatus=(String)session.getAttribute(AuthFilter.LOG_VERIFICATAION_STAUS);
        if (!codestatus.equals(code) || codestatus==null){
            try {
                response.sendRedirect("./index.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (codestatus.equals(code)){
            if (user.getIdentity().equals("manager")){
                try {
                    session.setAttribute(AuthFilter.LOG_AUTH_STAUS,Boolean.TRUE);
                    response.sendRedirect("./manager");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (user.getIdentity().equals("nuser")){
                try {
                    response.sendRedirect("./List-index");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (user.getIdentity().equals("no")){
                try {
                    response.sendRedirect("./ple-register");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
