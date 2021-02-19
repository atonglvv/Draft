package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: draft
 * @description:
 * 通过IO流往文件中写入一句话"HelloWorld"
 *
 * 步骤：
 * 1.创建流对象(输出管道)
 * 2.把数据变成字节数据
 * 3.用管道传输数据至文件
 * @author: atong
 * @create: 2021-02-19 22:17
 */
public class OutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //流对象会创建a.txt
            fos = new FileOutputStream("a.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //把数据变成字节数据
        String data = "hello IO";
        byte[] bytes = data.getBytes();

        try {
            //通过管道把数据写进文件
            fos.write(bytes);
            //关闭管道
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
