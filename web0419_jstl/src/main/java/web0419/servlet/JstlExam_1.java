package web0419.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0419.dto.SimpleDto;

/**
 * Servlet implementation class JstlExam_1
 */
@WebServlet("/jstl_1.do")
public class JstlExam_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "Hello JSTL");
		
		String[] sa = new String[] {"aaa", "bbb", "ccc"};
		request.setAttribute("sa", sa);
		
		SimpleDto[] dtos = new SimpleDto[] {
			new SimpleDto("girl", new String[] {"iu", "ive"}),
			new SimpleDto("boy", new String[] {"bigbang", "monstax"})
		};
		request.setAttribute("dtos", dtos);
		
		String url = "/jstl-1.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
