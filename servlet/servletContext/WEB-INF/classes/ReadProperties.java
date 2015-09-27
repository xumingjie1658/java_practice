import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletContext;
import java.util.Properties;

public class ReadProperties extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        InputStream inputStream = this.getServletContext().getResourceAsStream("info.properties");

        Properties p = new Properties();
        p.load(inputStream);

        out.println("fruit : " + p.getProperty("fruit") + "<br />");

        //读取一个文件的全路径
        String path = this.getServletContext().getRealPath("/imgs/beijing.jpg");
        out.println("path = " + path); 

    }
}