package proxy.staticproxy;

/**
 * 静态代理
 */
public class StaticProxy {

    public static void main(String[] args) {
        PlayLoL playLoL = new PlayLoL();
        //构造器注入
        PlayProxy playProxy = new PlayProxy(playLoL);
        //代理PlayLoL的paly方法
        playProxy.play();
    }
}
