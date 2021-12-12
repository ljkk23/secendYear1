package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "yanzhengServlet",value = "/yanzheng")
public class yanzhengServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);

        yanzheng coder = new yanzheng();
        session.setAttribute(AuthFilter.LOG_VERIFICATAION_STAUS, coder.getCodeString());
        response.setContentType("image/png");
        try (OutputStream output = response.getOutputStream()) {
            coder.outputCodeImage(output);
        }
    }

}
