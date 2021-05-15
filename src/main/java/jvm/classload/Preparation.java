package jvm.classload;

/**
 * @program: draft
 * @description: 类加载-连接-准备阶段知识点
 * @author: atong
 * @create: 2021-05-12 23:17
 */
public class Preparation {
    //属性-成员变量-字段
    //分析类加载的链接阶段-准备属性是如何处理
    //1. n1 是实例属性,不是静态变量,因此在准备阶段,是不会分配内存
    public int n1 = 10;
    //2. n2 是静态变量, 会分配内存, n2 默认初始化为0, 在初始化阶段初始化为20.
    public static int n2 =20;
    //3. n3 是常量, 会分配内存, n3 在准备阶段默认初始化为 30.
    public static final int n3 = 30;
}