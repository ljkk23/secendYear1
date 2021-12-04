package cn.edu.swu;

public class PageUtils {
	
	public static String getHeader() {
		String head = "<html>" +
			"<head>" +
				"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />" +
				"<style>" +
					".menu {font-weight:bold; font-size:1em; padding:2em}" +
					"tr {line-height:2.5em}" +
				"</style>" +
			"</head>" +
			"<body>" +
			"<div style='text-align:center;padding:0.7em'><h1>西南大学网上书店</h1></div>" +
			"<div style='text-align:center;padding:0.7em'>" +
			"	<span class='menu'><a href='./index.html'>首 页</a></span>" +
			"	<span class='menu'><a href='./add.html'>添 加</a></span>" +
			"	<span class='menu'><a href='./listBook'>管理</a></span>" +
			"	<span class='menu'><a href='./login'>登录</a></span>" +
			"</div>";
		return head;
	}
	
	public static String getEnd() {
		return "</body></html>";
	}

}
