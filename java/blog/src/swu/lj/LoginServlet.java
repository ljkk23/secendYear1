package swu.lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN_INSERT="insert into userinfo(username,password)"+"values('%s','%s')";
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            this.doPost(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        dbTools.excute(String.format(LOGIN_INSERT,username,pass));
        System.out.println("succeed!");
        response.sendRedirect("./index.html");
    }
}
