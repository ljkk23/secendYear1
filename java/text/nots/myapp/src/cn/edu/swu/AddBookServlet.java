package cn.edu.swu;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1139723442711986380L;
	
	private static final String INSERT_TEMPLATE = 
			"INSERT INTO books (`name`, `author`, `price`, `type`, `describe`) " +
			"VALUES ('%s', '%s', %s, '%s', '%s')";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String name     = request.getParameter("name");
		String author   = request.getParameter("author");
		String price    = request.getParameter("price");
		String type     = request.getParameter("type");
		String describe = request.getParameter("describe");
		
		String sql = String.format(INSERT_TEMPLATE, name, author, price, type, describe);
		System.out.println(sql);
		
		try {
			DBUtils.insert(sql);			
			response.sendRedirect("./listBook");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}



