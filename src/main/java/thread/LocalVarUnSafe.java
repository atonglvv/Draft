package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: draft
 * @description: 局部变量线程不安全
 * @author: atong
 * @create: 2022-01-13 11:30
 */
public class LocalVarUnSafe {

    public static void main(String[] args) {
        int num = 10;
        for (int i = 0; i < 30; i++) {
            new Thread(){
                @Override
                public void run () {
                }
            }.start();
        }
    }
}
