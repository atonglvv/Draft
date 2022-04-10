package spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: draft
 * @description: Spi 示例
 * @author: atong
 * @create: 2022-03-17 11:00
 */
public class SpiDemo {
    public static void main(String[] args) {
        ServiceLoader<SpiBall> serviceLoader = ServiceLoader.load(SpiBall.class);
        Iterator<SpiBall> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            SpiBall ball = iterator.next();
            ball.play();
        }
    }
}