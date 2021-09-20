package io.file;

import common.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: draft
 * @description: 将List数据写到文件中
 * @author: atong
 * @create: 2021-08-11 22:34
 */
public class ListToFile {

    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "name1", 18));
        users.add(new User(2L, "name2", 19));
        users.add(new User(3L, "name3", 20));
        users.add(new User(4L, "name4", 21));
        users.add(new User(5L, "name5", 22));
        users.add(new User(6L, "name6", 23));
        users.add(new User(7L, "name7", 24));
        users.add(new User(8L, "name8", 25));
        String fullFilePath = generateFile(users, "businessId");
        System.out.println("文件已写入到" + fullFilePath);
    }

    public static String generateFile(List<?> listData, String businessId) throws IOException {
        String filePath = "D:\\";
        String fileName = "abc.txt";
        String fullFilePath = filePath + fileName;
        File file = new File(fullFilePath);

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < listData.size(); i++) {
                bw.write(listData.get(i).toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
        }
        return fullFilePath;
    }
}
