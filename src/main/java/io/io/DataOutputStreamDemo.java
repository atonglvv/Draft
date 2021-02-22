package io.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: draft
 * @description: Data Stream Demo
 * @author: atong
 * @create: 2021-02-22 20:44
 */
public class DataOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        //创建数据输出流对象
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("src\\main\\java\\io\\io\\dos.txt"));

        //写数据
        dos.writeByte(100);
        dos.writeShort(110);
        dos.writeChar('a');
        dos.writeInt(1);
        dos.writeLong(8L);
        dos.writeFloat(2.3f);
        dos.writeDouble(6.6);
        dos.writeBoolean(false);
        dos.writeUTF("HelloDa DataOutputStream");

        dos.close();

    }
}
