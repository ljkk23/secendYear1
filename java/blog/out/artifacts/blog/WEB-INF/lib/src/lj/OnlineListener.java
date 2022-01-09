package lj;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class OnlineListener implements HttpSessionListener {
    private int count = 0; // 用于统计在线人数
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
            count++; // Session对象创建时count变量加1
            ServletContext context = hse.getSession().getServletContext();
            context.setAttribute("count", new Integer(count));
            hse.getSession().setMaxInactiveInterval(20*60);//设置与cookie过期时间（认为用户下线的时间）一致
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
            count--; // session对象销毁时count变量减1
            ServletContext context = hse.getSession().getServletContext();
            context.setAttribute("count", new Integer(count));

    }

}
