package reflect.base;

import common.User;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @program: draft
 * @description: Java反射 Method 相关
 * @author: atong
 * @create: 2021-01-26 15:08
 */
public class Methods {

    public static void main(String[] args) {
        Class c = User.class;
        getMethods(c);
    }


    public static void getMethods(Class cl) {
        Method[] methods = cl.getMethods();
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
