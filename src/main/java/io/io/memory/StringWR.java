package io.io.memory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @program: draft
 * @description: StringWriter And Reader
 * @author: atong
 * @create: 2021-02-22 22:56
 */
public class StringWR {
    public static void main(String[] args) throws IOException {
        StringWriter sw = new StringWriter();
        sw.write("hello");
        sw.close();

        String str = sw.toString();
        StringReader sr = new StringReader(str);
        int ch;
        while ((ch=sr.read() )!=-1) {
            System.out.print(( char)ch);
        }
    }

}
