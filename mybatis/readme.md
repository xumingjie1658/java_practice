#mybatis 和 hibernate本质区别和应用场景

 * hibernate： 是一个标准的ORM（对象关系映射）框架。入门门槛较高，不需要程序员写sql，sql语句自动生成了。对sql语句优化修改比较困难。

   应用场景： 适用于需求变化不多的中小型项目，比如： 后台管理系统，erp，orm，oa。

 * mybatis： 专注于sql本身，需要程序员自己编写sql语句，sql修改、优化比较方便。

   应用场景： 适用于需求变化较多的项目，比如：互联网项目

企业进行技术选型，以低成本，高回报进行技术选型的原则，根据项目组的技术力量进行选择。