package web0418.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web0418.dao.MemberDao;
import web0418.dto.MemberDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
//login 정보 처리를 위한 servlet
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/login.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		MemberDao dao = new MemberDao();
		String url = "/member/login.jsp";
		try {
			MemberDto dto = dao.selectOne(mid);
			//미등록 아이디일 때
			if (dto == null) {
				request.setAttribute("msg", "미등록 아이디입니다. 회원가입 해주세요");
				request.getRequestDispatcher(url).forward(request, response);
				return; //실행 종료
			}
			//비밀번호가 틀렸을 때
			if (! pwd.equals(dto.getPassword())) {
				request.setAttribute("msg", "비밀번호가 다릅니다");
				request.getRequestDispatcher(url).forward(request, response);
				return; //실행 종료
			}
			//등록 아이디이면서 비밀번호도 맞으면 -> 로그인 성공!
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);
			url = "board_list.do";
			response.sendRedirect(url); //url의 주소가 바뀌어서 response
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
