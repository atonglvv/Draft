package reflect.clazz;

/**
 * @program: draft
 * @description:
 * void 也有自己的Class对象
 * @author: atong
 * @create: 2021-05-10 23:27
 */
public class VoidClass {
    public static void main(String[] args) {
        Class<Void> voidClass = void.class;
        System.out.println(voidClass);
    }
}
