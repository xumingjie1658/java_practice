import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletContext;

public class GetServletContext extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        ServletContext servletContext = this.getServletContext();
        
        String username = (String) servletContext.getAttribute("username");

        out.println("username : " + username);

        String region = (String) this.getInitParameter("region");

        out.println("region : " + region);

        String country = (String) servletContext.getInitParameter("country");

        out.println("country : " + country);
    }
}