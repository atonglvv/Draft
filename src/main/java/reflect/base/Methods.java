package reflect.base;

import com.alibaba.fastjson.JSON;
import common.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @program: draft
 * @description: Java反射 Method 相关
 * @author: atong
 * @create: 2021-01-26 15:08
 */
public class Methods {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = User.class;

        Object o = c.newInstance();
        //反射方法调用
        Method meMethod = c.getMethod("me", int.class, String.class);
        meMethod.invoke(o, 19, "atong");

        Method metMethod = c.getMethod("met");
        //反射方法调用, 返回类型为Object. 但是他的运行类型和方法定义的返回类型一致.
        Object returnObject = metMethod.invoke(o);
        System.out.println("returnObject 的 运行类型 = " + returnObject.getClass());

        System.out.println("==============================");

        Method setNameeMethod = c.getDeclaredMethod("setNamee", String.class);
        setNameeMethod.setAccessible(true);
        setNameeMethod.invoke(o, "tao");
        System.out.println(JSON.toJSONString(o));
        System.out.println("==============================");
        getMethods(c);
    }


    public static void getMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        /*Method[] methods = cl.getMethods();*/
        for (Method method : methods) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            String modifiers = Modifier.toString(method.getModifiers());
            Class<?>[] parameterTypes = method.getParameterTypes();

            System.out.println("Methods Nmae = " + name);
            System.out.println("Methods returnType = " + returnType);
            System.out.println("Methods modifiers = " + modifiers);
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("Methods parameterTypes" + i + " = " + parameterTypes[i]);
            }

            //sout
            if (modifiers.length()>0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(returnType.getName()+" "+ name + "(");
            ParameterType.getParameterType(parameterTypes);
            System.out.println(");");
            System.out.println("==============================");
        }
    }
}
