package swu.lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerServlet",value = "/manager")
public class ManagerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(Pagetools.getHeader());
        stringBuffer.append(Pagetools.getEnd());
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
