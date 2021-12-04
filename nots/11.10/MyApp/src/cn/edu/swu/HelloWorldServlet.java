package cn.edu.swu;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 2860175530630630813L;
	
	@Override
	public void init() throws ServletException{
		System.out.println("Servlet Initializing");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Servlet Serving");

		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		String color = request.getParameter("color");
		String content = new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"), "UTF-8");
		String[] types = request.getParameterValues("type");
		String typeString = "";
		
		for(String type : types) {
			typeString += new String(type.getBytes("ISO-8859-1"), "UTF-8") + ", ";
		}		
		
		response.setContentType("text/html");
		
		System.out.println(title);
		response.setCharacterEncoding("UTF-8");
		
		try (Writer writer = response.getWriter()) {
			StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			sb.append("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/></head>");
			sb.append("<body><center>");
			sb.append(String.format("<h1 style='color:#%s'>%s</h1><br>", color, title));
			sb.append(String.format("<h4 style='color:#%s'>%s</h4><br>", color, typeString));
			sb.append(String.format("<div style='width:700px'>%s</div>", content));					
			sb.append("</center></body></html>");	
			writer.write(sb.toString());
			writer.flush();
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Destroied");
	}

}
