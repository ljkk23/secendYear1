package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "ListServlet",value = "/List-index")
public class ListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        StringBuffer stringBuffer=new StringBuffer();
        String sql="select * from allcontent";

        stringBuffer.append(Pagetools.getHeader());
        stringBuffer.append(this.toHtmlTable(dbTools.getText(sql)));
        stringBuffer.append(Pagetools.getEnd());
        response.setCharacterEncoding("UTF-8");
        try {
            Writer writer=response.getWriter();
            writer.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toHtmlTable(List<Text> list){
        StringBuffer sb=new StringBuffer();
        sb.append("<center><br><table style='width:70%' border='0' cellpadding='10'>");

        sb.append("<tr style='background-color:#336699;color:#ffffff'>" +
                "<th>书名</th><th>作者</th><th>类型</th><th>描述</th><th>图片</th>" +
                "</tr>");

        for (int i=0; i<list.size(); i++) {
            Text text = list.get(i);
            if (i % 2 == 0) {
                sb.append("<tr style='background-color:#cdcdcd'>");
            } else {
                sb.append("<tr style='background-color:#efefef'>");
            }
            sb.append("<td>").append(text.getTitle()).append("</td>");
            sb.append("<td><b>").append(text.getAuthor()).append("</b></td>");
            sb.append("<td>").append(text.getType()).append("</td>");
            sb.append("<td>").append(text.getContent()).append("</td>");
            //sb.append("<td><img width='100px' src='/myapp/upload/").append(book.getPics().replaceAll(",", "")).append("'></img></td>");
            sb.append("<td>图片</td>");
            sb.append("</tr>");
        }
        sb.append("</table></center>");
        return sb.toString();
    }
}
