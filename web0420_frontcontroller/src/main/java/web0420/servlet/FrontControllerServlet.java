package web0420.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0420.controller.Controller;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	
	private HashMap<String, Controller> map = new HashMap<>();
	
	@Override
		public void init(ServletConfig config) throws ServletException {
			map.put("/login.do", new LoginController() );
			map.put("/board_list.do", new BoardListController() );
			map.put("/board_insert_form.do", new BoardInsertFormController() );
			map.put("/board_insert_action.do", new BoardInsertActionController() );
		}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//포트번호 이후 경로를 RequestURI라고 한다 
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = url.substring(contextPath.length());
        String method = request.getMethod();
        System.out.println("url="+url);
        System.out.println("contextPath="+contextPath);
        System.out.println("path="+path);
        System.out.println("method="+method);
        
        //1) controller가 map에서의 context path를 받아와서 실행함
        map.get(path).execute(request, response);  
        
        //2) map을 사용하지 않고 if문을 사용하는 경우 - 모든 경우의 수를 나열해줘야하기 때문에 하수
        if (path.equals("board_list.do")) {
        	Controller c = new BoardListController();
        	c.execute(request, response);
        } else if (path.equals("/board_insert_form.do")) {
        	Controller c = new BoardInsertFormController();
        	c.execute(request, response); 
        } else if (path.equals("/board_insert_action.do")) {
        	Controller c = new BoardInsertActionController();
        	c.execute(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
