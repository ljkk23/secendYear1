package lj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        String code=request.getParameter("code");
        String sql="select * from userinfo where username='"+username+
                "';";
        User user=dbTools.getUser(sql);

        HttpSession session=request.getSession(true);
        String codestatus=(String)session.getAttribute(AuthFilter.LOG_VERIFICATAION_STAUS);
        System.out.println(codestatus);
        System.out.println(user.getPass());
        System.out.println(user.getUsername());
        if (user.getUsername().equals(username)) {
                if (!user.getPass().equals(pass)) {
                    response.sendRedirect("./index.jsp?pass=pass");
                }else if (user.getPass().equals(pass)){
                    if (codestatus.equals(code)) {
                        if (user.getIdentity().equals("nuser")) {
                            //session.setAttribute(AuthFilter.LOG_AUTH_STAUS, Boolean.TRUE);
                            //是否记住密码来决定不同的cooike的生命日期
                                Cookie CooikeUsername=new Cookie("logStatus", "1");
//                                Cookie CooikePass=new Cookie("pass", URLEncoder.encode(request.getParameter("pass"), "UTF-8"));
                                //设置过期时间为2分钟
                            CooikeUsername.setMaxAge(1000000*3);
//                               CooikePass.setMaxAge(60*100000);
                                response.addCookie(CooikeUsername);
//                                response.addCookie(CooikePass);
                            response.sendRedirect("./index2.html");

                    }
                }else if (!codestatus.equals(code) || codestatus==null){

                        response.sendRedirect("./index.jsp?code=code");
                    }
            }
        } else if (user.getIdentity().equals("no")) {
            try {
                response.sendRedirect("./ple-register");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


