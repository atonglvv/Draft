package basics;

/**
 * @Auther: carver
 * @Date: 2019/2/16 20:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Object {

    public static void main(String[] args) throws InterruptedException {
        java.lang.Object object = new java.lang.Object();
        object.toString();
        object.equals(object);
        object.hashCode();
        object.getClass();
        object.notify();
        object.notifyAll();
        //throws InterruptedException
        object.wait();
    }


}
