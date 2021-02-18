package io.file;

import java.io.File;

/**
 * @program: draft
 * @description: File delete api
 * @author: atong
 * @create: 2021-02-03 19:52
 */
public class FileDelete {
    public static void main(String[] args) {
        //删除项目根路径下的文件,删除成功返回true,删除失败返回false
        File file = new File("dd.txt");
        boolean delete = file.delete();
        System.out.println(delete);

        //注意：delete删除的文件夹下面不能有文件或者文件夹
        File filed = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file");
        boolean deleted = filed.delete();
        System.out.println(deleted);

        //根据路径删除文件
        File filee = new File("D:\\Document\\Github\\Draft\\src\\main\\java\\io\\file\\file");
        boolean deletee = filee.delete();
        System.out.println(deletee);
    }
}
