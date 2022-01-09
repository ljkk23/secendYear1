package lj;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RegisterServlet",value = "/register")//发布servlet时，不用./register，在跳转时要用./register
public class RegisterServlet extends HttpServlet {
    private static final String LOGIN_INSERT="insert into userinfo(username,password,identity)"+"values('%s','%s','%s')";
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            this.doPost(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        String identity="nuser";

        dbTools.excute(String.format(LOGIN_INSERT, username, pass, identity));
        response.sendRedirect("./index.jsp");
    }
}
