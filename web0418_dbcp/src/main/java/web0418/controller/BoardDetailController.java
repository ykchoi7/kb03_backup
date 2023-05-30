package web0418.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0418.dao.BbsDao;
import web0418.dto.BbsDto;

public class BoardDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		int bno = Integer.parseInt(no);

		try {
			BbsDao dao = new BbsDao();
			BbsDto dto = dao.selectOne(bno);
			request.setAttribute("bto", dto);
			String url = "/board_cafe/detail.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			String url = "/board_cafe/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}
	}

}
