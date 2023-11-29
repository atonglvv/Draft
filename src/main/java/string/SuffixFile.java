package string;

/**
 * @program: draft
 * @description: 文件后缀名截取
 * @author: atong
 * @create: 2021-08-24 22:01
 */
public class SuffixFile {
    public static void main(String[] args) {
        String fileName = "https://picture.cn/web-file/2/excel/33773/c993ea9c1b724bafb56a2eae66fcc095.xlsx";
        String substring = fileName.substring(fileName.lastIndexOf('.'));
        System.out.println(substring);
    }
}
