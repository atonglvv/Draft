package reflect.clazz;

import common.User;

/**
 * @program: draft
 * @description: Java 反射 获取Class三种方式
 * @author: atong
 * @create: 2021-01-26 16:38
 */
public class ClassGet {
    public static void main(String[] args) throws ClassNotFoundException {

        String classAllPathName = "common.User";


        /**
         * 1 Object.class
         * 该方法最为安全可靠, 程序性能最高
         * 多用于参数传递, 比如通过反射得到对应构造器对象
         */
        Class<User> classa = User.class;

        /**
         * 2 new Object().getClass()
         */
        User user = new User();
        Class<? extends User> classb = user.getClass();

        /**
         * 3 Class.forName("className")
         * 可能会抛出ClassNotFoundException
         * 多用于配置文件, 读取类全路径, 加载类
         */
        Class classc = null;
        try {

            classc = Class.forName(classAllPathName);
            System.out.println("classc是哪个类的Class对象？  " + classc);
            System.out.println("classc.getClass() = " + classc.getClass());
            //得到该Class对象对应的那个类的包名
            System.out.println("classc包名是 = " + classc.getPackage().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 4 通过类加载器获取类的Class对象
         *
         */
        //4.1 先得到类加载器
        ClassLoader classLoader = user.getClass().getClassLoader();
        Class<?> classd = classLoader.loadClass(classAllPathName);


        //得到类的全类名
        System.out.println("====================");
        System.out.println("User Name = " + classa.getName());
        System.out.println("User Name = " + classb.getName());
        System.out.println("User Name = " + classc.getName());
        System.out.println("User Name = " + classd.getName());

    }
}
