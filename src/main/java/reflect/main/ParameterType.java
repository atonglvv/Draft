package reflect.main;

/**
 * @program: draft
 * @description: Java 反射参数类型相关
 * @author: atong
 * @create: 2021-01-26 16:02
 */
public class ParameterType {

    public static void getParameterType(Class[] paramTypes) {
        for (int i = 0; i < paramTypes.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(paramTypes[i].getName());
        }
    }
}
