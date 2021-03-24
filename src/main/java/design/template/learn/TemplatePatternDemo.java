package design.template.learn;

/**
 * @program: draft
 * @description: 调用方
 * 模板方法模式
 * 参考: 菜鸟教程 https://www.runoob.com/design-pattern/template-pattern.html
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
