package BE_WS_01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet() is called!!");
	}
	
	//오버라이딩 - 부모클래스인 HttpServlet의 init함수를 상속받기 위해 필요 / 안하면 다른 servlet을 상속받음
	@Override
		public void init() throws ServletException {
			super.init();
			System.out.println("init is called");
		}
	
	@Override
		public void destroy() {
			super.destroy();
			System.out.println("destroy is called");
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() is called!!");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>안녕하세요, LifeCycleServlet입니다.</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
