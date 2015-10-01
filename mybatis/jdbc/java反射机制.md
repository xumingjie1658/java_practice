# java反射机制

* 什么是反射机制?

  反射的概念是由Smith在1982年首先提出来的，主要是指程序可以访问、检测、修改它本身状态或行为的一种能力。
  
  在计算机科学领域，反射是指一类应用，它们能够自描述和自控制。也就是说，这类应用通过采用某种机制来实现对自己行为的描述（self-representation）和监测（examination），并能根据自身行为的状态和结果，调整或修改应用所描述行为的状态和相关的语义。
  
  反射机制最经典的应用是在插件系统上。像vim这样的软件是允许第三方为其开发不同的插件来增强其功能的。这样的软件必然是定义好了插件接口，然后，应用程序本身需要在不知道具体插件的情况下实现对插件的定义。在这种情况下，我们需要对具体插件实现进行反射，搜素到其中对应接口的实现类，然后实例化该插件，并调用相应地函数即可。
  
* java中得反射机制

  Java程序在运行时，Java运行时系统一直对所有的对象进行所谓的运行时类型标识。这项信息记录了每个对象所属的类。虚拟机通常使用运行时类型信息选准正确方法去执行，用来保存这些类型信息的类是Class类。

  上面说的java类的加载都是在需要时进行的。ClassLoader会找到需要调用的类并加载它，然后根据.class文件内记载的类信息来产生一个与该类相联系的独一无二的Class对象。该Class对象记载了该类的字段，方法等等信息。以后jvm要产生该类的实例时，就根据内存中存在的该Class类所记载的信息来进行。
  
  获取Class对象的三种方法：
  * 通过Object类的getClass()方法。例如：
    
    Class c1 = new String("").getClass();
    
  * 通过Class类的静态方法——forName()来实现：
  
    Class c2 = Class.forName("MyObject");
    
  * 如果T是一个已定义的类型的话，在java中，它的.class文件名：T.class就代表了与其匹配的Class对象，例如：
  
    Class c3 = Manager.class;
    
    Class c4 = int.class;
    
    Class c5 = Double[].class;
    
  Class类中的存在的几个重要的方法：
  
  * getName()
  
    一个Class对象描述了一个特定类的特定属性，而这个方法就是返回String形式的该类的简要描述。由于历史原因，对数组的Class对象
调用该方法会产生奇怪的结果。

  * newInstance()
  
    该方法可以根据某个Class对象产生其对应类的实例。需要强调的是，它调用的是此类的默认构造方法。例如：

    MyObject x = new MyObject();

    MyObject y = x.getClass().newInstance();
    
  * getClassLoader()
  
    返回该Class对象对应的类的类加载器。
    
  * getComponentType()
  
    该方法针对数组对象的Class对象，可以得到该数组的组成元素所对应对象的Class对象。例如：
    
    int[] ints = new int[]{1,2,3};
    
    Class class1 = ints.getClass();
    
    Class class2 = class1.getComponentType();
    
    而这里得到的class2对象所对应的就应该是int这个基本类型的Class对象。
    
  * getSuperClass()
  
    返回某子类所对应的直接父类所对应的Class对象。
    
  * isArray()
  
    判定此Class对象所对应的是否是一个数组对象。
    
  那么针对之前所说的插件系统，我们就可以使用上面的方法实现了：
  
  * 从具体插件的配置文件读出插件的类名称
  
  * 通过Class.forName()获取该Class对象
  
  * 调用Class对象的方法getSuperClass()判断该插件的父类，并使用newInstance()构造具体插件的实例。
  
  * 调用具体插件的接口实现
       
# jdbc中使用Class.forName()注册数据库驱动
  
  为什么jdbc需要使用Class.forName()注册数据库驱动呢？因为在DriverManager的实现中，需要使用Driver对象，而在java.sql中只有接口提供。也就是说，类似于插件系统，jdk本身只是提供数据库连接驱动的接口，具体接口的实现让各个数据库厂商自行实现，所以如果不使用Class.forName()将具体的驱动实现加载进来的话，内存中是没有驱动实现代码的，DriverManager就没法在jvm中找到对应的Driver类的实现了。
