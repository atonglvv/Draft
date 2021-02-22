package io.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: draft
 * 注意：怎么写进去的就要怎么读出来。顺序不能乱
 * 应用场景：网络编程
 * @description: DataInputStreamDemo
 * @author: atong
 * @create: 2021-02-22 20:50
 */
public class DataInputStreamDemo {



    public static void main(String[] args) throws IOException {
        //创建数据输入流对象
        DataInputStream dis = new DataInputStream(new FileInputStream("src\\main\\java\\io\\io\\dos.txt"));

        //读数据->怎么写进去的就要怎么读出来。顺序不能乱
        System.out.println(dis.readByte());
        System.out.println(dis.readShort());
        System.out.println(dis.readChar());
        System.out.println(dis.readInt());
        System.out.println(dis.readLong());
        System.out.println(dis.readFloat());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readUTF());

        dis.close();

    }
}
