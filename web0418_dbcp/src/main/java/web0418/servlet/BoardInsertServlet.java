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
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board_insert.do")
public class BoardInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/insert_form.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		BbsDto dto = new BbsDto();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter_id(request.getParameter("writer_id"));
		dto.setContent(request.getParameter("content"));
		BbsDao dao = new BbsDao();
		try {
			dao.insert(dto);
			String url = "/board/insert_ok.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/board/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);

			e.printStackTrace();
		}
	}

}
