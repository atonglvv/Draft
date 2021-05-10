package reflect.clazz;

import common.Person;

/**
 * @program: draft
 * @description:
 * 当 new 一个对象, 到底发生了什么
 * @author: atong
 * @create: 2021-05-10 21:40
 */
public class NewClass {

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * ClassLoader类, parameter: @name -> person全路径类名
         *  public Class<?> loadClass(String name) throws ClassNotFoundException {
         *      return loadClass(name, false);
         *  }
         */
        //在下方代码行处, 打断点。 Force Step Into
        Person person = new Person();


        /**
         * [仍然是通过 ClassLoader类 加载Person类的 Class对象]
         * ClassLoader类, parameter: @name -> person全路径类名
         *  public Class<?> loadClass(String name) throws ClassNotFoundException {
         *      return loadClass(name, false);
         *  }
         */
        //反射方式, 创建Class对象. 在下方代码行处,打断点。 Force Step Into
        // {注意：在调试的时候记得把上面 new Person();代码注释掉, 因为类只加载一次}
        Class aClass = Class.forName("common.Person");


        //对于某个类的Class对象, 在内存中只有一份, 因为类只加载一次
        Class bClass = Class.forName("common.Person");

        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
    }
}
