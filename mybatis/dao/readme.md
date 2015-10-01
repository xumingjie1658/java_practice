# mybatis开发dao的方法

  * SqlSession的使用范围
  
    * SqlSessionFactoryBuilder
    
      通过SqlSessionFactoryBuilder创建SqlSessionFactory
      
      将SqlSessionFactoryBuilder当成一个工具类使用即可,不需要使用单例管理SqlSessionFactoryBuilder.
      
      在需要创建SqlSessionFactory的时候,只需要new一次SqlSessionFactoryBuilder即可.
    
    * SqlSessionFactory
    
      通过SqlSessionFactory创建SqlSession,使用单例模式管理SqlSessionFactory(工厂一旦创建,一直使用一个实例).将来mybatis和spring整合后,使用单例模式管理SqlSessionFactory
      
    * SqlSession
    
      SqlSession是一个面向程序员的接口.
      
      SqlSession中提供了很多操作数据库的方法:如: selectOne(返回单个对象),selectList(返回单个或多个对象)
      
      SqlSessions是线程不安全的,在SqlSessions实现类中除了有接口中的方法(操作数据库的方法)还有数据域属性.
      
      SqlSession的最佳应用场合在方法体内,定义成局部变量使用
    
  * 原始dao的开发方法(程序员需要写dao接口和dao实现类)
  
    * 思路
     
      程序员需要写dao接口和dao实现类.
      
      需要向实现类中注入SqlSessionFactory, 在方法体内通过SqlSessionFactory创建SqlSession.
      
    * dao接口
      
    * dao接口实现类
    
    * 原始dao的开发问题
      
      * 接口实现类方法存在大量的模板方法,设想能否将这些方法提取出来,这样就能大大减轻程序员的工作量了.
      
      * 调用SqlSession方法时将statement的id硬编码了,
      
      * 调用SqlSession方法时传入的变量使用泛型,即使变量类型传入错误,在编译阶段也不报错,不利于程序员开发.
      
  
  * mapper代理方法(程序员只需要mapper接口(相当于dao接口))
  
    * 思路
      
      程序员还需要编写mapper.xml映射文件
      
      程序员编写mapper接口,需要遵循一些开发规范,mybatis自动将生成mapper接口实现类的代理对象
      
      开发规范(映射规则):
      
      * 在mapper.xml中namespace等于mapper接口的地址(实现mapper接口和xml文件的对应)
      
      * mapper.java接口中的方法名和mapper.xml中statementz中的id一致.
      
      * mapper.java接口中的方法输入参数类型和mapper.xml中statement的parameterType指定的类型一致.
      
      * mapper.java接口中的方法返回值的类型和映射文件中statement的resultType指定的类型一致
      
# SqlMapConfig.xml
  
  * properties 属性
  
    需求: 将数据库的连接参数单独配置在db.properties中,这样我们只需要在SqlMapConfig.xml中来加载db.properties的属性值.这样,在SqlMapConfig.xml中就不需要对数据库连接的参数硬编码了
  
    将数据库连接参数只配置在db.properties中,原因:方便对参数进行统一管理,其他xml可以引用该db.properties.
  
    注意: mybatis将按照下面的顺序来加载属性(优先级):
   
    * 在properties元素体内定义的属性首先被读取
    
    * 然后会读取properties元素中的resource或url加载的属性,它会覆盖已读取的同名属性
    
    * 最后读取parameterType传递的属性, 它会覆盖已读取的同名属性
    
  * settings全局参数配置
  
    mybatis框架在运行时可以调整一些运行参数, 这些参数会决定mybatis的运行行为
  
    比如:开启二级缓存,开启延迟加载.
   
  * typeAliases(别名) <span style="color: #d41c2f">重点</span>
  
    在mapper.xml中,定义很多的statement,statement需要parameterType指定输入参数的类型, 需要resultType指定输出结果的类型.
    
    如果在指定类型时输入全路径,不方便进行开发,可以针对parameterType或resultType指定的类型定义一些别名,在mapper.xml中通过别名来定义,方便开发
    
    mybatis默认支持很多别名(参见用户手册)
    
    批量定义使用package
    
  * typeHandler (类型处理器)
  
    mybatis中通过typeHandlers完成jdbc类型和java类型的转换
    
    通常情况下,mybatis自动提供的类型处理器满足日常需要, 不需要自定义
    
  * mappers(映射配置)
  
    * 通过resource一次加载一个映射文件
    
    * 通过mapper接口来加载
    
      遵循规范:需要将mapper接口类名和mapper.xml映射文件名称保持一致,且在一个目录下
      
    * 批量加载多个mapper,使用mapper接口的方式,采用package标签实现
    
# 输入映射
  
  通过paramterType指定输入参数的类型(hashmap,pojo的包装对象)
  
  * 传递pojo的包装对象
  
    需求: 完成用户信息的综合查询,需要传入查询条件(可能包括用户信息,其他信息,比如:商品,订单)
    
    针对上边的需求,可以使用自定义的包装类型的pojo,在pojo中将我们所需要的复杂的查询条件包装进行
    
# 输出映射

  * resultType
  
    通过resultType进行输出映射,只有查询出来的列名和pojo的属性名一致,才可以映射成功.
  
    如果查询出来的列名和pojo中的属性名全部不一致,没有创建pojo对象.
  
    如果查询出来的列名和pojo中的属性名有一个一致,就会创建pojo对象.
  
    当查询出来的结果的值只有一行一列,则可以使用简单类型作为resultType.
  
    输出hashmap,将输出的字段名称作为map的key,value为字段值.
  
  * resultMap
  
    通过resultMap可以完成高级的输出结果映射.
  
    使用方法:如果查询出的列名和pojo的属性名不一致,通过定义一个resultMap对列名和pojo属性名之间作一个映射关系.
  
# 动态SQL

  mybatis的核心是对sql语句进行灵活的操作,通过表达式对sql进行判断,对sql进行灵活地拼接,组装.
  
  * 需求
  
    使用动态sql实现用户信息综合查询列表和用户信息查询列表总数
  
    对查询条件进行判断,如果输入的参数不为空,我们才进行查询条件的拼接
  
  * 实现参见UserMapper.xml中的findUserList
  
# SQL片段

  将动态SQL的判断代码段抽取出来,组成一个sql片段,其他的statement中就可以引用该sql片段.
  
  实现参见UserMapper.xml中的query_user_where
  
# foreach标签

  在用户查询列表的statement中增加多个id输入查询
  
  sql语句如下:
  
  SELECT * FROM USER WHERE id=1 OR id=10 OR id=16
  
  SELECT * FROM USER WHERE id IN(1,10,16)
  
  * 在输入参数类型中添加List<Integer> ids来传入多个id
   
  * 修改mapper.xml中的sql片段,