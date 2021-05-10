# Class 类

## Class也是类，因此也继承Object类。

## Class类对象不是new出来的，而是系统创建的。

## 对于某个类的Class类对象，在内存中只有一份,因为类只加载一次 [NewClass.java 验证]

## 每个类的实例都会记得自己是由哪个Class实例所生成

## 通过Class对象可以完整地得到一个类的完整结构

static Class forName(String name)   返回指定类名name的Class对象

Object newlnstance()                调用缺省构造函数，返回该Class对象的一个实例

getName()                           返回此Class对象所表示的实体(类、接口、数组类、基本类型等）名称

Class getSuperClass()               返回当前Class对象的父类的Class对象

Class [] getlnterfaces()            获取当前Class对象的接口

ClassLoader getClassLoader()        返回该类的类加载器

Class getSuperclass()               返回表示此Class所表示的实体的超类的Class返回一个包含某些Constructor对象的数组

Constructor[] getConstructors()     返回一个包含某些Constructor对象的数组

Field[] getDeclaredFields()          返回Field对象的一个数组

Method getMethod(String name,Class ... paramTypes)      返回一个Method对象，此对象的形参类型为paramType

## Class对象是存放在堆的

## 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括方法代码,变量名，方法名，访问权限等等)

https://www.zhihu.com/question/38496907