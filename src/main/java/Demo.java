import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description: demo
 * @author: atong
 * @create: 2021-07-23 17:58
 */
public class Demo {
    public static void main(String[] args) {
        String aa = "手机/电子产品";
        String s = get(aa);
        System.out.println(s);


        String a1 = "手机";
        String a2 = "电子产品";
        List<String> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        String str = getStr(list);
        System.out.println(str);

    }

    public static String get(String aa) {
        String[] split = aa.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0 ; i--) {
            sb.append(split[i]);
            if (i != 0){
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static String getStr (List<String> list) {
        String collect = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining("/"));
        return collect;
    }
}
