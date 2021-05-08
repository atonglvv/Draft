# Comparable 和 Comparator 的区别

Comparable是排序接口；若一个类实现了Comparable接口，就意味着“该类支持排序”。

Comparator是比较器；我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。

## Comparable
Comparable相当于“内部比较器”，实现了Comparable接口的类有一个特点，就是这些类是可以和自己比较的，
至于具体和另一个实现了Comparable接口的类如何比较，则依赖compareTo方法的实现，compareTo方法也被称为自然比较方法。
如果开发者add进入一个Collection的对象想要Collections的sort方法帮你自动进行排序的话，那么这个对象必须实现Comparable接口。

compareTo方法的返回值是int，有三种情况：
- 比较者大于被比较者（也就是compareTo方法里面的对象），那么返回正整数
  
- 比较者等于被比较者，那么返回0
  
- 比较者小于被比较者，那么返回负整数

## Comparator
Comparator相当于“外部比较器”。

JDK的大量的类包括常见的String、Byte、Char、Date等都实现了Comparable接口。