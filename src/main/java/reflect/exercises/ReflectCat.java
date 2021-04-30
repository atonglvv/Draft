package reflect.exercises;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-30 20:36
 */
public class ReflectCat {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /*
         * 读取配置文件 re.properties
         * 创建Cat对象
         * 调用 hi 方法
         */

        // 传统的方式: new Cat -> 调用方法
        Cat cat = new Cat();
        cat.hi();

        //1.使用 Properties 类 , 可以读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\java\\reflect\\exercises\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + methodName);

        //2.使用反射机制
        //2.1 加载类, 返回Class类型的对象
        Class cls = Class.forName(classfullpath);
        //2.2 通过cls 得到 Cat 实例
        Object o = cls.newInstance();
        //输出运行类型
        System.out.println("o的运行类型 = " + o.getClass());
        //2.3 通过 cls 得到 "hi" 方法 [在反射中, 可以把方式视为对象, 万物皆对象]
        Method method = cls.getMethod(methodName);
        //2.4 通过方法对象实现方法调用
        //传统方式 ： 对象.方法; 反射方式 ： 方法.invoke(对象)
        method.invoke(o);


    }
}
