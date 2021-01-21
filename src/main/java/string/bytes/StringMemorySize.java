package string.bytes;

/**
 * @program: draft
 * @description: Java对象运行时内存大小
 * @author: atong
 * @create: 2021-01-21 13:41
 */
public class StringMemorySize {
    public static void main(String[] args) {

        String s0 = "ilove";
        String s1 = "我爱";
        System.out.println(s0.getBytes().length);
        System.out.println(s1.getBytes().length);

        StringBuilder stringEn10000 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringEn10000.append("a");
        }
        double sizeEn = getMemorySize(stringEn10000.toString());
        System.out.println("长度为10000(一万的)英文String,内存占用大小为: " + sizeEn + "KB");


        StringBuilder stringCn10000 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringCn10000.append("中");
        }
        double sizeCn = getMemorySize(stringCn10000.toString());
        System.out.println("长度为10000(一万的)中文String,内存占用大小为: " + sizeCn + "KB");

    }

    public static double getMemorySize(String str) {
        return str.getBytes().length/1024.0;
    }
}
