package basics.innerclass.member;

/**
 * @program: draft
 * @description:
 * @author: atong
 * @create: 2021-04-25 11:40
 */
public class OuterTest {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}
