为什么会有session呢？因为我们在web访问时，会有这样的需求，在不同的页面我们需要共享一些信息，比如登录状态，购物车信息。

所以就有了session，它是服务端技术，服务器在运行的时候可以为每一个用户的浏览器创建一个其独享的session对象。当用户打开浏览器时，访问某个网站时操作session时，服务器就会在服务器的内存为<span style="color:#d40c0c">该浏览器</span>分配一个session对象，该session对象被该浏览器所独占。它默认存在的时间是30分钟。
