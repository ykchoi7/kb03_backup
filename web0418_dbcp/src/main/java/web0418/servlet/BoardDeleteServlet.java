package web0418.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0418.dao.BbsDao;
import web0418.dto.BbsDto;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board_delete.do")
public class BoardDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		int bno = Integer.parseInt(no);

		try {
			BbsDao dao = new BbsDao();
			dao.delete(bno);
			String url = "/board/delete.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/board/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BbsDto dto = new BbsDto();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter_id(request.getParameter("writer_id"));
		dto.setContent(request.getParameter("content"));
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		BbsDao dao = new BbsDao();
		try {
			dao.update(dto);
			String url = "/board/update_ok.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/board/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}

}
