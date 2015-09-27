import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletContext;

public class RemoveServletContext extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext2 = this.getServletConfig().getServletContext();
        servletContext2.removeAttribute("username");
    }
}