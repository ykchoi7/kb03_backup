package web0417.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String[] singer = request.getParameterValues("singer");
		String singers = Arrays.toString(singer);
		//여러개의 singer를 추출하고 싶을 때 배열로 저장
		
		response.getWriter().append("mid= " + mid);
		response.getWriter().append(", singer= " + singers);
	}

}
