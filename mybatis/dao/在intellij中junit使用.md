# 在intellij中使用junit

* 为实现类新建对应的测试类

  可以使用command + shift + T的快捷键进行新建,也可以下载junitGenerator插件,在generator中生成junit.
  
* 编写测试用例

  注意测试用例需要有@Test注解,并且命名为"test + 首字母大写的函数名"的测试函数,才能进行单元测试.
  
  可以使用@Before 和 @After在测试用例执行前后运行某段代码.