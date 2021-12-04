package swu.lj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Updatasql extends HttpServlet {
    String UPDATA="update textbook set title='%s',author='%s',price=%s,type='%s',content='%s' where id=%s";
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String price=request.getParameter("price");
        String type=request.getParameter("type");
        String content=request.getParameter("content");
        String id=request.getParameter("id");

        String sql=String.format(UPDATA,title,author,price,type,content,id);
        dbUtils.excute(sql);

        try {
            response.sendRedirect("./listbook");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
