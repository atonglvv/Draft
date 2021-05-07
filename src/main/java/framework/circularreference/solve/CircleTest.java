package framework.circularreference.solve;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: draft
 * @description:
 * 自己实现循环依赖问题解决
 *
 * getBean，是整个解决循环依赖的核心内容，
 * ClazzA 创建后填充属性时依赖 ClazzB，那么就去创建 ClazzB，在创建 ClazzB 开始填充时发现依赖于 ClazzA，
 * 但此时 ClazzA 这个半成品对象已经存放在缓存到singletonObjects 中了，
 * 所以 ClazzB 可以正常创建，再通过递归把 ClazzA 也创建完整了。
 *
 * @author: atong
 * @create: 2021-05-07 11:12
 */
public class CircleTest {

    private final static Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    public static void main(String[] args) throws Exception {
        System.out.println(getBean(ClazzB.class).getClazzA());
        System.out.println(getBean(ClazzA.class).getClazzB());
    }

    private static <T> T getBean(Class<T> beanClass) throws Exception {
        String beanName = beanClass.getSimpleName().toLowerCase();
        //先从缓冲中查, 若缓存中有 则 直接返回
        if (singletonObjects.containsKey(beanName)) {
            return (T) singletonObjects.get(beanName);
        }
        // 先 实例化对象入缓存
        Object obj = beanClass.newInstance();
        singletonObjects.put(beanName, obj);
        // 后 属性填充补全对象
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            //从缓存中获取 需要注入的对象, 如果缓存中没有 则 递归调用getBean方法获取 需要注入的对象
            field.set(obj, singletonObjects.containsKey(fieldBeanName) ? singletonObjects.get(fieldBeanName) : getBean(fieldClass));
            field.setAccessible(false);
        }
        return (T) obj;
    }

}
