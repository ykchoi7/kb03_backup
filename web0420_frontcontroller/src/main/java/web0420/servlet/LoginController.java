package web0420.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0420.controller.Controller;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/member/login.jsp";
		//servlet을 실행해서 오류가 떠도 /member/login.jsp를 못 찾겠다는거면 controller와 연결이 잘된 것이므로 성공!
		request.getRequestDispatcher(view).forward(request, response);
	}

}
