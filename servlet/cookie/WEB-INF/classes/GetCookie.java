import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie cookies[] = request.getCookies();
		for(int i = 0; i < cookies.length; i++){
			out.println(cookies[i].getName() + ":" + cookies[i].getValue());
		}
	}
}