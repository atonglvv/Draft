package io.file;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: draft
 * @description: File 的 获取功能
 * 获取绝对路径[文件在系统磁盘上的路径，从盘符开始，一直到文件/文件夹的名称就叫做绝对路径。]
 *
 * @author: atong
 * @create: 2021-02-18 21:06
 */
public class FileObtain {
    public static void main(String[] args) {
        File file = new File("pom.xml");

        //获取绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        //获取相对路径
        String path = file.getPath();
        System.out.println(path);

        //获取文件名[不带路径,只有文件夹或者文件名]
        String name = file.getName();
        System.out.println(name);

        //获取长度,字节数。文件夹.length() = 0
        long length = file.length();
        System.out.println(length);

        //获取修改日期
        long lastModified = file.lastModified();
        System.out.println(lastModified);
        Date date = new Date(lastModified);
        System.out.println(date.toString());


        File files = new File("src");
        //获取指定目录下的所有文件或者文件夹的名称数组
        String[] list = files.list();
        System.out.println(Arrays.toString(list));

        System.out.println("======");

        //获取指定目录下的所有文件或者文件夹的File数组
        File[] filess = files.listFiles();
        System.out.println(Arrays.toString(filess));

    }
}
