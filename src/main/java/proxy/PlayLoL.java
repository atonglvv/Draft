package proxy;

/**
 * 实现Play接口，被代理类
 */
public class PlayLoL implements Play{
    @Override
    public void play() {
        System.out.println("Play LoL ...");
    }
}
