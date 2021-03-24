package design.template.learn;

/**
 * @program: draft
 * @description: 模板方法模式
 * 抽象父类
 * 参考: 菜鸟教程 https://www.runoob.com/design-pattern/template-pattern.html
 * @author: atong
 * @create: 2021-03-24 16:50
 */
public abstract class Game {
    /**
     * 抽象方法 初始化游戏
     */
    abstract void initialize();

    /**
     * 抽象方法 开始游戏
     */
    abstract void startPlay();

    /**
     * 抽象方法 游戏结束
     */
    abstract void endPlay();

    /**
     * 模板方法
     */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
