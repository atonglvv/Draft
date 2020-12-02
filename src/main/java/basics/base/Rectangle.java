package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 10:58
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 分别创建类：Rectangle（长方形）、cuboid（长方体），cuboid继承自Rectangle。
 *    Rectangle具有length、width的私有属性，有area()函数计算面积，有tostring()函数可以     打印长方形信息，打印格式为：长方形长**，宽**，面积为**。
 *    cuboid具有Rectangle的属性之外，还有新的私有属性high；有新的函数volume()计算体积，也有totring函数可以打印长方体信息，打印格式为：长方体长**，宽**，高**，体积为**。
 *    创建测试类完成以下功能：
 *    创建一个长方形A，长6宽3，打印出长方形基本信息；
 *    创建一个长方体B，长5宽4高3，打印出长方体基本信息。
 */
public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length,int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return this.length * this.width;
    }

    @Override
    public String toString() {
        return "长方形长" + this.length + ",宽" + this.width + ",面积为" + area();
    }

}

class Cuboid extends Rectangle {
    private int length;
    private int width;
    private int high;

    public Cuboid(int length, int width) {
        super(length,width);
        this.length = length;
        this.width = width;
    }

    public Cuboid(int length, int width,int high) {
        this(length,width);
        this.high = high;
    }

    public int volume() {
        return this.length * this.width * this.high;
    }

    @Override
    public String toString() {
        return "长方体长" + this.length + ",宽" + this.width + ",高" + this.high + ",面积为" + volume();
    }
}


class RectangleTest {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(6,3);
        System.out.println(rectangle);
        Cuboid cuboid = new Cuboid(5, 4, 3);
        System.out.println(cuboid);
    }
}