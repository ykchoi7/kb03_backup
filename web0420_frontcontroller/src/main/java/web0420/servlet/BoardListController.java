package web0420.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0420.controller.Controller;

public class BoardListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/board/list.jsp";
		request.getRequestDispatcher(view).forward(request, response);

	}

}
