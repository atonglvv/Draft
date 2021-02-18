package io.file;

import java.io.File;
import java.io.IOException;

/**
 * @program: draft
 * @description: File Create
 * @author: atong
 * @create: 2021-02-02 20:04
 */
public class FileCreate {
    public static void main(String[] args) throws IOException {
        //如果不存在这样的文件则调用createNewFile()方法,创建文件
        File file = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file\\cc.txt");
        try {
            //创建成功返回true,创建失败返回false
            boolean createFile = file.createNewFile();
            System.out.println(createFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //如果没有指明创建文件的路径,那么该文件创建于项目路径下
        File filed = new File("dd.txt");
        boolean createFilea = filed.createNewFile();
        System.out.println(createFilea);

        //如果路径不存在则不能创建 java.io.IOException: 系统找不到指定的路径,所以创建文件时路径必须存在否则抛异常
        File filee = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\nonono\\ee.txt");
        boolean createFilee = filee.createNewFile();
        System.out.println(createFilee);
    }
}
