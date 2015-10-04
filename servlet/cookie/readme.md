cookie，一种客户端保存数据的技术。实际中存在很多这样的用户场景，比如用户不登录就看到浏览过的商品，和浏览器相关的购物车与用户无关（京东），这种需求无法在服务器端建表实现，必须要将数据存储在客户端，所以我们要使用cookie。

在html5标准中，因为cookie的长度为4097个字节（Firefox & Safari），在当前富客户端的用户场景下会不够使用，所以，在html5标准中有localstorage，使客户端存储的大小能达到5M。

cookie可以使用js中的document.cookie在客户端生成，也可以通过服务器端的Cookie对象建立后，调用HttpServletResponse的方法addCookie传回客户端。

使用服务端返回cookie时可以看到，在Response Header中有Set-Cookie:type=Server; Expires=Sat, 26-Sep-2015 09:19:18 GMT，浏览器识别该header，从而将cookie添加到浏览器中。

当有cookie时，Request Header中会将Cookie:type=Server作为一部分，传递到后台。

在使用客户端生成cookie时，只需要修改document.cookie元素即可，这里要注意的是，Cookie的值的要求是“只能用可以用在 URL 编码中的字符”，所以我们要使用escape函数对值进行url编码。

cookie是和浏览器相关的，chrome和ie之间的cookie是不通用的，但是，同为ie内核的ie和360是公用的。session

