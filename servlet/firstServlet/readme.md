如果没有servlet，我们要如何使用java进行动态网页的编程呢？

bs体系通过http协议传输，在两端客户端和服务端建立socket连接，通过获取分析socket连接，使用java代码读取本地的html文件，根据http请求信息，对返回的html结果进行修改，这样可以使用java进行动态网页的编程。

但是，显然，这样的话，动态网页编程会异常麻烦，程序员需要掌握很多底层的信息，自行提取效率低，所以，有了servlet标准。

servlet标准所做的工作，就是把从http包的获取分析，到服务器端返回浏览器动态网页代码的过程进行了标准化。服务器开发商遵照servlet规范对底层的信息进行封装，程序员遵照servlet规范进行编程，不用再管底层的实现。可以说，servlet是java Web的基础。

servlet基础接口中定义了用于客户端请求处理的方法service方法。当有请求到达时，该方法由servlet容器路由到一个servlet实例。

我们平时在使用servlet的时候，可以自行根据servlet规范进行实现，但是这样不是很方便，开发商已经给我们提供了协议相关的抽象子类HttpServlet，其中有相应的方法将HTTP请求自动的由HttpServlet中实现的service方法转发到相应的相关的处理方法上，包括doGet,doPost,doPut,doDelete,doHead,doOptions,doTrace。

这里我们先根据servlet规范，自行实现servlet接口。
以下是jetty中servlet-api.jar中的servlet接口。

    package javax.servlet;

    import java.io.IOException;
    import javax.servlet.ServletConfig;
    import javax.servlet.ServletException;
    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;
    public interface Servlet {
    	void init(ServletConfig var1) throws ServletException;
    	ServletConfig getServletConfig();
    	void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
    	String getServletInfo();
    	void destroy();
    }

通过集成GenericServlet，只需要实现service函数即可。

    //
    // Source code recreated from a .class file by IntelliJ IDEA
    // (powered by Fernflower decompiler)
    //

    package javax.servlet;

    import java.io.IOException;
    import java.io.Serializable;
    import java.util.Enumeration;
    import java.util.ResourceBundle;
    import javax.servlet.Servlet;
    import javax.servlet.ServletConfig;
    import javax.servlet.ServletContext;
    import javax.servlet.ServletException;
    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;

    public abstract class GenericServlet implements Servlet, ServletConfig, Serializable {
        private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
        private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.LocalStrings");
        private transient ServletConfig config;

        public GenericServlet() {
        }

        public void destroy() {
        }

        public String getInitParameter(String name) {
            ServletConfig sc = this.getServletConfig();
            if(sc == null) {
                throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
            } else {
                return sc.getInitParameter(name);
            }
        }

        public Enumeration getInitParameterNames() {
            ServletConfig sc = this.getServletConfig();
            if(sc == null) {
                throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
            } else {
                return sc.getInitParameterNames();
            }
        }

        public ServletConfig getServletConfig() {
            return this.config;
        }

        public ServletContext getServletContext() {
            ServletConfig sc = this.getServletConfig();
            if(sc == null) {
                throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
            } else {
                return sc.getServletContext();
            }
        }

        public String getServletInfo() {
            return "";
        }

        public void init(ServletConfig config) throws ServletException {
            this.config = config;
            this.init();
        }

        public void init() throws ServletException {
        }

        public void log(String msg) {
            this.getServletContext().log(this.getServletName() + ": " + msg);
        }

        public void log(String message, Throwable t) {
            this.getServletContext().log(this.getServletName() + ": " + message, t);
        }

        public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;

        public String getServletName() {
            ServletConfig sc = this.getServletConfig();
            if(sc == null) {
                throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
            } else {
                return sc.getServletName();
            }
        }
    }

通过集成HttpServlet，其中ServletRequest和ServletResponse分别被封装成了HttpServletRequest和HttpServletResponse。在该父类中，service函数根据不同的http协议头对响应函数进行了分发，包括doGet，doPost等，我们只需要根据协议实现响应的分发函数即可。
