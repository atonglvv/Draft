package reflect.clazz;

import common.User;

/**
 * @program: draft
 * @description: Java 反射 获取Class三种方式
 * @author: atong
 * @create: 2021-01-26 16:38
 */
public class ClassGet {
    public static void main(String[] args) {
        //1 Object.class
        Class<User> classa = User.class;
        //2 new Object().getClass()
        User user = new User();
        Class<? extends User> classb = user.getClass();
        //3 Class.forName("className")
        Class classc = null;
        try {
            String className = "common.User";
            classc = Class.forName(className);
            System.out.println("classc是哪个类的Class对象？  " + classc);
            System.out.println("classc.getClass() = " + classc.getClass());
            //得到该Class对象对应的那个类的包名
            System.out.println("classc包名是 = " + classc.getPackage().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //得到类的全类名
        System.out.println("====================");
        System.out.println("User Name = " + classa.getName());
        System.out.println("User Name = " + classb.getName());
        System.out.println("User Name = " + classc.getName());
    }
}
