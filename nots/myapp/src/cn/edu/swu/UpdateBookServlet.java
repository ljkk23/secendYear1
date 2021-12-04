package cn.edu.swu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateBookServlet extends HttpServlet {

    private static final long serialVersionUID = 119833388866686380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String id       = request.getParameter("id");
        String name     = request.getParameter("name");
        String author   = request.getParameter("author");
        String price    = request.getParameter("price");
        String type     = request.getParameter("type");
        String describe = request.getParameter("describe");

        String sql = String.format("UPDATE `books` SET " +
            "`name`=\"%s\", `author`=\"%s\", `price`=%s, `type`=\"%s\", `describe`=\"%s\" " +
            "WHERE `id`=%s",
            name, author, price, type, describe, id
        );

        System.out.println(sql);

        try {
            DBUtils.update(sql);
            response.sendRedirect("./listBook");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
