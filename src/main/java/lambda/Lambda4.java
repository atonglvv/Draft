package lambda;

/**
 * 匿名内部类
 */
public class Lambda4 {
    public static void main(String[] args) {
        //匿名内部类实现
        Play play = new Play() {
            @Override
            public void play() {
                System.out.println("Play LoL4 ...");
            }
        };
        play.play();
    }
}
