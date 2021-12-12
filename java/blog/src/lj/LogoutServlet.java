package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutServlet",value = "/logout")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession(true);
        session.invalidate();
        try {
            response.sendRedirect("./index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
