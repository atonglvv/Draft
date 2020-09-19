package thread.daemon;

public class ThreadDaemon {
    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        UserThread userThread = new UserThread();

        Thread thread_daemon = new Thread(daemonThread);
        Thread thread_user = new Thread(userThread);

        //将thread_daemon设置为守护线程
        thread_daemon.setDaemon(true);

        thread_daemon.start();
        thread_user.start();
    }
}

class DaemonThread implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("DaemonThread...");
        }
    }
}

class UserThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("UserThread...");
        }
        System.out.println("UserThread For end...");
    }
}
