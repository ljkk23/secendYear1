package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
@WebServlet(name = "listBook",value = "/Listjson")
public class ListBook extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //通过判断传入的参数的名字来判断应该返回什么数据:公共的blog或者个人的blog
        Enumeration names = request.getParameterNames();
        String sql=null;
        System.out.println("ddd");
        while(names.hasMoreElements()) {
            String name = (String)names.nextElement();

            if (name.equals("page")){
                String page = request.getParameter(name);
                int offset = (Integer.valueOf(page).intValue() - 1) * 6;
                sql = "SELECT * FROM allcontent ORDER BY id DESC LIMIT 6 OFFSET " + offset;
            }else if (name.equals("searchpage")){
                String page = request.getParameter(name);
                String points=request.getParameter("searchPoints");
                String type=request.getParameter("type");
                int offset = (Integer.valueOf(page).intValue() - 1) * 6;
                if (type==null) {
                    sql = "SELECT * FROM allcontent WHERE title LIKE '%" + points + "%' OR content LIKE '%" + points + "%' OR author LIKE '%" + points + "%' ORDER BY id DESC LIMIT 6 OFFSET " + offset;
                }else if (type!=null){
                    sql = "SELECT * FROM allcontent WHERE (title LIKE '%" + points + "%' OR content LIKE '%" + points + "%' OR author LIKE '%" + points + "%') and type='"+type+"' ORDER BY id DESC LIMIT 6 OFFSET " + offset;
                }

            } else if (name.equals("userpage")){
                String userpage = request.getParameter(name);
                String author=null;
                int offset = (Integer.valueOf(userpage).intValue() - 1) * 6;
                String SQLTMP = "SELECT * FROM allcontent where author='%s' ORDER BY id DESC LIMIT 6 OFFSET " + offset;
                //通过cookie确定用户
                Cookie[] cookies = request.getCookies();
                // 获取与该域相关的 Cookie 的数组
                for (Cookie cookie:cookies){
                    System.out.println(cookie.getName());
                    if (cookie.getName().equals("login_code")){
                        author=cookie.getValue();
                        System.out.println(author);
                    }
                }
                sql=String.format(SQLTMP,author);
            }else if (name.equals("id")){
                String id = request.getParameter(name);
                sql = "SELECT * FROM allcontent where id="+id;
            }
        }
        System.out.println(sql);

        List<Text> texts=dbTools.getText(sql);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try(Writer writer = response.getWriter()) {
            try {
                writer.write(this.toJson(texts));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String toJson(List<Text> texts){//必须为static，工具类
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"texts\": [");

        for(int i=0; i<texts.size(); i++) {
            Text text = texts.get(i);
            //System.out.println(text.getId());
            if (i > 0) sb.append(",");
            sb.append(String.format(
                    "{\"id\": \"%s\",\"title\": \"%s\",\"author\": \"%s\",\"pics\": \"%s\",\"type\": \"%s\",\"content\": \"%s\"}",
                    text.getId(),text.getTitle(), text.getAuthor(), text.getPics(), text.getType(), text.getContent()
            ));
        }

        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}
