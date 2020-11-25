package proxy.staticproxy;

/**
 * 代理类，也需要实现Play接口
 */
public class PlayProxy implements Play{

    private PlayLoL playLoL;

    /**
     * 构造器注入
     * @param playLoL
     */
    public PlayProxy(PlayLoL playLoL) {
        this.playLoL = playLoL;
    }

    @Override
    public void play() {
        before();
        playLoL.play();
        after();
    }

    //前置处理
    private void before() {
        System.out.println("开机上号...");
    }

    //后置处理
    private void after() {
        System.out.println("下号关机...");
    }


}
