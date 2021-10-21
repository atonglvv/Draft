package jvm.heap;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: draft
 * @description: 堆内存空间 OOM
 * @author: atong
 * @create: 2021-10-21 22:14
 */
public class HeapOOMError {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while(true){
            try {
                Thread.sleep( 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024 * 1024)));
        }

    }
}

class Picture{
    private byte[] pixels;
    public Picture(int length) {
        this.pixels = new byte[length];
    }
}

