package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 16:33
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 * 电脑computer类
 *  具有属性品牌（brand）、种类type（台式机、笔记本、pad）
 *  具有开机open、工作work和关机close的方法
 *    电脑开机输出“【brand】【type】启动。。。”。
 *    电脑工作输出“【brand】【type】工作中。。。”
 *    电脑关机输出“【brand】【type】关闭。。。”
 *  电脑computer类创建时自动输出“这是一台【brand】【type】电脑。”
 * 请 创建一个联想台式机和一个DELL笔记本电脑实例，并完成下列操作
 *  联想台式机启动，
 *  联想台式机工作
 *  DELL笔记本电脑启动
 *  联想台式机关机
 *  DELL笔记本电脑工作
 */
public class Computer {
    private String brand;
    private String type;

    public Computer(String brand,String type) {
        this.brand = brand;
        this.type = type;
        System.out.println("这是一台【" + this.brand + "】【" + this.type + "】电脑。");
    }

    public void open() {
        System.out.println("【" + this.brand + "】 【" + this.type + "】 启动。。。");
    }
    public void work() {
        System.out.println("【" + this.brand + "】 【" + this.type + "】 工作中。。。");
    }
    public void close() {
        System.out.println("【" + this.brand + "】 【" + this.type + "】 关闭。。。");
    }

    public static void main(String[] args) {
        Computer lenovo = new Computer("Lenovo","台式机");
        Computer dell = new Computer("Dell","台式机");
        lenovo.open();
        lenovo.work();
        dell.open();
        lenovo.close();
        dell.work();

    }
}
