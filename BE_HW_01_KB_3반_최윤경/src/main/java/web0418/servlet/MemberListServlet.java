package web0418.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web0418.dao.MemberDao;
import web0418.dto.MemberDto;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/member_list.do")
public class MemberListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDto dto = new MemberDto();
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setIntro(request.getParameter("intro"));
		
		try {
			MemberDao dao = new MemberDao();
			List<MemberDto> list = dao.selectAll();
			request.setAttribute("member_list", list);
			String url = "/member/list.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/member/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}
}
