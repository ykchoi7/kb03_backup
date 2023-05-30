package web0414.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")  //여기 이름은 꼭 불러오는 html의 action명과 동일하게 해야한다!!
public class RegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//웹페이지 입력값이 한글인 경우 한글 처리
		//전송해주는 웹페이지 내 <meta charset> 값을 적어줘야 한다
		request.setCharacterEncoding("UTF-8");
	
		//한글을 출력하고자 할때
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String[] values = request.getParameterValues("singer");
		for (String s: values) {
			writer.println(s);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
