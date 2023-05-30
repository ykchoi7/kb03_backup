package web0414.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet({ "/CalcServlet", "/my_calc" })
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String num1 = request.getParameter("num1");
		int n1 = Integer.parseInt(num1);
		String num2 = request.getParameter("num2");
		int n2 = Integer.parseInt(num2);
		String opr = request.getParameter("opr");
		System.out.println(num1+ ", " + opr +", " + num2);
		
		int result = 0;
		switch (opr) {
		case "+":
			result = n1+n2; break;
		case "-":
			result = n1-n2; break;
		case "*":
			result = n1*n2; break;
		case "/":
			result = n1/n2; break;
		case "%":
			result = n1%n2; break;
		}
		System.out.println(result);
		writer.println(n1+" "+opr+" "+n2+" = "+result);
	}
}
