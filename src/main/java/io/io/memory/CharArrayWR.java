package io.io.memory;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @program: draft
 * @description: CharArrayWriter and CharArrayReader
 * @author: atong
 * @create: 2021-02-22 22:13
 */
public class CharArrayWR {
    public static void main(String[] args) throws IOException {
        CharArrayWriter caw = new CharArrayWriter();
        char[] chs = { 'h', 'e', 'l', 'l','o'};
        caw.write( chs);

        caw.close();
        char[] data = caw.toCharArray();

        CharArrayReader car = new CharArrayReader(data);
        int ch;
        while((ch=car.read())!=-1) {
            System.out.println((char) ch);
        }
        car.close();
    }
}

