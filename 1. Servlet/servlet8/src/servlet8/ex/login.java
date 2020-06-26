package servlet8.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter wr = response.getWriter();
		
		if(id != null && id.length()!=0) {
			wr.print("<html><head></head><body>");
			wr.print(id + " 님!! 로그인하셨습니다. <br>");
			wr.print("</body></html>");
		}
		else {
			wr.print("<html><head></head><body>");
			wr.print("아이디를 입력하세요!! <br>");
			wr.print("<a href='http://localhost:8080/servlet8/login.html'>login page</a>");
			wr.print("</body></html>");
		}
		
	}

}
