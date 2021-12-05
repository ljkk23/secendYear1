package swu.lj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        String sql=sql="select * from userinfo where username like '%"+username+
                "%' or password like '%"+pass;
    }
}
