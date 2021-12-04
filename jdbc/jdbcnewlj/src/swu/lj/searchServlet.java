package swu.lj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

public class searchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name=request.getParameter("name");
        String sql=null;
        if (name!=null){
            sql="select * from textbook where title like '%"+name+
                    "%' or content like '%"+name+"%' or author like '%"+name+"%'";
        }else {
            sql="select * from textbook order by id desc limit 6";
        }
        List<Book> books=dbUtils.getBooks(sql);
        response.setCharacterEncoding("UTF-8");
        try {
            Writer writer=response.getWriter();
            StringBuilder sb=new StringBuilder();
            sb.append(PageTools.getIndexHeader());
            sb.append("<center><form action='./index2.html' method='GET'>");
            sb.append("<input type='text' name='name'/>&nbsp;&nbsp;&nbsp;");
            sb.append("<input type='submit' value='查询'/>");
            sb.append("</form></center>");


            sb.append(toHtmlTable(books));
            sb.append(PageTools.getEnd());
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private String toHtmlTable(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        sb.append("<center><br><table style='width:70%' border='0' cellpadding='10'>");

        sb.append("<tr style='background-color:#336699;color:#ffffff'>" +
                "<th>编号</th><th>书名</th><th>作者</th><th>类型</th><th>价格</th><th>描述</th>" +
                "</tr>");
        for (int i=0; i<books.size(); i++) {
            Book book = books.get(i);
            if (i % 2 == 0) {
                sb.append("<tr style='background-color:#cdcdcd'>");
            } else {
                sb.append("<tr style='background-color:#efefef'>");
            }
            sb.append("<td>").append(book.getId()).append("</td>");
            sb.append("<td><b>").append(book.getTitle()).append("</b></td>");
            sb.append("<td>").append(book.getAuthor()).append("</td>");
            sb.append("<td>").append(book.getType()).append("</td>");
            sb.append("<td>").append(book.getPrice()).append("</td>");
            sb.append("<td>").append(book.getContent()).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table></center>");
        return sb.toString();
    }
}

