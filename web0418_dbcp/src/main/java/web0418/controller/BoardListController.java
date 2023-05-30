package web0418.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0418.dao.BbsDao;
import web0418.dto.BbsDto;

public class BoardListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BbsDao dao = new BbsDao();
			List<BbsDto> list = dao.selectAll();
			request.setAttribute("board_list", list);
			String url = "/board_cafe/list.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e);
			//exception을 "err"라는 객체명에 담아서 에러가 발생했다고 알려주고, error.jsp에서 결과를 출력하도록 하기
			String url = "/board_cafe/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			e.printStackTrace();
		}

	}

}
