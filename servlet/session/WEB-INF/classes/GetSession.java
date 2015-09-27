import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetSession extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //getSession方法没有session时会自动创建一个session
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        String age = (String)session.getAttribute("age");
        out.println("name : " + name);
        out.println("age : " + age);
    }
}