package spi;

/**
 * @program: draft
 * @description: Java SPI 实现类
 * @author: atong
 * @create: 2022-03-17 10:58
 */
public class SpiBasketball implements SpiBall{
    @Override
    public void play() {
        System.out.println("play basketball...");
    }
}
