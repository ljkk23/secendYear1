package swu.lj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ListBookServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String sql="select * from textbook";
        List<Book> books=dbUtils.getBooks(sql);
        StringBuilder sb=new StringBuilder();
        sb.append(PageTools.getHeader());
        sb.append(HtmlBook(books));
        sb.append(PageTools.getEnd());
        response.setCharacterEncoding("UTF-8");
        try (Writer writer = response.getWriter()) {
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String HtmlBook(List<Book> books){
        StringBuilder sb=new StringBuilder();
        sb.append("<center><br><table style='width=%70 padding='10' '>");

        sb.append("<tr style='background-color:#336699;color:#ffffff'>" +
                "<th>编号</th><th>书名</th><th>作者</th><th>类型</th><th>价格</th><th>描述</th>" +
                "<th></th><th></th></tr>");//tr是表示表格有几行，th是表头的列，td是表格的列
        for (Book book:books){
            sb.append("<tr style='background-color:#87CEEB'>");
            sb.append("<td>"+book.getId()+"</td>");
            sb.append("<td>"+book.getTitle()+"</td>");
            sb.append("<td>"+book.getAuthor()+"</td>");
            sb.append("<td>"+book.getType()+"</td>");
            sb.append("<td>"+book.getPrice()+"</td>");
            sb.append("<td>"+book.getContent()+"</td>");
            sb.append("<td>"+String.format("<a href='./updateBook?id=%s'>修改</a>",book.getId())+"</td>");//为什么在set的时候就是int类型，但是在get的时候可以用%s
            sb.append("<td>"+String.format("<a href='./deletebook?id=%s'>删除</a>",book.getId())+"</td>");
            sb.append("</tr>");
        }
        sb.append("</table></center>");
        return sb.toString();




    }
}
