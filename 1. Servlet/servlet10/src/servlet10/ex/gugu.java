package servlet10.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gugu
 */
@WebServlet("/gugu")
public class gugu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gugu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charser=utf-8"); 
		PrintWriter pw = response.getWriter();
		int number = Integer.parseInt(request.getParameter("number"));
		
		pw.print("<table border=1 width=800 align=center>");
		pw.print("<tr align=center bgcolor='#FFFF66'>");
		pw.print("<td colspan=2>" + number +" dan <td>");
		for(int i = 1; i<10; i++) {
			pw.print("<tr align=center>");
			pw.print("<td width=400>");
			pw.print(number + " * " + i);
			pw.print("</td>");
			pw.print("<td width=400>");
			pw.print(number * i);
			pw.print("</td>");
			pw.print("</tr>");
		}
	}

}
