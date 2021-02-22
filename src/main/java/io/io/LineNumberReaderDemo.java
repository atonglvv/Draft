package io.io;

import java.io.*;

/**
 * @program: draft
 * @description:
 * LineNumberReader是一个可以获得和设置行号的字符缓冲输入流。
 * LineNumberReader继承自BufferedReader。
 *
 * @author: atong
 * @create: 2021-02-20 21:11
 */
public class LineNumberReaderDemo {

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader( "names.txt"));
        LineNumberReader reader = new LineNumberReader(new FileReader( "src\\main\\java\\io\\io\\names.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            //打印每一行数据的时候，把行号输出来
            System.out.println(reader.getLineNumber() + ":" + line);
        }
        reader.close();
    }
}
