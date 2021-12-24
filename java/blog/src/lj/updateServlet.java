package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "updateServlet",value ="/update")
public class updateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String delete=request.getParameter("delete");
        String id = request.getParameter("id");
        if (delete==null) {

            String title = request.getParameter("title");
            String type = request.getParameter("type");
            String author = request.getParameter("author");
            String content = request.getParameter("content");
            String pics = request.getParameter("pics");
            System.out.println(title);
            String UPDATESQL = String.format("UPDATE `allcontent` SET " +
                            "`title`=\"%s\", `author`=\"%s\", `content`=%s, `type`=\"%s\", `pics`=\"%s\" " +
                            "WHERE `id`=%s",
                    title, author, content, type, pics, id
            );
            dbTools.excute(UPDATESQL);
            System.out.println(UPDATESQL);
        }else if (delete!=null){
            String DELETESQL=String.format("delete from allcontent where id=%s",id);
            System.out.println(DELETESQL);
            dbTools.excute(DELETESQL);
        }
//        try {
//            response.sendRedirect("./user/blog.html");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
