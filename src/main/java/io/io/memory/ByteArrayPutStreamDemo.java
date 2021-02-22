package io.io.memory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @program: draft
 * @description: ByteArrayPutStream Demo
 * @author: atong
 * @create: 2021-02-22 21:58
 */
public class ByteArrayPutStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建内存字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //往内存中写数据
        baos.write("hello".getBytes());

        //内存输出流 本身提供了一个方法 可以返回内存中的数据引用
        byte[] data = baos.toByteArray();
        System.out.println(new String(data));

        //内存输入流,ca 贼tm鸡肋
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        int ch;
        while ((ch=bais.read()) != -1) {
            System.out.println((char)ch);
        }

        baos.close();
        bais.close();
    }
}
