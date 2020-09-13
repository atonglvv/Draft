package tool;

/**
 * @Auther: carver
 * @Date: 2019/4/11 11:16
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
class A {
    String t = "t1";

    public void  Test1() {
        System.out.println("这是A-Test1");
    }

    public void  Test2() {
        System.out.println("这是A-Test2:" + t);
    }
}

public class Test extends A {
    String t = "t2";

    public void Test2() {
        System.out.println("这是Test-Test2:" + t);
    }
    public void Test3() {
        System.out.println("这是Test-Test3:" + t);
    }

    public static void main(String[] args) {
        A test = new Test();
        test.Test1();
        test.Test2();
        ((Test)test).Test3();
//        test.Test3(); //error
        System.out.println(test.t);
        test = (Test) test;
        System.out.println(test.t);
    }
}






//class A{
//    double f(double x, double y) {
//        return x * y;
//    }
//
//    double f(double x) {
//        return x + x;
//    }
//
//    void a(A a) {
//        System.out.println("a");
//    }
//}
//
//class B extends A{
//    double f(double x, double y) {
//        return x + y;
//    }
////    int f(int x, int y) {
////        return x + y;
////    }
//
//    String f(String x) {
//        return x + x;
//    }
//    void b(B b) {
//        System.out.println("b");
//    }
//}
//
//public class Test{
//    public static void main(String args[]) {
//
//        B obj = new B();
//        A a = new A();
//        obj.b(obj);
////        obj.b((B) a);
//
//        a.a(a);
//        a.a(obj);
//
//        int num1 = 6;
//        int num2 = 4;
//        double p1 = obj.f(num1, num2);
//        System.out.println("obj.f(6, 4)=" + p1 + ";");
//
//        double p2 = obj.f(p1);
//        System.out.println("obj.f(" + p1 + ")=" + p2 + ";");
//
//        String p3 = obj.f(p1 + "");
//        System.out.println("obj.f(" + p1 + ")=" + p3 + ";");
//    }
//}



//class Ball{
//    private static double r; // 半径
//
//    public void setR(double x) {
//        r = x;
//    }
//
//    public void getR() {
//        System.out.println("球的半径是：" + r + ";");
//    }
//}
//
//class BasketBall extends Ball{
//    private static double r; // 半径
//
//    public void setR(double x) {
//        r = x;
//    }
//
//    public void getR() {
//        System.out.println("篮球的半径是：" + r + ";");
//    }
//}
//
//public class Test{
//    public static void main(String agrs[]) {
//
//        Ball ball = new Ball();
//
//        Ball aball = new BasketBall();
//        aball.setR(12);
//
//        BasketBall bball = new BasketBall();
////        aball.setR(8);
//
//        ball.getR();
//        aball.getR();
//        bball.getR();
//
//
//    }
//}








//public class Test{
//    public static void main(String agrs[]) {
//        try {
//            String[] arr = new String[3];
//            System.out.print("arr[3]=" + arr[3]);
//        } catch (ArrayIndexOutOfBoundsException ae) {
//            System.out.println("警告：出现数组下标越界异常！");
//        } catch (Exception e) {
//            System.out.println("警告：出现未知异常！");
//        }
//    }
//}
