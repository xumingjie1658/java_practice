在实际需求中，网站在线人数显示是如何是实现的呢？如果通过读取数据库实现的话，读取数据库的频率过于频繁，这种情况下，我们可以使用servletContext。

servletContext是一个公用的空间，可以被所有的客户访问。WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的servletContext对象，它代表当前WEB应用。

servletContext对象可以通过ServletConfig.getServletContext方法获得对ServletContext对象的引用，也可以通过this.getServlet()来获得其对象的引用。

由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。ServletContext对象通常也被称之为context域对象。

ServletContext是当web应用启动的时候，自动创建
ServletContext当web应用关闭/tomcat关闭/对web应用reload会造成ServletContext销毁

通过init-param可以配置某个servlet的初始化参数，通过context-param可以配置整个ContextServlet中的初始化参数。

通过response.sendRedirect("/web应用名/资源名")或request.getRequestDispatcher("/资源名").forward(request,response)可以完成页面跳转。两者的区别：1. getRequestDispatcher发生在web服务器，sendRedirect发生在浏览器； 2. 如果有request.setAttribute("name"，"flippy")，如果希望下一个页面能使用该属性，则需要使用getRequestDispatcher； 3. 如果session设置属性，两个方法均可使用；推荐使用getRequestDispatcher； 4. 如果我们希望跳转到本web应用以外的一个url，则必须使用第一个方法

通过ServletContext进行转发：this.getServletContext().getRequestDispatcher("/资源url").forward(request,response)，这种方法和第二种是一样的

我们还能使用ServletContext对象读取资源文件(properties文件)（可以从根目录或WEB-INF目录下读取）
