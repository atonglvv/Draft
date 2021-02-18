package io.file;

import java.io.File;

/**
 * @program: draft
 * @description: File 判断相关方法
 * @author: atong
 * @create: 2021-02-03 20:09
 */
public class FileIf {
    public static void main(String[] args) {
        File file = new File("aa");
        File filea = new File("bb");
        File fileb = new File("c.txt");

        //判断是否是目录
        file.isDirectory();

        //判断是否是文件
        file.isFile();

        //判断是否存在
        fileb.exists();

        //判断是否可读
        fileb.canRead();

        //判断是否可写
        fileb.canWrite();

        //判断是否隐藏
        fileb.isHidden();
    }
}
