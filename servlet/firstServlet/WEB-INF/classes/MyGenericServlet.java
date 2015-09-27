import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyGenericServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, java.io.IOException {
		res.getWriter().println("<h1>Hello GenericServlet</h1>");
	}
}