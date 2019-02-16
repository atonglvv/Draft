package basics;

/**
 * @Auther: carver
 * @Date: 2019/1/18 16:07
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Draft {

    public static void main (String[] args) {

        int[] array = {1,2,3};
        System.out.println(array[1]);

        //匿名内部类
        Object o = new Object() {
            //重写了equals(),不管参数是什么，都是返回true
            public boolean equals(Object obj) {
                return true;
            }
        };

        System.out.println(o.equals("dk"));
    }
}
