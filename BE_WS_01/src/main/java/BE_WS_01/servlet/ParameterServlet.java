package BE_WS_01.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BE_WS_01.dto.SimpleDto;
import BE_WS_01.dto.SimpleDto2;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/ParameterServlet")
public class ParameterServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");
		SimpleDto dto = new SimpleDto();
		dto.setJob(job);
		dto.setPageNo(pageNo);
		dto.setSearchWord(searchWord);
		request.setAttribute("mydto", dto);
		System.out.println(dto);
		
		//print_form.jsp로 넘겨서 출력
		RequestDispatcher rd = request.getRequestDispatcher("/get_form.jsp"); //누구에게 넘겨줄지가 관건 

		rd.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청의 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");
		SimpleDto2 dto2 = new SimpleDto2();
		dto2.setName(name);
		dto2.setEmail(email);
		dto2.setGender(gender);
		dto2.setHobby(hobby);
		dto2.setFavorite(favorite);
		dto2.setDesc(desc);
		request.setAttribute("mydto", dto2);
		System.out.println(dto2);
		
		RequestDispatcher rd = request.getRequestDispatcher("/post_form.jsp"); //누구에게 넘겨줄지가 관건 

		rd.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
