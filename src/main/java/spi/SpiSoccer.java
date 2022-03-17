package spi;

/**
 * @program: draft
 * @description: Java SPI 实现类
 * @author: atong
 * @create: 2022-03-17 10:59
 */
public class SpiSoccer implements SpiBall{
    @Override
    public void play() {
        System.out.println("play soccer...");
    }
}
