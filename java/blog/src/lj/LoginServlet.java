package lj;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String pass=request.getParameter("pass");
        String code=request.getParameter("code");
        String sql=sql="select * from userinfo where username='"+username+
                "'";
        User user=dbTools.getUser(sql);
        System.out.println(user.getUsername());
        System.out.println(user.getPass());

        HttpSession session=request.getSession(true);
        String codestatus=(String)session.getAttribute(AuthFilter.LOG_VERIFICATAION_STAUS);
        System.out.println(codestatus);
        if (user.getUsername().equals(username)) {
                if (!user.getPass().equals(pass)) {
                    try {
                        response.sendRedirect("./wpass.jsp");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (user.getPass().equals(pass)){
                    if (codestatus.equals(code)) {
                        if (user.getIdentity().equals("nuser")) {
                        try {
                            //session.setAttribute(AuthFilter.LOG_AUTH_STAUS, Boolean.TRUE);
                            //是否记住密码来决定不同的cooike的生命日期
                                Cookie CooikeUsername=new Cookie("username", URLEncoder.encode(request.getParameter("username"), "UTF-8"));
                                Cookie CooikePass=new Cookie("pass", URLEncoder.encode(request.getParameter("pass"), "UTF-8"));
                                //设置过期时间为2分钟
                                CooikeUsername.setMaxAge(60*2);
                                CooikePass.setMaxAge(60*2);
                                response.addCookie(CooikeUsername);
                                response.addCookie(CooikePass);
                            response.sendRedirect("./user/index2.html");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }else if (!codestatus.equals(code) || codestatus==null){
                        try {
                            response.sendRedirect("./wrongCode.jsp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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


