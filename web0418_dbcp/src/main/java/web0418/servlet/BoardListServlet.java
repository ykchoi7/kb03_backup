package web0418.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web0418.dao.BbsDao;
import web0418.dto.BbsDto;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board_list.do")
public class BoardListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 여부 검사
		HttpSession session = request.getSession();
		if(session.getAttribute("mid") == null) {  //비로그인 상태일 때
			//login.do로 이동
			response.sendRedirect("login.do"); //상대 경로로 주소 부여 (현재 주소 기준)
			return;
		}
		
		try {
			BbsDao dao = new BbsDao();
			List<BbsDto> list = dao.selectAll();
			request.setAttribute("board_list", list);
			String url = "/board/list.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			//exception을 "err"라는 객체명에 담아서 에러가 발생했다고 알려주고, error.jsp에서 결과를 출력하도록 하기
			String url = "/board/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}
}
