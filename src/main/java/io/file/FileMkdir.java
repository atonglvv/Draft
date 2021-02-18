package io.file;

import java.io.File;

/**
 * @program: draft
 * @description: File mkdir/mkdirs Api
 * @author: atong
 * @create: 2021-02-02 20:35
 */
public class FileMkdir {
    public static void main(String[] args) {
        File file = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\filea");
        //该方法不能创建多层文件夹,如果io和filea都不存在,则不会创建成功
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);

        //mkdirs可创建多层文件夹
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);

        //如果File不指明路径,则在项目根路径下创建文件夹
        File filea = new File("bb");
        boolean mkdira = filea.mkdir();
        System.out.println(mkdira);

    }
}
