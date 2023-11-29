package string.exercises;

/**
 * @program: draft
 * @description: String练习
 * @author: atong
 * @create: 2021-05-25 17:44
 */
public class StringExercises {
    public static void main(String[] args) {
        // pages/classifyPage/goodDetail/goodDetail?id=1394109191047618622&roomid=
        // String url = "pages/classifyPage/spellGroupDetail/spellGroupDetail?id=1394946388592173126";
        String url = "www.baidu.com";
        int indexb = url.lastIndexOf("?id=");
        System.out.println("indexb = " + indexb);
        int indexa = url.indexOf("&", indexb);
        System.out.println("indexa = " + indexa);
        Long aLong = Long.valueOf(url.substring(indexb + 4, indexa));
        System.out.println(aLong);
    }
}
