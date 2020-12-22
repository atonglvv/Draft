package tool;

/**
 * @Auther: carver
 * @Date: 2019/4/10 09:26
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */

class HelloWorld {

    int a = 10;
    {
        a = 2;
    }

    public void test(String string) {
        string = "abb";
    }
    public void test(Car car) {
        car.name = "abb";
    }

    public static void main(String[] args) {
        String str = "abc";

        Car car = new Car();

        new HelloWorld().test(car);
        System.out.println(car.name);

        new HelloWorld().test(str);
        System.out.println(str);

        str = "abb";
        System.out.println(str);
        System.out.println(new HelloWorld().a);
    }
}

class Car {
    String name = "car";
}
