package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddTextServlet",value = "/add")
public class AddTextServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String type=request.getParameter("type");
        String content=request.getParameter("content");
        String tableSql="create table if not exists "+ author+"(title varchar(20),author varchar(20),type varchar(20),content tinytext);";
        String insertSql="insert into "+author+"(title,author,type,content)"+"values('%s','%s','%s','%s')";
        String insert_allSql="insert into allcontent(title,author,type,content)"+"values('%s','%s','%s','%s')";
        dbTools.excute(tableSql);
        dbTools.excute(String.format(insertSql,title,author,type,content));
        dbTools.excute(String.format(insert_allSql,title,author,type,content));
        try {
            response.sendRedirect("./List-index");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
