package lambda;

public class Lambda1 {
    public static void main(String[] args) {
        Play play = new PlayLol();
        play.play();
    }
}

//实现类
class PlayLol implements Play {

    @Override
    public void play() {
        System.out.println("Play LoL1 ...");
    }
}