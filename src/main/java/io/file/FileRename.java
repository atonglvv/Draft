package io.file;

import java.io.File;
import java.io.IOException;

/**
 * @program: draft
 * @description: File rename api
 * renameTo不止可以改名还可以改路径
 * @author: atong
 * @create: 2021-02-03 20:00
 */
public class
FileRename {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file\\file.txt");
        boolean fileNewFile = file.createNewFile();
        System.out.println(fileNewFile);

        boolean rename = file.renameTo(new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file\\filea.txt"));
        System.out.println(rename);

        //改名并修改路径
        boolean renamea = file.renameTo(new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\filea.txt"));
        System.out.println(rename);

    }
}
