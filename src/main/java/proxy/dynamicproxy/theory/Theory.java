package proxy.dynamicproxy.theory;

import proxy.Play;

import java.lang.reflect.Method;

/**
 * @program: draft
 * @description: 动态代理原理
 * @author: atong
 * @create: 2021-07-12 20:51
 */
public class Theory {
    public static void main(String[] args) {

    }

    public Play createProxyInstance (final InvokeHandler handler, final Class<?> clazz) {
        return new Play() {
            @Override
            public void play() {
                try {
                    Method palyMethod = clazz.getMethod("paly");
                    handler.invoke(this, palyMethod);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}


interface InvokeHandler {
    Object invoke(Object obj, Method method, Object... args);
}
