package lambda;

/**
 * 静态内部类
 */
public class Lambda2 {
    //静态内部类
    static class PlayLol implements Play {
        @Override
        public void play() {
            System.out.println("Play LoL2 ...");
        }
    }
    public static void main(String[] args) {
        Play play = new lambda.PlayLol();
        play.play();
    }
}
