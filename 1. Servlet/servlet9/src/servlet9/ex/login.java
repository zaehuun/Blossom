package servlet9.ex;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter wr = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id!=null && id.length()!=0) {
			if(id.equals("admin")) {
				wr.print("<html><body>");
				wr.print("관리자로 로그인 했다!<br>");
				wr.print("<input type=button value='manage'> <input type=button value='info reset'>");
				wr.print("</body></html>");
			}
			else {
				wr.print("<html><head></head><body>");
				wr.print(id + " 님!! 로그인하셨습니다. <br>");
				wr.print("</body></html>");
				
			}
		}
		else {
			wr.print("<html><head></head><body>");
			wr.print("아이디를 입력하세요!! <br>");
			wr.print("<a href='http://localhost:8080/servlet9/login.html'>login page</a>");
			wr.print("</body></html>");
		}
	}

}
