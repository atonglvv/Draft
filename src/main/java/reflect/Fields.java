package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: draft
 * @description: Java 反射 Fields相关
 * @author: atong
 * @create: 2021-01-26 15:44
 */
public class Fields {

    public static void main(String[] args) {
        Class c = User.class;
        getFields(c);
    }

    public static void getFields (Class cl) {
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field field : declaredFields) {
            Class<?> type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());

            System.out.println("Fields Type = " + type);
            System.out.println("Fields Name = " + name);
            System.out.println("Fields modifiers = " + modifiers);

            //sout
            if (modifiers.length()>0) {
                System.out.print(modifiers + "  ");
            }
            System.out.println(type.getName()+" "+ name+ ";");
            System.out.println("==============================");
        }
    }
}
