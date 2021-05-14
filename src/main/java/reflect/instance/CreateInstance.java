package reflect.instance;

import common.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: draft
 * @description: 通过反射创建对象
 * @author: atong
 * @create: 2021-05-14 21:26
 */
public class CreateInstance {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //先获取到Class对象
        Class<?> userClass = User.class;

        //通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        //通过public的有参构造器创建对象
        /*
         * constructor 对象就是
         * public User(String name) {   this.name = name;   }
         */
        Constructor<?> constructor = userClass.getConstructor(String.class);
        Object atong = constructor.newInstance("atong");
        System.out.println(atong);

        //通过非public的有参构造器创建对象
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(Integer.class);
        //一定要setAccessible,不然会报错的  [使用反射可以访问private构造器]
        declaredConstructor.setAccessible(true);
        Object o1 = declaredConstructor.newInstance(19);
        System.out.println(o1);

    }
}
