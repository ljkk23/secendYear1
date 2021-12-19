package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
@WebServlet(name = "modifyServlet",value = "/Modify")
public class ModifyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        String sql=String.format("select * from allcontent where id='%s'",id);
        System.out.println(sql);

        List<Text> texts=dbTools.getText(sql);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try(Writer writer = response.getWriter()) {
            try {
                writer.write(ListBook.toJson(texts));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("./about.html?modify=1");
    }
}
