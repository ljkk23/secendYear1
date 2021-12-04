package swu.lj;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "AddBookServlet", value = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    private static final String INSERT_TEMPLE="insert into textbook(title,author,price,type,content)"+
            "values('%s','%s',%s,'%s','%s')";//?为什么这里是%s
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String price=request.getParameter("price");
        String type=request.getParameter("type");
        String content=request.getParameter("content");

        String sql=String.format(INSERT_TEMPLE,title,author,price,type,content);
        dbUtils.excute(sql);
        System.out.println("成功！");
        response.sendRedirect("./listbook");


    }
}
