# mybatis是什么？

mybatis是一个持久层框架，是apache下的顶级项目。

mybatis让程序员将主要精力放在sql上，通过mybatis的映射方式，自由灵活生成（半自动化，大部分需要程序员编写sql）满足需要的sql语句。

mybatis可以将向preparedStatement中的输入参数自动进行输入映射，将查询结果集灵活地映射出java对象（输出映射）。

# mybatis的框架

  * sqlMapConfig.xml（是mybatis的全局配置文件，名称不固定）配置了数据源、事务等mybatis运行环境

  * mapper.xml...中配置映射文件（配置sql语句）

  * SqlSessionFactory（会话工厂，根据配置文件创建）作用：创建SqlSession

  * SqlSession（会话，一个面向程序员的接口） 作用：操作数据库（发出sql增、删、改、查）

  * Executor（执行器，是一个接口（基本执行器、缓存执行器）） 作用： SqlSession内部的Executor来操作数据库

  * mapper statement（底层封装对象） 作用：对操作数据库存储封装，包括sql语句，输入参数、输出结果类型

  * 输入参数类型：java简单类型、hashmap、pojo自定义

  * 输出参数类型：java简单类型、hashmap、pojo自定义


# 根据用户id(主键)查询用户信息

  * 映射文件(User.xml)

    User.xml是原始的ibatis.xml的命名方式,mapper代理开发映射文件名称为XXXMapper.xml

    在映射文件中配置sql语句

  * paramterType

    在映射文件中通过parameterType指定输入参数的类型

  * resultType

    在映射文件中通过resultType指定输出结果的类型

  * #{} 和 ${}

    #{}表示一个占位符,会用''包含,类型是简单类型,pojo,hashmap等.

    ${}表示拼接符号, 会引起sql注入,所以不建议使用

    两者接收pojo对象值,通过OGNL读取对象中d的属性值,通过属性.属性.属性...的方式获取对象属性值.

  * selectOne 和 selectList

    selectOne表示查询出一条记录进行映射.如果使用selectOne可以实现,使用selectList也可以实现.

    selectList表示查询一个列表(多条记录)进行映射.多条记录不能使用selectOne代替.

  * insert时mysql自增主键返回

    mysql自增主键, 执行insert提交之前自动生成一个自增主键.

    通过mysql函数获取到刚插入的自增主键:LAST_INSERT_ID()

    使用mybatis的selectKey标签

  * 非自增主键的返回

    使用mysql的uuid()函数生成主键,需要修改表中id的字段类型为String,长度为35

    先通过uuid()查询出主键,再将主键输入到sql语句中.

    执行uuid()的顺序相对于insert之前.

