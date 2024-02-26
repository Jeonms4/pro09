package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		Cookie cookie = new Cookie("password", "자장");
//		Cookie cookie = new Cookie("menu",URLEncoder.encode("jajang"));
		
		System.out.println(cookie);
		// 지정된 쿠키를 응답에 추가. 이 메소드를 여러 번 호출하여 둘 이상의 쿠키를 설정 가능.
		// 매개 변수 : cookie 클라이언트에 반환될 쿠키
//		cookie.setMaxAge(24*60*60);
		// 이 쿠키의 최대 수명을 초 단위로 설정
		// 양수 값은 몇 초가 지난 후 쿠키가 만료됨을 나타낸다. 값은 현재의 쿠키 수명이 아니라 쿠키가 만료되는 최대 수명
		
		// 음수 값은 쿠키가 지속적으로 저장되지 않으며 웹 브라우저가 종료될 때 삭제된다는 것을 의미
		// 매개 변수 : expiry - 쿠키의 최대 수명을 초 단위로 지정하는 정수.
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		Date date = new Date();
		pw.write(date.toString() + "<br>");
		pw.write(date.toGMTString() + "<br>");
		pw.write(date.toLocaleString() + "<br>");
	}

}
