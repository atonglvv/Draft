package basics.innerclass.member;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-25 14:11
 */
public class OuterDemo {
    public int age = 18;
    class Inner {
        public int age = 20;
        public void showAge() {
            int age  = 25;
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(OuterDemo.this.age);
        }
    }

    public static void main(String[] args) {
        Inner inner = new OuterDemo().new Inner();
        inner.showAge();
    }
}
