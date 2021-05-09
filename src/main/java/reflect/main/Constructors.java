package reflect.main;

import common.User;
import reflect.ParameterType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @program: draft
 * @description: 获取类的所有构造器相关信息
 * @author: atong
 * @create: 2021-01-26 14:07
 */
public class Constructors {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {

        Class c = User.class;
        //返回无惨构造器
        Constructor constructor = c.getConstructor();
        System.out.println(constructor);
        //获取只有String参数的构造器
        Constructor constructor1 = c.getConstructor(String.class);
        System.out.println(constructor1);
        System.out.println("==============================");

        //反射获取构造器信息
        getConstructors(c);
    }

    public static void getConstructors(Class cl) {
        //返回Constructor对象数组，其中包含了Class对象的所有构造器
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            String name = constructor.getName();
            Class[] parameterTypes = constructor.getParameterTypes();
            Parameter[] parameters = constructor.getParameters();
            String modifiers = Modifier.toString(constructor.getModifiers());
            //构造器名称
            System.out.println("constructor Name = " + name);
            //参数类型
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("constructor parameterTypes" + i + " = " + parameterTypes[i]);
            }
            //参数
            for (int k = 0; k < parameters.length; k++) {
                System.out.println("constructor parameters" + k + " = " + parameters[k]);
            }
            //构造器修饰符
            System.out.println("constructor modifiers = " + modifiers);

            //sout
            if (modifiers.length()>0) {
                System.out.print(modifiers + "  ");
            }
            System.out.print(name+"(");
            //返回一个用于描述参数类型的Class对象数组
            ParameterType.getParameterType(parameterTypes);
            System.out.println(");");

            System.out.println("==============================");
        }
    }
}
