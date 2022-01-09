package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
@WebServlet(name = "modifyServlet",value = "/user/Modify")
public class ModifyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id=String.valueOf(request.getParameter("id"));
        String sql=String.format("select * from allcontent where id='%s'",id);

        List<Text> texts=dbTools.getText(sql);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //StringBuilder stringBuilder=new StringBuilder();
        try(Writer writer = response.getWriter()) {
            try {
                //stringBuilder.append(ListBook.toJson(texts));
                writer.write(ListBook.toJson(texts));
                System.out.println(ListBook.toJson(texts));
                //response.sendRedirect(String.format("./about.html?modify=%s",id));//为什么放在外面就不跳转,答：因为在这里面response已经被关了  ./就表示blog根目录！！！
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //response.getWriter().write(stringBuilder.toString());
    }
}
