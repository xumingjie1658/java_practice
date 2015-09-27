import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CreateCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie cookie = new Cookie("type","Server");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}