package io.file;

import java.io.File;

/**
 * @program: draft
 * @description: File Api Test
 * @author: atong
 * @create: 2021-02-02 19:03
 */
public class FileDemo {
    public static void main(String[] args) {
        //常用构造方法
        //构造方法1
        File file = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file\\file.txt");
        //构造方法2
        File filea = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file", "file.txt");
        //构造方法3
        File fileb = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file");
        File filec = new File(fileb, "file.txt");



    }
}
