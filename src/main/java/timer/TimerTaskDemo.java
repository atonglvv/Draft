package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: draft
 * @description: Timer实现的定时任务
 * @author: atong
 * @create: 2020-10-30 14:42
 */
public class TimerTaskDemo {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {

            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                System.out.println("Run timerTask : " + simpleDateFormat.format(new Date()));
            }
        };

        //Alibaba建议使用ScheduledExecutorService代替Timer
        //计时器
        Timer timer = new Timer();
        //添加执行任务（延迟 1s 执行，每 3s 执行一次）
        timer.schedule(timerTask, 1000, 1000);
    }

}
