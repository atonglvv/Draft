package proxy.dynamicproxy;

import proxy.Play;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: draft
 * @description: Handler类
 * @author: atong
 * @create: 2021-01-27 10:32
 */
public class PlayHandler implements InvocationHandler {

    private Play play;

    public PlayHandler(Play play) {
        this.play = play;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开机上号...");
        method.invoke(play);
        System.out.println("下号关机...");
        return play;
    }
}
