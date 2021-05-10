package reflect.clazz;

/**
 * @program: draft
 * @description: 基本数据类型获取Class对象
 * @author: atong
 * @create: 2021-05-10 23:16
 */
public class BaseDataTypeClass {

    public static void main(String[] args) {
        //基本数据类型获取Class对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;

        System.out.println(integerClass);
        System.out.println(characterClass);
        System.out.println(booleanClass);

        //包装类型获取Class对象
        Class<Integer> integerClass1 = Integer.TYPE;
        Class<Character> characterClass1 =  Character.TYPE;
        Class<Boolean> booleanClass1 = Boolean.TYPE;

        //基本数据类型和其包装类型的Class对象是一个
        System.out.println(integerClass.hashCode());
        System.out.println(integerClass1.hashCode());
    }
}
