package web0418.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.cafe")
public class FrontControllerServlet extends HttpServlet {
	
	private HashMap<String, Controller> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		map.put("/board_list.cafe", new BoardListController());
		map.put("/board_detail.cafe", new BoardDetailController());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//포트번호 이후 경로를 RequestURI라고 한다 
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = url.substring(contextPath.length());
        String method = request.getMethod();
        
        map.get(path).execute(request, response);  
        
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
