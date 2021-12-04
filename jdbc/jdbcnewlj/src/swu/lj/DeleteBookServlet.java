package swu.lj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String id=request.getParameter("id");
        String sql="delete from textbook where id="+id;
        dbUtils.excute(sql);
        try {
            response.sendRedirect("./listbook");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
