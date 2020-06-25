package servlet5.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calc
 */
@WebServlet("/calc")
public class calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calc() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String result = null;
		PrintWriter pw = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String op = request.getParameter("op");
		if(command!=null && command.equals("calculate")) {
			result = calculate(Float.parseFloat(won),op);
			pw.print("<html><head></head><body>");
			pw.print("<font size=10>result<br>");
			pw.print(result + "</font><br>");
			pw.print("<a href='/servlet5/calc'>calculator</a>");
			pw.print("</body></html>");
			pw.close();
			return;
		}
		pw.print("<html><head></head><body>");
		pw.print("<font size=10>calc</font><br>");
		pw.print("<form name='calc' method='get' action='calc' encType='UTF-8'>");
		pw.print("won: <input type='text' name='won'>");
		pw.print("<select name='op'>");
		pw.print("<option value='en'>en</option>");
		pw.print("<option value='dollar'>dollar</option>");
		pw.print("<option value='wian'>wian</option>");
		pw.print("<option value='euro'>euro</option>");
		pw.print("<option value='pound'>pound</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'>");
		pw.print("<input type='submit' name='calc!'>");
		pw.print("</body></html>");
		pw.close();
		
	}
	
	private static String calculate(float won, String op) {
		String result = null;
		switch(op) {
		case "dollar" :
			result = String.format("%.6f", won/2.0);
			break;
		case "en" :
			result = String.format("%.6f", won/3.0);
			break;
		case "wian" :
			result = String.format("%.6f", won/4.0);
			break;
		case "euro" :
			result = String.format("%.6f", won/5.0);
			break;
		case "pound" :
			result = String.format("%.6f", won/6.0);
			break;
		}
		return result;
	}
}

