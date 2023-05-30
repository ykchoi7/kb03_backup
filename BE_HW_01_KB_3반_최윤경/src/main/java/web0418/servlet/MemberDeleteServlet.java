package web0418.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0418.dao.MemberDao;
import web0418.dto.MemberDto;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/member_delete.do")
public class MemberDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		try {
			MemberDao dao = new MemberDao();
			dao.delete(id);
			String url = "/member/delete.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/member/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDto dto = new MemberDto();
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setIntro(request.getParameter("intro"));
		MemberDao dao = new MemberDao();
		try {
			dao.update(dto);
			String url = "/member/update_ok.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/member/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}

}
