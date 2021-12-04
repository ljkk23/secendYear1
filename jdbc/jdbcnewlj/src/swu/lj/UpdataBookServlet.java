package swu.lj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdataBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String id=request.getParameter("id");
        StringBuilder sb=new StringBuilder();
        String sql="select * from textbook where id="+id;
        List<Book> books=new ArrayList<Book>();
        books=dbUtils.getBooks(sql);
        Book book = null;
        for (Book book1:books){
            book=book1;
        }
        sb.append(
                "<html>\n" +
                "<head>\n" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"+//这一句必须放在head里面
                "  <title>lj bookstore foy zy</title>\n" +
                "  <style>\n" +
                "    .nav{\n" +
                "      font-size: 1em;\n" +
                "      font-weight: bold;\n" +
                "      padding-left: 3em;\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div style=\"text-align: center; height: 10%;padding: 1em\">\n" +
                "  <span class=\"nav\">首页</span>\n" +
                "  <span class=\"nav\">添加</span>\n" +
                "  <span class=\"nav\">管理图书</span>\n" +
                "  <span class=\"nav\">登录</span>\n" +
                "</div>\n" +
                "<center>\n" +
                "  <div style=\"width: 70%\">\n" +
                String.format("<form action=\"./upsql?id=%s\" method=\"post\">\n",book.getId()) +
                String.format("书名：<input type=\"text\" name=\"title\" value=%s/><br>\n",book.getTitle()) +
                String.format("作者：<input type=\"text\" name=\"author\" value=%s /><br>\n",book.getAuthor()) +
                String.format("价格：<input type=\"text\" name=\"price\" value=%s /><br>\n",book.getPrice()) +
                "      类别：<select name=\"type\">\n"  +
                "      <option value=\"math\"            >数学\n" +
                "      <option value=\"computer\"        >计算机\n" +
                "      <option value=\"culture\"        >文学\n" +
                "      <option value=\"fiction\"        >小说\n" +
                "    </select>\n" +
                String.format("简介：<textarea name=\"content\" cols=\"100\" rows=\"5\" >%s</textarea><br>\n",book.getContent()) +
                "      <input type=\"submit\" value=\"添加图书\">\n" +
                "    </form>\n" +
                "\n" +
                "  </div>\n" +
                "</center>>\n" +
                "</body>\n" +
                "</html>");
        sb.insert(sb.indexOf(book.getType())+book.getType().length()+1,"selected");

        response.setCharacterEncoding("UTF-8");
        try {
            Writer writer=response.getWriter();
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
