package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 09:40
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class This {
    private int i = 0;
    This (int i) {
        this.i = i + 1;
        System.out.println("int constructor.i = " + i + ";this.i = " + this.i);
        System.out.println("i - 1  = " + (i - 1) + ";this.i + 1 = " + (this.i + 1));
    }

    This (String s) {
        System.out.println("String constructor = " + s);
    }

    This (int i,String s) {
        //this调用第二个构造函数，this必须放在当前构造方法第一行
        this(s);
        this.i = i++;
        System.out.println("int constructor.i = " + i + ";String constructor = " + s);
    }

    public This increment() {
        this.i++;
        return this;//返回当前对象，该对象属于This
    }
}

class ThisMain {
    public static void main(String[] args) {
        This t0 = new This(10);
        This t1 = new This("ok");
        This t2 = new This(20,"ok again!");

        System.out.println(t0.increment().increment().increment());
    }
}
