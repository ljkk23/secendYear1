package swu.lj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "main", value = "/main")
public class main extends HttpServlet {
    private static final String INSERT_TEMPLE = "insert into textbook(title,author,price,type,content)" +
            "values('%s','%s',%s,'%s','%s')";//?为什么这里是%s

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public String str()
    {
        return "aaa";
    }
}
