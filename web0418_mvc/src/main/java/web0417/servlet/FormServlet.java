package web0417.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0417.dto.SimpleDto;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String mid = request.getParameter("mid");
		String[] singer = request.getParameterValues("singer");
		SimpleDto dto = new SimpleDto();
		dto.setMid(mid);
		dto.setSinger(singer);
		request.setAttribute("mydto", dto); //print_form의 id와 동일하게 이름을 부여해야한다
		System.out.println(dto);
		
		//print_form.jsp로 넘겨서 출력
		RequestDispatcher rd = request.getRequestDispatcher("/print_form.jsp"); //누구에게 넘겨줄지가 관건 
														// 앞에 / 는 현재플젝을 의미
														// 뒤에는 Context Path
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
