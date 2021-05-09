package reflect.main;

import common.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: draft
 * @description: Java 反射 Fields相关
 * @author: atong
 * @create: 2021-01-26 15:44
 */
public class Fields {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class c = User.class;
        getFields(c);
    }

    public static void getFields (Class cl) throws NoSuchFieldException, IllegalAccessException, InstantiationException {


        //getField 不能得到私有属性
        Field nameField = cl.getField("name");

        //反射创建对象
        Object o = cl.newInstance();
        //反射set
        nameField.set(o, "atong");
        //反射get
        System.out.println(nameField.get(o));
        System.out.println("==============================");


        /**
         * getDeclaredFields
         * Returns an array of {@code Field} objects reflecting all the fields
         * declared by the class or interface represented by this
         * {@code Class} object.
         * This includes public, protected, default (package) access, and private fields,
         * but excludes inherited[遗传的;继承权的] fields.
         *
         * <p> If this {@code Class} object represents a class or interface with no
         * declared fields, then this method returns an array of length 0.
         *
         * <p> If this {@code Class} object represents an array type, a primitive
         * type, or void, then this method returns an array of length 0.
         *
         * <p> The elements in the returned array are not sorted and are not in any
         * particular order.
         */
        Field[] declaredFields = cl.getDeclaredFields();
        for (Field field : declaredFields) {
            //方法返回一个Class对象，用于标识此Field对象所表示的字段的声明类型。
            Class<?> type = field.getType();
            //方法返回此Field对象表示的字段的名称。
            String name = field.getName();
            //返回Field修饰符
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
