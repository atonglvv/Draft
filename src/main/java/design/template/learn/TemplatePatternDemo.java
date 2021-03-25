package design.template.learn;

/**
 * @program: draft
 * @description: 调用方
 * 模板方法模式
 * 参考: 菜鸟教程 https://www.runoob.com/design-pattern/template-pattern.html
 *
 * 模板模式的核⼼设计思路是通过在抽象类中定义抽象⽅法的执⾏顺序，并将抽象⽅法设定为只有⼦类
 * 实现，但不设计 独⽴访问 的⽅法。简单说也就是把你安排的明明⽩⽩的。
 *
 * @author: atong
 * @create: 2021-03-24 17:03
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
