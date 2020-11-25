package lambda;

/**
 * 局部内部类
 */
public class Lambda3 {
    public static void main(String[] args) {
        //局部内部类
        class PlayLol implements Play {
            @Override
            public void play() {
                System.out.println("Play LoL3 ...");
            }
        }

        Play play = new PlayLol();
        play.play();

    }
}
