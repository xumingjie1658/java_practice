#intellij中添加classpath和jar包依赖

实际中遇到两个场景：

* 需要将lib目录中的所有jar包加到工程的依赖目录中，以后也无需手动添加

* 在进行单元测试时，读取SqlMapConfig.xml时只使用文件名抛出了IOException找不到文件，需要将配置文件所在目录加到classpath中

解决这两个问题只需要使用intellj的模块依赖功能即可

File -> Project Structure -> Project Settings -> Modules -> Dependencies

进入上述路径的控制界面，点击界面上的加号：

* 添加依赖目录选择"2 Library",再选择Java，再目录选择界面选择lib目录，点击确定后并进一步设置Scope为Compile

* 添加classpath选择"1 JARS or Directories", 选择目录后，进一步选择categories为classes，设置Scope为Compile 