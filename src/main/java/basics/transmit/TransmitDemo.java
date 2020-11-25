package basics.transmit;

/**
 * Primitive arguments, such as an int or a double, are passed into methods by value.
 * This means that any changes to the values of the parameters exist only within the scope of the method.
 * When the method returns, the parameters are gone and any changes to them are lost.
 *
 * Reference data type parameters, such as objects, are also passed into methods by value.
 * This means that when the method returns, the passed-in reference still references the same object as before.
 * However, the values of the object’s fields can be changed in the method, if they have the proper access level.
 *
 * Java会将对象的地址的拷贝传递给被调函数,可以理解为传递的是对象引用的值。
 */
public class TransmitDemo {
    public static void main(String[] args) {
        String a = "hello";
        int b = 1;

        User user = new User();
        user.setAge(2);
        user.setName("main");

        System.out.println("main1 方法 user = " + user.toString());
        System.out.println("main1 方法 a = " + a);
        System.out.println("main1 方法 b = " + b);

        pass(user, a, b);

        System.out.println("main2 方法 user = " + user.toString());
        System.out.println("main2 方法 a = " + a);
        System.out.println("main2 方法 b = " + b);

    }

    public static void pass(User user, String a, int b) {
        a = "world";
        b = 6;

        user.setName("pass");
        user.setAge(8);

        System.out.println("pass 方法 user = " + user.toString());
        System.out.println("pass 方法 a = " + a);
        System.out.println("pass 方法 b = " + b);
    }
}
