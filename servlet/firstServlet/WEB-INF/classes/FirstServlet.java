import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FirstServlet implements  Servlet {
	public void init(ServletConfig config) throws ServletException {

	}

    public ServletConfig getServletConfig() {
    	return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("Hello World!");
    }

    public String getServletInfo() {
    	return null;
    }

    public void destroy() {

    }
}