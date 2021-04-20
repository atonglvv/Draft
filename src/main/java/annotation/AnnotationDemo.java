package annotation;

import java.lang.annotation.*;

/**
 * @program: draft
 * @description: 自定义注解
 * 元注解的作用就是负责注解其他注解。Java5.0定义了4个标准的meta-annotation类型，
 * 它们被用来提供对其它 annotation 类型作说明。
 * Java5.0定义的元注解：
 *  1.@Target,                  [说明了Annotation所修饰的对象范围]
 *      TYPE                    [Class, interface (including annotation type), or enum declaration]
 *      FIELD                   [Field declaration (includes enum constants)]
 *      METHOD
 *      PARAMETER
 *      CONSTRUCTOR
 *      LOCAL_VARIABLE
 *      ANNOTATION_TYPE
 *      PACKAGE
 *      TYPE_PARAMETER          [Type parameter declaration]
 *      TYPE_USE                [Use of a type]
 *  2.@Retention,               [表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）]
 *      SOURCE                  [在源文件中有效（即源文件保留）]
 *      CLASS                   [在class文件中有效（即class保留）]
 *      RUNTIME                 [在运行时有效（即运行时保留）]
 *  3.@Documented,              [标记注解]
 *  4.@Inherited                [标记注解：如果一个使用了@Inherited修饰的annotation类型被用于一个class,则这个annotation将被用于该class的子类]
 *
 * tip:
 * 关于@Retention value的三个枚举[SOURCE/CLASS/RUNTIME]正式对应了Java代码的加载和运行顺序,Java源码文件 -> .class文件 -> 内存字节码。
 * 并且后者范围大于前者，所以一般情况下只需要使用 RetentionPolicy.RUNTIME 即可。
 *
 * @author: atong
 * @create: 2020-11-26 13:44
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AnnotationDemo {

}
