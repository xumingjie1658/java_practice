import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyHttpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,java.io.IOException {
		res.getWriter().println("Hello Get Request");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,java.io.IOException {
		res.getWriter().println("Hello Post Request " + req.getParameter("username"));
	}
}